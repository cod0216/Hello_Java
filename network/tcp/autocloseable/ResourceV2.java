package network.tcp.autocloseable;

public class ResourceV2 implements AutoCloseable {
    private String name;

    public ResourceV2(String name) {
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
    @Override
    public void close() throws CloseException {
        System.out.println(name + "close");
        throw new CloseException(name + " ex");
    }


}
