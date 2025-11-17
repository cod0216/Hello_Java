package network.tcp.autocloseable;

import java.io.IOException;

public class ResourceV1 {
    private String name;

    public ResourceV1(String name) {
        this.name = name;
    }

    // 정상적인 비지니스
    public void call(){
        System.out.println(name + " call");
    }

    public void callEx()throws CallException {
        System.out.println(name + " cllEx");
        throw new CallException(name + "ex");
    }

    // 자원 정리
    public void close(){
        System.out.println(name + "close");
    }


    public void closeEx()throws CloseException {
        System.out.println(name + "closeEx");
        throw new CloseException(name + " ex");
    }


}
