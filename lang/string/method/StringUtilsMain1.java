package lang.string.method;

public class StringUtilsMain1 {
    public static void main(String[] args) {
        int num = 100;
        Boolean bool = true;
        Object obj = new Object();
        String str = "Hello, Java1";

        String numString = String.valueOf(num);
        System.out.println("numString = " + numString);
        String boolString = String.valueOf(bool);
        System.out.println("boolString = " + boolString);
        String objString = String.valueOf(obj);
        System.out.println("objString = " + objString);
        String numString2 = "" + num;
        System.out.println("numString2 = " + numString2);

        char[] strCharArray = str.toCharArray();
        System.out.println("문자열을 문자 배열로 반환 : " + strCharArray);
        for (char c : strCharArray) {
            System.out.print(c);
        }
        System.out.println();
    }
}
