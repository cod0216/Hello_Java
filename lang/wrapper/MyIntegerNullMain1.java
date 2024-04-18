package lang.wrapper;

public class MyIntegerNullMain1 {
    public static void main(String[] args) {
        Integer[] intArr = {-1, 0, 1, 2, 3};
        System.out.println(findValue(intArr, -1));
        System.out.println(findValue(intArr, 0));
        System.out.println(findValue(intArr, 1));
        System.out.println(findValue(intArr, 100));

    }

    public static Integer findValue(Integer[] intArr, int target){
        for(Integer value : intArr){
            if(value == target){
                return value;
            }
        }
        return null;
    }
}
