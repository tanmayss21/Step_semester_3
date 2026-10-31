package constructors_and_keywords.assigment_problems;

/**
 * Problem A5: instanceof Inside a Loop - Canteen Closing-Time Payment Dispatch
 * 
 * Uses instanceof for type inspection and safe downcasting to dispatch payments
 * with processing fees for card payments, accumulating a running total.
 */
public class Payment {

    public double pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
        return amount;
    }

    public static double processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment card = (CardPayment) payment;
            return card.payWithProcessingFee(amount);
        } else {
            return payment.pay(amount);
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};
        double totalCollected = 0.0;

        for (int i = 0; i < payments.length; i++) {
            totalCollected += processTransaction(payments[i], amounts[i]);
        }

        System.out.println("Total Collected: Rs " + totalCollected);
    }
}

class CardPayment extends Payment {
    public double payWithProcessingFee(double amount) {
        double fee = amount * 0.02;
        double total = amount + fee;
        System.out.println("Charged (card, incl. fee): Rs " + total);
        return total;
    }
}
