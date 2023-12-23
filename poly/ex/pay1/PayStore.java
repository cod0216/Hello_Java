package poly.ex.pay1;

public abstract class PayStore {
    public static Pay findPay(String option) {
            if(option.equals("kakao")) {
                return new KaKaoPay();
            } else if (option.equals("naver")) {
                return new NaverPay();
            } else if (option.equals("NewPay")) {
                return new NewPay();
            } else {
                return new DefaultPay();
            }
    }
}
