package cond.ex;

public class ScoreEx {
    public static void main(String[] args) {
        int socre = 50;

        if(socre > 90)
            System.out.println("학점은 A입니다.");
        else if ( socre >= 80)
            System.out.println("학점은 B입니다.");
        else if ( socre >= 70)
            System.out.println("학점은 C입니다.");
        else if ( socre >= 60)
            System.out.println("학점은 D입니다.");
        else
            System.out.println("학점은 F입니다.");
    }
}
