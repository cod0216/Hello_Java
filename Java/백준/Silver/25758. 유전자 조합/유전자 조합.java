import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<String> list, same;
    static HashSet<String> mixSet;
    
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        
        HashSet<String> listSet = new HashSet<>();
        HashSet<String> sameSet = new HashSet<>();
        
        String[] input = buffer.readLine().split(" ");
        
        for(int i = 0; i < N; i++){
            if(!listSet.add(input[i])) sameSet.add(input[i]);
        }
        
        list = new ArrayList<>(listSet);
        same = new ArrayList<>(sameSet);
        
        mixSet= new HashSet<>();
        
        for(int i = 0; i < list.size() -1 ; i++){
            for(int j = i+1; j < list.size(); j++){            
                String a = list.get(i);
                String b = list.get(j);
                
                mixSet.add(a.charAt(0) + "" + b.charAt(1));
                mixSet.add(b.charAt(0) + "" + a.charAt(1));
            }
        }
        
        for(int i = 0 ; i < same.size(); i++){
            String s = list.get(i);
            mixSet.add(s.charAt(0) + "" + s.charAt(1));
            mixSet.add(s.charAt(1) + "" + s.charAt(0));
        }
        
        HashSet<Character> printType = new HashSet<>();
        for(String s : mixSet){
            char front = s.charAt(0);
            char back = s.charAt(1);
            if(front > back) printType.add(front);
            else if (front < back) printType.add(back);
            else printType.add(back);
        }
        
        LinkedList<Character> sortList = new LinkedList<>(printType);
        Collections.sort(sortList);
        
        System.out.println(sortList.size());
        for(char c : sortList){
            System.out.print(c + " ");
        }
    }
}
