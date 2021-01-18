import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {
    List<Product> productsList = new ArrayList<>();
    double totalPrice;

    // Constructors
    public ShoppingCart() {
    }
    public ShoppingCart(List<Product> productsList) {
        this.productsList = productsList;
    }

    /**
     * Add Product(s) to shoppingCart
     * @param product (Product)
     */
    public void addProductToCart(Product... product) {
        productsList.addAll(Arrays.asList(product));
    }

    /**
     * Removes Product p from Shoppingcart
     * @param product (Product)
     */
    public void removeProductFromCart(Product... product) {
        productsList.removeIf(p -> Objects.equals(p, product));
    }

    /**
     * See total value of ShoppingCart and asks for user input via cashRegister.calculateTotalPrice
     * @param cashRegister (CashRegister)
     */
    public void checkOutCart(CashRegister cashRegister) {
        totalPrice = cashRegister.calculateTotalPrice(this.productsList);
    }

    /**
     * Calls CashRegister.calculatePayment method to handle the payment.
     * @param cashRegister (CashRegister)
     */
    public void payGroceries(CashRegister cashRegister) {
        cashRegister.calculatePayment(cashRegister.askCustomerToPay(totalPrice),  totalPrice);
    }
}
