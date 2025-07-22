package thread.executor.test;

import util.MyLogger;
import util.ThreadUtils;

import java.util.List;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class OldOrderService {
    public void order(String orderNo){
        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShoppingWork shippingWork = new ShoppingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);

        List list = List.of(inventoryWork,shippingWork,accountingWork);

        // 작업 요청
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Boolean> future1 = es.submit(inventoryWork);
        Future<Boolean> future2 = es.submit(shippingWork);
        Future<Boolean> future3 = es.submit(accountingWork);

        try {
            Boolean inventoryResult = future1.get();
            Boolean shippingResult = future2.get();
            Boolean accountingResult = future3.get();
            // 결과 확인
            if (inventoryResult && shippingResult && accountingResult) {
                log("모든 주문 처리가 성공적으로 완료되었습니다.");
            } else {
                log("일부 작업이 실패했습니다.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            es.shutdown();
        }




    }

    static class InventoryWork implements Callable<Boolean> {
        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }

        public Boolean call() {
            log("재고 업데이트" + orderNo);
            sleep(1000);
            return true;
        }
    }


    static class ShoppingWork implements Callable<Boolean> {
        private final String orderNo;

        public ShoppingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        public Boolean call() {
            log("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class AccountingWork implements Callable<Boolean> {
        private final String orderNo;
        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }
        public Boolean call() {
            log("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
}
