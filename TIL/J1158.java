package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

class MyNode{
    Integer data;
    MyNode next;

    public MyNode(Integer data){
        this.data = data;
        this.next = null;
    }
}
class MyList{
    private MyNode head;
    private MyNode tail;

    public MyList() {
        this.head = null;
        this.tail = null;
    }

    public void add(Integer data){
        MyNode myNode = new MyNode(data);
        if(head == null){
            head = myNode;
            tail = myNode;
        } else {
            tail.next = myNode;
            tail  = myNode;
        }
    }

    public Integer remove(Integer data){
        if(data == 0) {
            Integer num = head.data;
            head = head.next;
            if(head == null) tail = null;
            return num;
        }
          // end point remove

         MyNode cur = head;
         for(int i = 0 ; i < data-1; i++){
             cur = cur.next;
        }
         Integer num = cur.next.data;
         cur.next = cur.next.next;
         if(cur.next == null) tail = cur;
         return num;

    }

    public boolean isEmpty(){
        return head == null;
    }
}

public class J1158 {
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        MyList  myList = new MyList();

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        for(int i = 1 ; i <= n; i++){
            myList.add(i);
            size++;
        }

        int index = k-1;

        System.out.print("<");

        while(!myList.isEmpty()){
            index = index % size;
            int remove = myList.remove(index);
            System.out.print(remove);
            size--;
            if(!myList.isEmpty()){
                System.out.print(", ");
            }
            index = index + k - 1;
        }
        System.out.print(">");
        System.out.println();
    }
}
