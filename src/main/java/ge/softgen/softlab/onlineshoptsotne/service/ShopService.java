package ge.softgen.softlab.onlineshoptsotne.service;

import java.util.List;

public interface ShopService {
   // void addProducts();
    List findProducts(String product_name);
    void productSold();
    void productBought();
   // String seeSales();
}