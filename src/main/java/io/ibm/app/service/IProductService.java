package io.ibm.app.service;
import io.ibm.app.model.Product;
import java.util.List;
public interface IProductService {
    public String saveProduct(Product product);
    public List<Product> getAllProducts();
    public Product getOneProductById(String productId);
    public void deleteProductById(String productId);
    public void updateProduct(Product product);
}
