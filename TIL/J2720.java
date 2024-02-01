package TIL;

import java.util.Scanner;

public class J2720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] largeMoney = new int[n];
        int numQuarter = 0;
        int Quarter = 25;
        int numDime = 0;
        int Dime = 10;
        int numNickel =0;
        int Nickel = 5;
        int numPenny =0;
        int Penny = 1;

        for(int i = 0; i < n; i++){
            largeMoney[i] = scanner.nextInt();
            numQuarter = largeMoney[i] / Quarter;
            System.out.print(numQuarter + " ");
            largeMoney[i]=largeMoney[i]-(numQuarter*Quarter);
            numDime = largeMoney[i] / Dime;
            System.out.print(numDime + " ");
            largeMoney[i]=largeMoney[i]-(numDime*Dime);
            numNickel = largeMoney[i] / Nickel;
            System.out.print(numNickel + " ");
            largeMoney[i]=largeMoney[i]-(numNickel*Nickel);
            numPenny=largeMoney[i];
            System.out.println(numPenny);
        }
    }
}
