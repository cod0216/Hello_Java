import java.io.*;
import java.util.*;

public class Main { 

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 26; j++) {
				map.put((char) (97 + j), 0);
			}
			String str = bf.readLine();
			for (int j = 0; j < str.length(); j++) {
				char x = str.charAt(j);
				if(Character.isAlphabetic(x)) {
					x=Character.toLowerCase(x);
					map.replace(x, map.get(x) + 1);
				}

			}
			int min = Integer.MAX_VALUE;
			for (Map.Entry<Character, Integer> set : map.entrySet()) {
				if (min > set.getValue()) {
					min = set.getValue();
				}
			}
			bw.write("Case "+ (i+1) +": ");
			if(min==0) {
				bw.write("Not a pangram\n");
			}else if(min==1) {
				bw.write("Pangram!\n");
			}else if(min==2) {
				bw.write("Double pangram!!\n");
			}else if(min==3) {
				bw.write("Triple pangram!!!\n");
			}
		}
		bw.flush();
	}
}