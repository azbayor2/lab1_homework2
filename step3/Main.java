package step3;

import javax.smartcardio.Card;

interface Payment{
    public void pay(int amount);
    public void refund(int amount);
}

class CardPayment implements Payment{
    @Override
    public void pay(int amount) {
        System.out.println("카드 결제: " + amount + "원");
    }
    @Override
    public void refund(int amount){
        System.out.println("카드 결제 환불: "+ amount + "원");
    }

}

class PaypalPayment implements Payment{
    @Override
    public void pay(int amount) {
        System.out.println("페이팔 결제: " + amount + "원");
    }

    @Override
    public void refund(int amount){
        System.out.println("PayPal 결제 환불: "+ amount + "원");
    }
}

class PaymentStrategy{
    private Payment how;
    public PaymentStrategy(Payment how){ this.how = how; }
    public void pay(int amount){
        how.pay(amount);
    }
    public void refund(int amount){
        how.refund(amount);
    }
    public void changeStrategy(Payment how){
        this.how = how;
    }
}

public class Main {
    public static void main(String[] args) {
        // CardPayment cardPayment = new CardPayment();
        // cardPayment.pay(10000);

        // PaypalPayment paypalPayment = new PaypalPayment();
        // paypalPayment.pay(15000);

        PaymentStrategy st = new PaymentStrategy(new CardPayment());
        st.pay(10000);
        st.refund(5000);
        st.changeStrategy(new PaypalPayment());
        st.pay(20000);
        st.refund(2500);

        return;
    }
}