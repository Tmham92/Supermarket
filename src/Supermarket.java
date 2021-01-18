import java.util.*;


public class Supermarket {

    ShoppingCart shoppingCart;
    CashRegister cashRegister;
    List<Product> allProducts = new ArrayList<>();

    /**
     * Constructors which also creates the initial product list.
     */
    public Supermarket() {
        this.shoppingCart = new ShoppingCart();
        this.cashRegister = new CashRegister();
        createProducts();
    }

    /**
     * Create a list of all the products that are in the supermarket and adds them to the List<Product>
     */
    public void createProducts() {
        Soap soap = new Soap();
        Cereals cereals = new Cereals();
        Yoghurt yoghurt = new Yoghurt();
        Chinese_Vegetables chinese_vegetables = new Chinese_Vegetables();
        Diaper diapers = new Diaper();
        addProductToCollection(soap, cereals, yoghurt, chinese_vegetables, diapers);
    }
    public void addProductToCollection(Product... products) {
        allProducts.addAll(Arrays.asList(products));
    }

    /**
     * Adds item(s) to shoppingCart.
     * @param shoppingCart (ShoppingCart)
     * @return (ShoppingCart)
     */
    public ShoppingCart fillUpShoppingCart(ShoppingCart shoppingCart) {
        for (Product p : allProducts) {
            shoppingCart.addProductToCart(p);
            System.out.println(p.toString());
        }
        return shoppingCart;
    }

    /**
     * Basic test with all products in 1 shoppingCart.
     */
    public void runDummyData() {
        ShoppingCart customer1 = fillUpShoppingCart(shoppingCart);
        customer1.checkOutCart(this.cashRegister);
        customer1.payGroceries(this.cashRegister);
    }

}
