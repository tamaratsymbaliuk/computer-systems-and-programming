package MarketPlaceHW;

import java.util.List;

public class ProductCategory {
    private String name;
    private List<Product> products;

    public ProductCategory(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }



}
