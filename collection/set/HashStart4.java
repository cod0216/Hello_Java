package collection.set;

import java.util.Arrays;

public class HashStart4 {
    public static void main(String[] args) {
        Integer[] inputArray = new Integer[10];
        inputArray[hashIndex(1)] = 1;
        inputArray[hashIndex(2)] = 2;
        inputArray[hashIndex(5)] = 5;
        inputArray[hashIndex(8)] = 8;
        inputArray[hashIndex(99)] = 99;

        System.out.println("inputArray = " + Arrays.toString(inputArray));

        int searchValue = 99;
        int hashValue = hashIndex(searchValue);

        Integer result = inputArray[hashValue];

        System.out.println(result);

    }
    static int hashIndex(int value){
        return value % 10;
    }
}
