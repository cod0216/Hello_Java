package TIL;

import java.util.Scanner;
//2941
public class J2941 {
    public static void main(String[] args) {
//        String[] cl={"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        char[] cl ={'c', '=', '-', 'd', 'z', 'l', 'j', 'n', 's'};
        int cnt = 0;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] Str=str.toCharArray();
        for(int i=0; i <Str.length; i++) {
            if(i == Str.length-1) {
                cnt++;
                break;
            }


            if (Str[i]=='c') {
                if ((Str[i+1] == '=') || (Str[i+1]=='-')) {
                    cnt++;
                    i += 1;
                    continue;
                }
            }

            if (Str[i] == 'd') {
                if (Str[i+1] == 'z') {
                    if ( (i < str.length()-2) && (Str[i+2] == '=')) {
                        cnt++;
                        i += 2;
                        continue;
                    }
                } else if (Str[i+1]== '-') {
                    cnt++;
                    i += 1;
                    continue;
                }
            }
            if (Str[i]=='l') {
                if (Str[i+1] == 'j') {
                    cnt++;
                    i += 1;
                    continue;
                }
            }
            if (Str[i] == 'n') {
                if (Str[i+1] == 'j') {
                    cnt++;
                    i += 1;
                    continue;
                }
            }
            if (Str[i]== 's') {
                if (Str[i+1] == '=') {
                    cnt++;
                    i += 1;
                    continue;
                }
            }
            if (Str[i]=='z') {
                if (Str[i+1] == '=') {
                    cnt++;
                    i += 1;
                    continue;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
