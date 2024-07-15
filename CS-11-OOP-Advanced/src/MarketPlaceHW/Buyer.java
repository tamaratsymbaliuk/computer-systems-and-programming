package MarketPlaceHW;

public class Buyer extends AbstractUser {
    public Buyer(String name) {
        super(name);
    }

    public void buyProduct(Product product, Seller seller) {
        seller.removeProduct(product);
        System.out.println(getName() + " bought " + product.getName() + " from " + seller.getName());
    }
}
