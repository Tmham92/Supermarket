public abstract class Product {
    double price;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "price=" + price +
                '}';
    }
}
