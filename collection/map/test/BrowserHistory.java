package collection.map.test;

import java.util.*;

public class BrowserHistory {
    private Deque<String> history = new ArrayDeque<>();

    public void visitPage(String url){
        System.out.println("방문 : " + url);
        history.push(url);
    }

    public String goBack(){
        String url= history.pop();
        System.out.println("뒤로 가기: " + url);
        return url;
    }
}
