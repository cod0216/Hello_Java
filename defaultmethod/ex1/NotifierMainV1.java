package defaultmethod.ex1;

import java.util.List;

public class NotifierMainV1 {
    public static void main(String[] args) {
        List<Notifier> notifiers = List.of(new EmailNotifier(), new SMSNotifier(), new AppPushNotifier());
        /*
        for (Notifier notifier : notifiers) {
            notifier.notify("서비스 가입을 환영합니다!");
        }
         */

        notifiers.forEach(notify -> notify.notify("서비스 가입을 환영합니다."));
    }
}
