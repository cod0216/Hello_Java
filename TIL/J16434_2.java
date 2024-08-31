package TIL;

import java.io.*;
import java.util.*;

/*
maxH
curH
attH

N개 방 i번째 방을 통해서만 i+1번째로 이동 가능
몬스터 쳐치 후 다음 방 이동 가능

N째 방에는 공주와 용이 있음
용 무ㅂ찌르면 공주 구함

교전 규칙
1. 용사 attH 만큼 용 체력 깍음
2. 몬스터 HP 0 이하면 전투 종료 밑 다음 방 이동 (if문)
3. 몬스터 공격만큼 용사 생명력 Hcuphp 깎기
4. 용사 생명력 0 이하면 전투 종료 및 용사 사망
5. 다시 1부터 진행

-----

포션방 인 경우 용사 생명력 curH가 일정 회복 max이상이면 Hmax

용을 쓰러트리기 위한 최소 Hmax 구하라


N < 123,456     - 방 개수
att H           - 초기 공격력

1인 경우 몬스터 공격력, 생명력
2인 경우 용사 공격력 증가, 회복량 물약


선공 : 용사
후공 : 몬스터
//  8

6 8

17
16 * 3
48


깎인 값보다 포션 양이 많으면 무시 ㄱ
적으면 다음 공격 값 + 남은 값
 */
public class J16434_2 {
    static ArrayList<int[]>[] rooms;
    static long monsterHP;
    static long monsterAttack;
    static long maxHP;
    static long damageHP;
    static long heroAttack;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        int rN = Integer.parseInt(input[0]);
        heroAttack = Integer.parseInt(input[1]);

        rooms = new ArrayList[rN];

        for (int i = 0; i < rN; i++) {
            rooms[i] = new ArrayList<>();
        }
        for (int i = 0; i < rN; i++) {
            input = buffer.readLine().split(" ");
            int type = Integer.parseInt(input[0]);
            switch (type) {
                case 1:
                    int monsterAttack = Integer.parseInt(input[1]);
                    int monsterHeart = Integer.parseInt(input[2]);
                    rooms[i].add(new int[]{type, monsterAttack, monsterHeart});
                    break;
                case 2:
                    int attack = Integer.parseInt(input[1]);
                    int recureH = Integer.parseInt(input[2]);
                    rooms[i].add(new int[]{type, attack, recureH});
                    break;
            }
        }
            /*
            처음 받는 데미지은 maxHP로 측정 +1 이 된다.
            두번째 부터는 포션 안먹는 경우 또 maxHP +1이 된다.
            포션 먹는 경우 maxHP 보다 포션이 작으면  nowHP에 포션 값 축적
            포션 먹는 경우 maxHP 보다 포션이 크면 nowHP 값에 축


             */

        for (int i = 0; i < rooms.length; i++) {
            flag = false;
            int[] room = rooms[i].get(0);
            if (room[0] == 1) {
                warInit(room[1], room[2]);
                damageHP += monsterAttack * ((monsterHP/heroAttack) - (monsterHP%heroAttack == 0 ? 1: 0));
                if(damageHP > maxHP){
                    maxHP = damageHP;
                }

            } else if (room[0] == 2) {
                attackUpdate(room[1]);
                recurHP(room[2]);
            }
        }
        System.out.println(++maxHP);
    }

    public static void recurHP(int potion) {
        damageHP -= potion;
        if(damageHP <=0) damageHP = 0;
    }


//    maxHP     ------
//    damageHP  ----

    public static void defence() {
        if ((damageHP + monsterAttack) >= maxHP) {
            damageHP += monsterAttack;
            maxHP = damageHP;
        } else damageHP += monsterAttack;
    }

    private static void attack() {
        monsterHP -= heroAttack; // 공격
        if (monsterHP <= 0) flag = true;
    }

    private static void attackUpdate(int attack) {
        heroAttack += attack;
    }

    private static void warInit(int attack, int HP) {
        monsterAttack = attack;
        monsterHP = HP;
    }
}

