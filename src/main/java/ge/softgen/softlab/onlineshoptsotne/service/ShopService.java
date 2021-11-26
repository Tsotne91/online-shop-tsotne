package ge.softgen.softlab.onlineshoptsotne.service;

import ge.softgen.softlab.onlineshoptsotne.model.Product;
import ge.softgen.softlab.onlineshoptsotne.model.Purchase;
import ge.softgen.softlab.onlineshoptsotne.model.Receipt;
import ge.softgen.softlab.onlineshoptsotne.model.Sale;

import java.util.List;

public interface ShopService {
    Product addProduct(Product product);
    List<Product> findProducts(String product_name);

    Sale sellProduct(String id) throws Exception;
    Purchase productBought(String id);
    Receipt productsSold(List <OfflineSaleDTO> sales);
}