import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CashRegister {

    // int Array to store what change needs to be given back
    int[] change = new int[11];
    double totalAmountOfChange;

    /**
     * Calculates total price by adding price of each product in the shoppingcart to the totalPrice
     * @param products (Product)
     * @return totalPrice (int)
     */
    public double calculateTotalPrice(List<Product> products) {
        double totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.price;
        }
        totalPrice = calculateDiscount(totalPrice);
        return totalPrice;
    }

    /**
     * Calculates if discount needs to be applied. Threshold are higher than 20 and 10.
     * @param totalPrice (double)
     * @return totalPrice - discount (double)
     */
    public double calculateDiscount(double totalPrice) {
        System.out.println("Your total price is €" + totalPrice + ".");
        if (totalPrice > 20) {
            System.out.println("You get 1.00 euro discount.");
            return totalPrice -= 1.0;
        } else if (totalPrice > 10) {
            System.out.println("You get 0.50 euro discount.");
            return totalPrice -= 0.5;
        } else {
            System.out.println("You have no discount.");
            return totalPrice;
        }
    }

    /**
     * Acquire user input on how much they pay.
     * @param totalPrice
     * @return
     */
    public double askCustomerToPay(double totalPrice) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("The total amount is " + totalPrice + ".");
        System.out.println("Please enter the amount you pay.");
        double moneyPaid = userInput.nextDouble();
        return moneyPaid;
    }

    /**
     * Calculate payment
     * @param moneyPaid (double)
     * @param totalPrice (double)
     */
    public void calculatePayment(double moneyPaid, double totalPrice) {
        totalAmountOfChange = -(totalPrice - moneyPaid);
        checkIfPaymentIsSuccessful(-totalAmountOfChange);
    }

    /**
     * Check whether payment is sufficient or not.
     * @param moneyLeft (double)
     */
    public void checkIfPaymentIsSuccessful(double moneyLeft) {
        if (moneyLeft > 0) {
            System.out.println("Your payment is not sufficient.");
            System.out.println("You still have to pay " + moneyLeft);
            askCustomerToPay(moneyLeft);
        } else if (moneyLeft == 0) {
            System.out.println("Thank you, have a great day.");
        } else {
            System.out.println("Calculating change.");
            calculateChange(-moneyLeft);
            changeToString();
            System.out.println("Which totals to " + totalAmountOfChange + ".");
        }
    }

    /**
     * Calculate what change needs to be given back.
     * If change is higher than 200 euro. The supermarket will not accept it.
     * Stores amount of notes/coins in the int[] change.
     * @param amountToChange (double)
     */
    public void calculateChange(double amountToChange) {
        amountToChange = convertDouble(amountToChange);
        if (amountToChange >= 100.00) {
            change[0]++;
            amountToChange -= 100.00;
            calculateChange(amountToChange);
        } else if (amountToChange >= 50.00) {
            change[1]++;
            amountToChange -= 50.00;
            calculateChange(amountToChange);
        } else if (amountToChange >= 20.00) {
            change[2]++;
            amountToChange -= 20.00;
            calculateChange(amountToChange);
        } else if (amountToChange >= 10.00) {
            change[3]++;
            amountToChange -= 10.00;
            calculateChange(amountToChange);
        } else if (amountToChange >= 5.00) {
            change[4]++;
            amountToChange -= 5.00;
            calculateChange(amountToChange);
        } else if (amountToChange >= 2.00) {
            change[5]++;
            amountToChange -= 2.00;
            calculateChange(amountToChange);
        } else if (amountToChange >= 1.00) {
            change[6]++;
            amountToChange -= 1.00;
            calculateChange(amountToChange);
        } else if (amountToChange >= 0.50) {
            change[7]++;
            amountToChange -= 0.50;
            calculateChange(amountToChange);
        } else if (amountToChange >= 0.20) {
            change[8]++;
            amountToChange -= 0.20;
            calculateChange(amountToChange);
        } else if (amountToChange >= 0.10) {
            change[9]++;
            amountToChange -= 0.10;
            calculateChange(amountToChange);
        } else if (amountToChange >= 0.05) {
            change[9]++;
            amountToChange -= 0.05;
            calculateChange(amountToChange);
        }
    }

    /**
     * Convert int[] of change into notes and coins to give the user an overview.
     */
    public void changeToString() {
        for (int i = 0; i < change.length; i++) {
            if (change[i] > 0 && i == 0) {
                System.out.println("You get " + change[i] + " note(s) of €100");
            } else if (change[i] > 0 && i == 1) {
                System.out.println("You get " + change[i] + " note of €50");
            } else if (change[i] > 0 && i == 2) {
                System.out.println("You get " + change[i] + " note(s) of €20");
            } else if (change[i] > 0 && i == 3) {
                System.out.println("You get " + change[i] + " note of €10");
            } else if (change[i] > 0 && i == 4) {
                System.out.println("You get " + change[i] + " note of €5");
            } else if (change[i] > 0 && i == 5) {
                System.out.println("You get " + change[i] + " coin(s) of €2");
            } else if (change[i] > 0 && i == 6) {
                System.out.println("You get " + change[i] + " coin of €1");
            } else if (change[i] > 0 && i == 7) {
                System.out.println("You get " + change[i] + " coin of €.50");
            } else if (change[i] > 0 && i == 8) {
                System.out.println("You get " + change[i] + " coin(s) of €.20");
            } else if (change[i] > 0 && i == 9) {
                System.out.println("You get " + change[i] + " coin of €.10");
            } else if (change[i] > 0 && i == 10){
                System.out.println("You get " + change[i] + " coin of €.05");
            }
        }
    }

    /**
     * Converts 'amountToChange' into a double with 2 decimals.
     * @param amountToChange (double)
     * @return change (double)
     */
    public double convertDouble(double amountToChange) {
        DecimalFormat df = new DecimalFormat("####.##");
        double change = Double.parseDouble(df.format(amountToChange).replace("," , "."));
        return change;
    }
}
