package ge.softgen.softlab.onlineshoptsotne.service;

import ge.softgen.softlab.onlineshoptsotne.model.Products;
import ge.softgen.softlab.onlineshoptsotne.repository.ProductsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private final ProductsRepository productsRepository;

    public ShopServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

   public List<Products> findProducts(){
        return productsRepository.findAll();
   }

    public void addProducts(){
        throw new RuntimeException();
        //adding products
        //may need separate annotation for post
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