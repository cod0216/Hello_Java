package TIL;

import java.io.*;
import java.util.*;


/*
택시  손님을 도착지로 데려다줄 때마다 연료가 충전되고, 연료가 바닥나면 그날의 엄무가 끝난다.

오늘 M명의 승객을 태우는 것이 목표이다.
N x N 크기의 격자
각 칸은 비어잏ㅆ거나 벽이 놓여있다.
상하좌우 인접한 빈칸중 하나로 이동 가능
최단 경로로만 이동

M명의 승객은 빈칸 중하나에 서있으며, 다른 빈칸 중 하나로 이동하려 한다.
여러 승객이 같이 탑승하는 경우는 없다.

따라서 백준은 한 승객을 태워 목적지로 이동시키는 일을 M번 반복해야 한다.

백준이 태울 승객을 고를 때는 현재 위치에서 최단 거리가 짧은 승객을 고른다.
그런 승객이 여러명 있으면 그중 행 ㅓㄴ호가 가장 작은 승객을 열번호가 가장 작은 생각을 고른다.

연료는 한칸 이동할때마다 1소모
목적지로 이동시 성공 승객을 태워 이동하면 소모한 연료의 양 두배가 충전
이동 ㄷ고중 연료 바닥시 이동 실패 업무 끝
이동시킨 동시에 연료가 바닥나는경우 실폐 ㄴㄴ


 */
public class J19238 {
    public static void main(String[] args) throws IOException {




    }
}