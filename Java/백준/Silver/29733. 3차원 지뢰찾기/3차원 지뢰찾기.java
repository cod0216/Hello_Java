import java.io.*;

  class Main {
      public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          String first = br.readLine();
          if (first == null) return;
          String[] input = first.trim().split(" ");
          int R = Integer.parseInt(input[0]);
          int C = Integer.parseInt(input[1]);
          int H = Integer.parseInt(input[2]);

          char[][][] grid = new char[H][R][C];
          for (int z = 0; z < H; z++) {
              for (int r = 0; r < R; r++) {
                  String line = br.readLine();
                  while (line != null && line.length() < C) {
                      String extra = br.readLine();
                      if (extra == null) break;
                      line += extra;
                  }
                  for (int c = 0; c < C; c++) {
                      grid[z][r][c] = line.charAt(c);
                  }
              }
          }

          char[][][] out = new char[H][R][C];
          for (int z = 0; z < H; z++) {
              for (int r = 0; r < R; r++) {
                  for (int c = 0; c < C; c++) {
                      if (grid[z][r][c] == '*') {
                          out[z][r][c] = '*';
                          continue;
                      }
                      int count = 0;
                      for (int dz = -1; dz <= 1; dz++) {
                          int nz = z + dz;
                          if (nz < 0 || nz >= H) continue;
                          for (int dr = -1; dr <= 1; dr++) {
                              int nr = r + dr;
                              if (nr < 0 || nr >= R) continue;
                              for (int dc = -1; dc <= 1; dc++) {
                                  int nc = c + dc;
                                  if (dc == 0 && dr == 0 && dz == 0) continue;
                                  if (nc < 0 || nc >= C) continue;
                                  if (grid[nz][nr][nc] == '*') count++;
                              }
                          }
                      }
                      out[z][r][c] = (char) ('0' + (count % 10));
                  }
              }
          }

          StringBuilder sb = new StringBuilder(H * R * (C + 1));
          for (int z = 0; z < H; z++) {
              for (int r = 0; r < R; r++) {
                  for (int c = 0; c < C; c++) {
                      sb.append(out[z][r][c]);
                  }
                  sb.append('\n');
              }
          }
          System.out.print(sb.toString());
      }
  }

