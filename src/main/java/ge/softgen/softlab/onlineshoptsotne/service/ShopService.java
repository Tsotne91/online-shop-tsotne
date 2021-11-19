package ge.softgen.softlab.onlineshoptsotne.service;

import ge.softgen.softlab.onlineshoptsotne.model.Product;
import ge.softgen.softlab.onlineshoptsotne.model.Sale;

import java.util.List;

public interface ShopService {
    Product addProduct(Product product);
    List findProducts(String product_name);

    Sale sellProduct(String id) throws Exception;
    //Sale sellProduct(Sale sales);
    //Product getProducts(String product_name);
//    List seeSales();
}