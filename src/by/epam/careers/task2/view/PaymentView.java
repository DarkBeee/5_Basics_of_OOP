package by.epam.careers.task2.view;

import by.epam.careers.task2.entity.Payment;

public class PaymentView {
    private static PaymentView instance;

    private PaymentView() {
    }

    public static PaymentView getInstance() {
        if (instance == null) {
            instance = new PaymentView();
        }
        return instance;
    }

    public void printCheck(Payment payment, double sum) {
        System.out.println("Чек");
        for (Payment.Product product : payment.getProducts()) {
            System.out.println(product);
        }
        System.out.println("ИТОГО  -  " + sum);
    }
}
