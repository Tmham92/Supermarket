import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productsList = new ArrayList<>();
    double totalPrice;

    // Constructors
    public ShoppingCart() {
    }

    public ShoppingCart(List<Product> productsList) {
        this.productsList = productsList;
    }


    public void addProductToCart(Product... product) {
        for (Product p:product) {
            productsList.add(p);
        }
    }

    public void removeProductFromCart(Product... product) {
        for (Product p:productsList) {
            if (p.equals(product)) {
                productsList.remove(productsList.indexOf(p));
            }
        }
    }
    public void checkOutCart(CashRegister cashRegister) {
        totalPrice = cashRegister.calculateTotalPrice(this.productsList);
    }

    public void payGroceries(CashRegister cashRegister) {
        cashRegister.calculatePayment(cashRegister.askCustomerToPay(totalPrice),  totalPrice);
    }
}
