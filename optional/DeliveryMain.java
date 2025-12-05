package optional;

import optional.model.Delivery;
import optional.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DeliveryMain {
    static Map<Long, Order> orderRepository = new HashMap<>();

    static {
        orderRepository.put(1L, new Order(1L, new Delivery("배송완료", false)));
        orderRepository.put(2L, new Order(2L, new Delivery("배송중", false)));
        orderRepository.put(3L, new Order(3L, new Delivery("배송중", true)));
        orderRepository.put(4L, new Order(4L, null));
    }

    public static void main(String[] args) {
        System.out.println("1 = " + getDeliveryStatues(1L));
        System.out.println("2 = " + getDeliveryStatues(2L));
        System.out.println("3 = " + getDeliveryStatues(3L));
        System.out.println("4 = " + getDeliveryStatues(4L));
    }

    private static String getDeliveryStatues(Long orderId) {
        return findOrder(orderId).map(Order::getDelivery)
                .filter(d -> !d.isCancled())
                .map(d -> d.getStatue()) // Delevery -> String
                .orElse("배송X");
    }

    static Optional<Order> findOrder(Long orderId){
        return Optional.ofNullable(orderRepository.get(orderId));
    }
}
