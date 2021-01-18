import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.ChoiceCallback;
import java.util.*;


public class Supermarket {
    ShoppingCart shoppingCart;
    CashRegister cashRegister;
    List<Product> allProducts = new ArrayList<>();

    public Supermarket() {
        this.shoppingCart = new ShoppingCart();
        this.cashRegister = new CashRegister();
        createProducts();
    }

    public Supermarket(CashRegister cashRegister, ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        this.cashRegister = cashRegister;
        createProducts();
    }

    public void createProducts() {
        Soap soap = new Soap();
        Cereals cereals = new Cereals();
        Yoghurt yoghurt = new Yoghurt();
        Chinese_Vegetables chinese_vegetables = new Chinese_Vegetables();
        Diaper diapers = new Diaper();
        addProductToCollection(soap, cereals, yoghurt, chinese_vegetables, diapers);
    }

    public void addProductToCollection(Product... products) {
        for (Product p : products) {
            allProducts.add(p);
        }
    }
    public ShoppingCart fillUpShoppingCart(ShoppingCart shoppingCart) {
        for (Product p : allProducts) {
            shoppingCart.addProductToCart(p);
            System.out.println(p.toString());
        }
        return shoppingCart;
    }

    public void runDummyData() {
        ShoppingCart customer1 = fillUpShoppingCart(shoppingCart);
        customer1.checkOutCart(this.cashRegister);
        customer1.payGroceries(this.cashRegister);
    }

}
