package ge.softgen.softlab.onlineshoptsotne.controller;

import ge.softgen.softlab.onlineshoptsotne.model.Products;
import ge.softgen.softlab.onlineshoptsotne.repository.ProductsRepository;
import ge.softgen.softlab.onlineshoptsotne.service.ShopService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductsController {

private final ShopService shopService;

    public ProductsController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/products")
    public List<Products> findProducts(@RequestParam(required = false) String product_name){
         return shopService.findProducts();
    }

    @PutMapping("/products")
    public void addingProducts(){
        throw new RuntimeException();
    }
//    @PutMapping("/products/{id}/sales");
//    public void getProductsSold(){
//        shopService.productSold();
//    }
//    @PutMapping ("/products/{id}/purchases");
//    public void productBought(){
//        shopService.productBought();
//    }


}
