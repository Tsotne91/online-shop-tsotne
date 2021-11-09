package ge.softgen.softlab.onlineshoptsotne.controller;

import ge.softgen.softlab.onlineshoptsotne.model.Product;
import ge.softgen.softlab.onlineshoptsotne.repository.ProductsRepository;
import ge.softgen.softlab.onlineshoptsotne.service.ShopService;
import ge.softgen.softlab.onlineshoptsotne.service.ShopServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

private final ShopService shopService;

    public ProductsController(ShopService shopService) { this.shopService = shopService; }

    //  private static List<Product> products = new ArrayList<>();
    @GetMapping("")
    public List<Product> findProducts(@RequestParam(required = false) String product_name){
        return shopService.findProducts(product_name);
    }

    @PutMapping("")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        Product newProduct = shopService.addProduct(product);
        return ResponseEntity.status(201).body(newProduct);
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
