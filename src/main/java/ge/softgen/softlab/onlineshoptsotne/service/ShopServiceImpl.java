package ge.softgen.softlab.onlineshoptsotne.service;

import ge.softgen.softlab.onlineshoptsotne.model.Product;
import ge.softgen.softlab.onlineshoptsotne.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private final ProductsRepository productsRepository;

    @Autowired
    public ShopServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
   private static List<Product> products = new ArrayList<>();

    public List<Product> findProducts(String product_name){
        return productsRepository.findAll();
   }

   public Product addProduct(Product product){
       return productsRepository.save(product);
   }

    public void productSold(/*@PathVariable int id ,@RequestBody record from DB*/){
        throw new RuntimeException();
        //sold a product, subtract from products/remaining and add new record/column in sales
    }

    public void productBought(/*@PathVariable int id ,@RequestBody record from DB*/){
        throw new RuntimeException();
        //bought a product, add to products/remaining and add a new record/column in sales
    }
}