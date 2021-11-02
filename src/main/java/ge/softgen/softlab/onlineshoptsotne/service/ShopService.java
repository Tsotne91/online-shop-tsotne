package ge.softgen.softlab.onlineshoptsotne.service;

import java.util.List;

public interface ShopService {
    void addProducts();
    List findProducts();
    void productSold();
    void productBought();
   // String seeSales();
}