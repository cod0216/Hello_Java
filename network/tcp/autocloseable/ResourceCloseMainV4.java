package network.tcp.autocloseable;

public class ResourceCloseMainV4 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외처리");

            Throwable[] suppressedEx = e.getSuppressed();
            for(Throwable t : suppressedEx){
                System.out.println("suppressedEx = " + t.getMessage());
            }
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외처리");
            throw new RuntimeException(e);
        }

    }

    private static void logic() throws CallException, CloseException{
        try(ResourceV2 resource1 = new ResourceV2("resouece1");
            ResourceV2 resource2 = new ResourceV2("resource2")) {

            resource1.call();
            resource2.callEx();// CallException
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        }

    }
}
