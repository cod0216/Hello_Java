package TIL;

import java.nio.Buffer;
import java.util.*;
import java.io.*;

/*
maxHp : 용사 최대 체력
curHp : 용사 현재 체력
attac : 용사 공격력


N개의 방 -> arrayList
a, b, c

a: 1 타입
b : 몬스터 공격력
c: 몬스터 생명력

a : 2 타입
b : 용사 공격력
c : <현재>생명력 증가 -> maxHP 보다 커질수 없음

교전 수칙
1. 용사 공격  mosterHP - attack
if( monsterHP <=0) 다음방 이동 -> continue;


2. 용 공격 currentHP += monsterAttack



그대로 구현하면 오조오억 시간 초가 드립 칠거 같음

수학? -> go (핑핑이) / % + - *
구현?

3 3
1 1 20
용사 7
continue 될 예정

용 6

maxHP  -- 7

2 3 10

용사 공격력 6
체력 ?? 이거 최대치보다 크면 손해 (maxHp)
1 3 100


 */

public class J16433 {

    static ArrayList<int[]> rooms;
    static long heroAttack;
    static long herorMaxHp;
    static long herorCurHp;
    static long monsterAttack;
    static long monsterHp;


    static long roomCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        roomCnt = Integer.parseInt(input[0]);
        heroAttack = Integer.parseInt(input[1]);

        rooms = new ArrayList<>();
        for (int i = 0; i < roomCnt; i++) {
            input = buffer.readLine().split(" ");
            int type = Integer.parseInt(input[0]);

            switch (type) {
                case 1:
                    int monsterAttack = Integer.parseInt(input[1]);
                    int monsterHp = Integer.parseInt(input[2]);
                    rooms.add(new int[]{type, monsterAttack, monsterHp});
                    break;

                case 2:
                    int addAttack = Integer.parseInt(input[1]);
                    int recurHp = Integer.parseInt(input[2]);
                    rooms.add(new int[]{type, addAttack, recurHp});
                    break;
            }

        }

        for (int i = 0; i < roomCnt; i++) {
            /*
            1. 용사 공격  mosterHp - attack
            if( monsterHP <=0) 다음방 이동 -> continue;
            2. 용 공격 currentHP += monsterAttack
             */

            if (rooms.get(i)[0] == 1) {
                monsterAttack = rooms.get(i)[1];
                monsterHp = rooms.get(i)[2];
                long hit = 1;
                if (monsterHp % heroAttack != 0) hit = 0;

                herorCurHp = monsterAttack * ((monsterHp / heroAttack) - hit);
                herorMaxHp = Math.max(herorCurHp, herorMaxHp);
            } else { // 약물 먹방

                /*
                    1. 공격력 증가
                    2. 체력 회복
                     최대보다 크면 손해인듯
                     걍 크면 0

                 */
                heroAttack += rooms.get(i)[1];

                herorCurHp -= rooms.get(i)[2];
                if (herorCurHp < 0) herorCurHp = 0;

            }

            herorMaxHp++;


        }

        System.out.println(herorMaxHp);
    }
}
