import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CashRegister {

    int[] change = new int[11];
    double totalAmountOfChange;

    public double calculateTotalPrice(List<Product> products) {
        double totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.price;
        }
        totalPrice = calculateDiscount(totalPrice);
        return totalPrice;
    }

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

    public double askCustomerToPay(double totalPrice) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("The total amount is " + totalPrice + ".");
        System.out.println("Please enter the amount you pay.");
        double moneyPaid = userInput.nextDouble();
        return moneyPaid;
    }
    public void calculatePayment(double moneyPaid, double totalPrice) {
        totalAmountOfChange = -(totalPrice - moneyPaid);
        checkIfPaymentIsSuccessful(-totalAmountOfChange);
    }

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
    public double convertDouble(double amountToChange) {
        DecimalFormat df = new DecimalFormat("####.##");
        double change = Double.parseDouble(df.format(amountToChange).replace("," , "."));
        return change;
    }
}
