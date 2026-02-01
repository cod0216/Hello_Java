import java.util.*;
import java.io.*;

class Fish {
    int num;
    int posX;
    int posY;
    int dir;
    int live;

    public Fish(int num, int posX, int posY, int dir) {
        this.num = num;
        this.posX = posX;
        this.posY = posY;
        this.dir = dir;
        this.live = 1;
    }
}

public class Main {
    static int answer = 0;

    static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = new int[]{0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[4][4];
        ArrayList<Fish> fishes = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            String[] input = buffer.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(input[0 + j * 2]);
                int dir = Integer.parseInt(input[1 + j * 2]) - 1;

                fishes.add(new Fish(num, i, j, dir));
                board[i][j] = num;
            }
        }

        int firstNum = board[0][0];
        int firstDir = 0;

        for (Fish f : fishes) {
            if (f.num == firstNum) {
                f.live = -1;
                firstDir = f.dir;
                break;
            }
        }

        int initScore = firstNum;
        board[0][0] = -1;

        dfs(board, fishes, 0, 0, firstDir, initScore);

        System.out.println(answer);
    }

    static void dfs(int[][] board, ArrayList<Fish> fishes, int sX, int sY, int sD, int curScore) {
        answer = Math.max(answer, curScore);

        moveFishes(board, fishes);

        ArrayList<int[]> candidates = getCandidates(board, sX, sY, sD);
        if (candidates.size() == 0) return;

        for (int[] c : candidates) {
            int nx = c[0];
            int ny = c[1];

            int fishNum = board[nx][ny];
            if (fishNum <= 0) continue;

            int[][] nextBoard = copyBoard(board);
            ArrayList<Fish> nextFishes = copyFishes(fishes);

            int nextDir = 0;
            for (Fish f : nextFishes) {
                if (f.live != 1) continue;
                if (f.num == fishNum) {
                    f.live = -1;
                    nextDir = f.dir;
                    break;
                }
            }

            int nextScore = curScore + fishNum;

            nextBoard[sX][sY] = 0;
            nextBoard[nx][ny] = -1;

            dfs(nextBoard, nextFishes, nx, ny, nextDir, nextScore);
        }
    }

    static ArrayList<int[]> getCandidates(int[][] board, int sX, int sY, int sD) {
        ArrayList<int[]> candidates = new ArrayList<>();

        for (int step = 1; step <= 3; step++) {
            int nx = sX + dx[sD] * step;
            int ny = sY + dy[sD] * step;

            if (!isIn(nx, ny)) break;
            if (board[nx][ny] == 0) continue;
            if (board[nx][ny] == -1) continue;

            candidates.add(new int[]{nx, ny});
        }
        return candidates;
    }

    static void moveFishes(int[][] board, ArrayList<Fish> fishes) {
        for (int num = 1; num <= 16; num++) {
            Fish fish = findFish(fishes, num);
            if (fish == null) continue;
            if (fish.live != 1) continue;

            int cx = fish.posX;
            int cy = fish.posY;
            int cd = fish.dir;

            for (int rot = 0; rot < 8; rot++) {
                int nd = (cd + rot) % 8;
                int nx = cx + dx[nd];
                int ny = cy + dy[nd];

                if (!isIn(nx, ny)) continue;
                if (board[nx][ny] == -1) continue;

                fish.dir = nd;

                if (board[nx][ny] == 0) {
                    board[cx][cy] = 0;
                    board[nx][ny] = num;

                    fish.posX = nx;
                    fish.posY = ny;
                } else {
                    int otherNum = board[nx][ny];
                    Fish other = findFish(fishes, otherNum);

                    board[cx][cy] = otherNum;
                    board[nx][ny] = num;

                    other.posX = cx;
                    other.posY = cy;

                    fish.posX = nx;
                    fish.posY = ny;
                }
                break;
            }
        }
    }

    static Fish findFish(ArrayList<Fish> fishes, int num) {
        for (Fish f : fishes) {
            if (f.num == num) return f;
        }
        return null;
    }

    static int[][] copyBoard(int[][] board) {
        int[][] copied = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copied[i][j] = board[i][j];
            }
        }
        return copied;
    }

    static ArrayList<Fish> copyFishes(ArrayList<Fish> fishes) {
        ArrayList<Fish> copied = new ArrayList<>();
        for (Fish f : fishes) {
            Fish nf = new Fish(f.num, f.posX, f.posY, f.dir);
            nf.live = f.live;
            copied.add(nf);
        }
        return copied;
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < 4 && y < 4;
    }
}
