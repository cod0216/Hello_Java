package cond;

public class Switch3 {
    public static void main(String[] args) {
        int grade = 2;
        int coupon = switch (grade) {
            case 1 -> 1000;
            case 2 -> 1000;
            case 3 -> 1000;
            default -> 500;
        };
        System.out.println("발급받은 쿠폰 " + coupon);
    }
}
