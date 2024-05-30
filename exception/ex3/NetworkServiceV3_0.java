package exception.ex3;

public class NetworkServiceV3_0 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data);

        try{
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV3 | SendExceptionV3 e){
            System.out.println("[연결 오류] 메시지: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[알 수 없는 오류] 메시지 : " + e.getMessage());
        } finally {
            client.disconnect();
        }
    }
}
