package ge.softgen.softlab.onlineshoptsotne.service;

import ge.softgen.softlab.onlineshoptsotne.model.Product;

import java.util.List;

public interface ShopService {
    Product addProduct(Product product);
    List findProducts(String product_name);
    void productSold();
    void productBought();
   // String seeSales();
}