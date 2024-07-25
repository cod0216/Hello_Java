package ssafy.step4;


//exception을 상속 받아서 체크드 예외로 만듦
public class TitleNotFoundException extends Exception{
    // title을 이용하여 처리하는 메서드에서 발생하는 오류이므로 title 값을 저장할 멤버 변수 선언
    private String title;

    //    예외 처리가 발생하면 파라미터러 title받고 멤버 변수에 저장
    public TitleNotFoundException(String title){
        this.title = title;
    }
// 예외가 발생한 후 예외를 발생시킨 title을 리턴하는 메서드
    public String getTitle(){
        return title;
    }
}
