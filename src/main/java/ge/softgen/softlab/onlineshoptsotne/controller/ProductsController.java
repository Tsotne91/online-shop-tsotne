package ge.softgen.softlab.onlineshoptsotne.controller;

import ge.softgen.softlab.onlineshoptsotne.model.Product;
import ge.softgen.softlab.onlineshoptsotne.model.Purchase;
import ge.softgen.softlab.onlineshoptsotne.model.Sale;
import ge.softgen.softlab.onlineshoptsotne.service.OfflineSaleDTO;
import ge.softgen.softlab.onlineshoptsotne.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


import java.util.List;

@RestController
@RequestMapping("")
public class ProductsController {

private final ShopService shopService;

    public ProductsController(ShopService shopService) { this.shopService = shopService; }

    //  private static List<Product> products = new ArrayList<>();
    @GetMapping("products")
    public List<Product> findProducts(@RequestParam(required = false) String product_name){
        return shopService.findProducts(product_name);
    }

    @PostMapping("products")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        Product newProduct = shopService.addProduct(product);
        return ResponseEntity.status(201).body(newProduct);
    }


    // public record sellProductInfo(@NotNull String id){}


    @PostMapping("products/{id}/sales")
    public ResponseEntity<Sale> sellProduct(@PathVariable String id){
       try {
           var sale = shopService.sellProduct(id);
           return ResponseEntity.ok(sale);
       } catch(HttpClientErrorException ignore) {
            return ResponseEntity.status(ignore.getStatusCode()).build();
       } catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.internalServerError().build();
       }
    }

    @PostMapping ("products/{id}/purchases")
    public ResponseEntity<Purchase> productBought(@PathVariable String id){
              try {
                 var purchase = shopService.productBought(id);
                 return ResponseEntity.ok(purchase);
              } catch (HttpClientErrorException ignore){
                  return ResponseEntity.status(ignore.getStatusCode()).build();
              } catch (Exception e) {
                  e.printStackTrace();
                  return ResponseEntity.internalServerError().build();
              }
        }

       @PostMapping ("sales")
        public List<Product> productsSold(@RequestBody List<OfflineSaleDTO> sales){


        return null;
       }
}
