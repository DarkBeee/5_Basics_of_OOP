package by.epam.careers.task2.main;

import by.epam.careers.task2.entity.Payment;
import by.epam.careers.task2.logic.PaymentLogic;
import by.epam.careers.task2.view.PaymentView;

/**Создать класс Payment с внутренним классом, с помощью объектов которого
 * можно сформировать покупку из нескольких товаров.*/
public class Main {
    public static void main(String[] args) {
        PaymentLogic logic = PaymentLogic.getInstance();
        PaymentView view = PaymentView.getInstance();
        Payment payment = new Payment();

        payment.addProduct(new Payment.Product("Хлеб", 1.09));
        payment.addProduct(new Payment.Product("Молоко", 1.52));
        payment.addProduct(new Payment.Product("Творог", 2.12));
        payment.addProduct(new Payment.Product("Сыр", 4.68));
        payment.addProduct(new Payment.Product("Макароны", 1.99));

        view.printCheck(payment, logic.paymentAmount(payment));


    }
}

