package collection.set;

public class StringHashMain {

    static final int CAPACITY = 10;

    public static void main(String[] args){

        char CharA = 'A';
        char CharB = 'B';

        System.out.println("CharA = " + (int)CharA);
        System.out.println("CharB = " + (int)CharB);
        System.out.println();

        System.out.println("hashCode('A') = " + hashCode("A"));
        System.out.println("hashCode('B') = " + hashCode("B"));
        System.out.println("hashCode('AB') = " + hashCode("AB"));
        System.out.println();

        System.out.println("hashIndex(A) = " + hashIndex(hashCode("A")));
        System.out.println("hashIndex(B) = " + hashIndex(hashCode("B")));
        System.out.println("hashIndex(AB) = " + hashIndex(hashCode("AB")));

    }

    static int hashCode(String str){
        char[] charArray = str.toCharArray();
        int num = 0;
        for(int i = 0; i < charArray.length; i++){
            num += (int)charArray[i];
        }
        return num;
    }

    static int hashIndex(int value){
        return value % CAPACITY;
    }
}
