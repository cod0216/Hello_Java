package enumeration.test;

public class AuthGradeMain1 {
    public static void main(String[] args) {
        AuthGrade[] authGrades = AuthGrade.values();

        for (AuthGrade authGrade : authGrades) {
            printValue(authGrade);
        }
    }
    public static void printValue(AuthGrade authGrade){
        System.out.println("garde = " + authGrade.name() + ", level = " + authGrade.getLevel() +
                ", 설명 = " + authGrade.getDescription());
    }
}
