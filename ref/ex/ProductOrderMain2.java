package ref.ex;


public class ProductOrderMain2 {
    public static void main(String[] args) {
        ProductOrder[] orders = new ProductOrder[3];

        orders[0] = createOrder("두부", 2000, 2);
        orders[1] = createOrder("김치", 5000, 1);
        orders[2] = createOrder("콜라", 1500, 2);


        int totalAmount = 0;
        printOrders(orders);
        int totalAmount1 = getTotalAmount(orders);
        System.out.println("총 가격 : " + totalAmount);
    }
    public static ProductOrder createOrder(String productname, int price, int quantity) {
        ProductOrder order = new ProductOrder();
        order.productName = productname;
        order.price = price;
        order.quantity = quantity;
        return order;

    }
    public static void printOrders(ProductOrder[] orders) {
        for (ProductOrder s : orders) {
            System.out.println("상품명 : " + s.productName + ", 가격 : " + s.price + ", 수량 : " +  s.quantity);
        }
    }
    public static int getTotalAmount(ProductOrder[] orders) {
        int totalAmount = 0;
        for (ProductOrder order : orders) {
            totalAmount += order.price * order.quantity;
        }
        return totalAmount;
    }
}
