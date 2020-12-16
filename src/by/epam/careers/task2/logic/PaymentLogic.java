package by.epam.careers.task2.logic;

import by.epam.careers.task2.entity.Payment;

public class PaymentLogic {
    private static PaymentLogic instance;

    private PaymentLogic() {
    }

    public static PaymentLogic getInstance() {
        if (instance == null) {
            instance = new PaymentLogic();
        }
        return instance;
    }

    public double paymentAmount(Payment payment) {
        double sum = 0;
        for (Payment.Product product : payment.getProducts()) {
            sum += product.getPrice();
        }
        return sum;
    }
}
