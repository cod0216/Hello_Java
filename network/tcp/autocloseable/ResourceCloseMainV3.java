package network.tcp.autocloseable;

public class ResourceCloseMainV3 {
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
        ResourceV1 resourceV1 = null;
        ResourceV1  resourceV2 = null;

        try {
            resourceV1 = new ResourceV1("resourceV1");
            resourceV2 = new ResourceV1("resourceV2");

            resourceV1.call();
            resourceV2.callEx(); //exception 발생
        }catch (CallException e){
            System.out.println("ex: " + e);
            throw e;
        }finally {
            if(resourceV2 != null) {
                try{
                    resourceV2.closeEx(); // closeException 발생
                }catch (CloseException e){
                    System.out.println("colse ex : " + e);
                }

            }
            if(resourceV1 != null){
                try {
                    resourceV1.closeEx(); // 이 코드는 호출이 안된다.
                } catch (CloseException e){
                    System.out.println("close ex : " + e);
                }
            }
        }
    }
}
