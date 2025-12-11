import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int size=0;
        int[] arr = new int[8];
        String line;
        while ((line = buffer.readLine()) != null) {
            String[] input = line.split(" ");
            int idx = input.length;
            size += idx;

            for(int i = 0 ; i < idx; i++){
                String s = input[i];
                switch(s){
                    case "Re" :
                        arr[1] += 1;
                        break;
                    case "Pt" :
                        arr[2] += 1;
                        break;
                    case "Cc" :
                        arr[3] += 1;
                        break;                    
                    case "Ea" :
                        arr[4] += 1;
                        break;
                    case "Tb" :
                        arr[5] += 1;
                        break;
                    case "Cm" :
                        arr[6] += 1;
                        break;
                    case "Ex" :
                        arr[7] += 1;
                        break;
                }
            }
        }
        
        
        System.out.print("Re " + arr[1] + " ");
        System.out.printf("%.2f", (float)arr[1]/(float)size);
        System.out.println();
        System.out.print("Pt " + arr[2] + " ");
        System.out.printf("%.2f", (float)arr[2]/(float)size);
        System.out.println();
        System.out.print("Cc " + arr[3] + " ");
        System.out.printf("%.2f", (float)arr[3]/(float)size);
        System.out.println();
        System.out.print("Ea " + arr[4] + " ");
        System.out.printf("%.2f", (float)arr[4]/(float)size);
        System.out.println();
        System.out.print("Tb " + arr[5] + " ");
        System.out.printf("%.2f", (float)arr[5]/(float)size);
        System.out.println();
        System.out.print("Cm " + arr[6] + " ");
        System.out.printf("%.2f", (float)arr[6]/(float)size);
        System.out.println();
        System.out.print("Ex " + arr[7] + " ");
        System.out.printf("%.2f", (float)arr[7]/(float)size);
        System.out.println();
        System.out.println("Total " + size + " 1.00");
        
    }
}
