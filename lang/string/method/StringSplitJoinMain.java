package lang.string.method;

public class StringSplitJoinMain {
    public static void main(String[] args) {
        String str = "Apple,Banana,Orange";

        String[] spliterStr = str.split(",");
        for (String s : spliterStr) {
            System.out.println(s);
        }

        for(int i = 0; i < spliterStr.length; i++){
            System.out.print(spliterStr[i]);
            if(i != (spliterStr.length-1))
                    System.out.print("-");
        }
        System.out.println();


//        Join()
        String joinedStr = String.join("-", "A", "B", "C");
        System.out.println("joinedStr = " + joinedStr);

        String result = String.join("-", spliterStr);
        System.out.println("result = " + result);
    }
}
