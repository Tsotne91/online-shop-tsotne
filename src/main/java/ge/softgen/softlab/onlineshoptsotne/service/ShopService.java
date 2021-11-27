package ge.softgen.softlab.onlineshoptsotne.service;

import ge.softgen.softlab.onlineshoptsotne.model.*;

import java.util.List;

public interface ShopService {
    Product addProduct(Product product);
    List<Product> findProducts(String product_name);

    Sale sellProduct(String id) throws Exception;
    Purchase productBought(String id);
    Receipt productsSold(List <OfflineSaleDTO> sales);
}