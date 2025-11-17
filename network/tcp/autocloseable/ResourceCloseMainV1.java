package network.tcp.autocloseable;

public class ResourceCloseMainV1 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외처리");
            throw new RuntimeException(e);
        }

    }

    private static void logic() throws CallException, CloseException{
        ResourceV1 resourceV1 = new ResourceV1("resourceV1");
        ResourceV1 resourceV2 = new ResourceV1("resourceV2");

        resourceV1.call();
        resourceV2.callEx(); //exception 발생

        System.out.println("자원정리");

        resourceV2.closeEx();
        resourceV1.close();
    }
}
