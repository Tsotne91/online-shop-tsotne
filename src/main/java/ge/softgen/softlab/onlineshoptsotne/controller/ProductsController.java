package ge.softgen.softlab.onlineshoptsotne.controller;

import ge.softgen.softlab.onlineshoptsotne.model.Product;
import ge.softgen.softlab.onlineshoptsotne.model.Sale;
import ge.softgen.softlab.onlineshoptsotne.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;

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

    @PostMapping("")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        Product newProduct = shopService.addProduct(product);
        return ResponseEntity.status(201).body(newProduct);
    }


    public record sellProductInfo(String id){}

    //work in progress:
//    @PostMapping("{id}/sales")
//    public ResponseEntity<Void> sellProduct(@PathVariable String id) throws Exception {
//       try {
//           shopService.sellProduct(id);
//       } catch(NoSuchElementException ignore) {
//            return ResponseEntity.notFound().build();
//        }
//
//    }

    //    @PutMapping ("/products/{id}/purchases");
//    public void productBought(){
//        shopService.productBought();
//    }
}
