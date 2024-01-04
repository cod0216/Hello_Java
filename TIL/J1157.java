package TIL;

import java.util.Scanner;

public class J1157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] str = scanner.nextLine().toUpperCase().toCharArray();
        int index =0;
        int[] word= new int[26];
        int max_num = 0;

        for (int i = 0; i < str.length; i++)
        {
            index = str[i] - 'A';
            word[index]++;

            if (word[max_num] < word[index])
                max_num = index;
        }

        for(int i = 0; i < 26; i++)
        {
            if(i == max_num) continue;
            if(word[max_num] == word[i]){
                System.out.println("?");
                System.exit(0);
            }
        }
        System.out.println((char)(max_num+'A'));
    }
}
