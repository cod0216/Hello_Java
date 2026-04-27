import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger n = sc.nextBigInteger();
		
		if(n.remainder(new BigInteger("2")) == BigInteger.ZERO) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}
		
		sc.close();
	}

}
