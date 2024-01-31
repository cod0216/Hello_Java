package TIL;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test_Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String asd = bf.readLine();
        String N = asd.split(" ")[0];
        int B = Integer.parseInt(asd.split(" ")[1]);
        double[] lee = new double[N.length()];
        double sum = 0;

        for (int i = 0; i < N.length(); i++) {
            if(N.charAt(i) >= '0' && N.charAt(i) <= '9') lee[i] = N.charAt(i) - 48;
            else if (N.charAt(i) >= 'A' && N.charAt(i) <= 'Z') lee[i] = N.charAt(i) - 55;
        }

        for (int i = lee.length-1; i >= 0; i--) {
            sum += lee[i] * Math.pow(B, i);
        }

        System.out.println((int)sum);


    }
}


//
//import java.util.Scanner;
//
//public class test_Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String str1 = scanner.nextLine();
//        int var = scanner.nextInt();
//        scanner.nextLine();
//        String str2 = scanner.nextLine();
//
//
////        char[] lit = str2.toCharArray();
//
//        System.out.println("str1 :" + str1 + ", var :" + var + ", str2 :" + str2);
//    }
//}
//
//
///*
//
//사용 예제
//import java.io.*;
//import java.util.*;
//
//public class F0rTest {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		int N = Integer.parseInt(br.readLine());
//
//
//
//		for (int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			int count = Integer.parseInt(st.nextToken());
//			String S = st.nextToken();
//
//			for (int cou = 0; cou < S.length(); cou++) {
//				for (int X = 0; X < count; X++) {
//					bw.write(S.charAt(cou) + "");
//				}
//
//			}
//			//
//			bw.write("\n");
//
//		}
//
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//}
// */