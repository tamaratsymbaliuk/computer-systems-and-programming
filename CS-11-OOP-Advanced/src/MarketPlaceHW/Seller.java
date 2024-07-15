package MarketPlaceHW;

import java.util.ArrayList;
import java.util.List;

public class Seller extends AbstractUser implements ProductOperations {
    private List<Product> products;

    public Seller(String name) {
        super(name);
        this.products = new ArrayList<>();
    }
    @Override
    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to the seller's products.");

    }
    @Override
    public void removeProduct(Product product) {
        products.remove(product);
        System.out.println(product.getName() + " removed from the seller's products.");
    }

    public List<Product> getProducts() {
        return products;
    }

    }

