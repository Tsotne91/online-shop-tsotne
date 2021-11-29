package ge.softgen.softlab.onlineshoptsotne.controller;

import ge.softgen.softlab.onlineshoptsotne.model.Product;
import ge.softgen.softlab.onlineshoptsotne.model.Purchase;
import ge.softgen.softlab.onlineshoptsotne.model.Receipt;
import ge.softgen.softlab.onlineshoptsotne.model.Sale;
import ge.softgen.softlab.onlineshoptsotne.model.OfflineSaleDTO;
import ge.softgen.softlab.onlineshoptsotne.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


import java.util.List;

@RestController
@RequestMapping("")
public class ProductsController {

private final ShopService shopService;

    public ProductsController(ShopService shopService) { this.shopService = shopService; }


    @GetMapping("products")
    @Operation(tags = {"find"}, description = "Finds all products")
    public List<Product> findProducts(@RequestParam(required = false) String product_name){
        return shopService.findProducts(product_name);
    }

    @PostMapping("products")
    @Operation(tags = {"add"}, description = "Adds a new product")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        Product newProduct = shopService.addProduct(product);
        return ResponseEntity.status(201).body(newProduct);
    }


    @PostMapping("products/{id}/sales")
    @Operation(tags = {"sell"}, description = "Sells a product based on EAN code")
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

    @PostMapping("products/{id}/purchases")
    @Operation(tags = {"buy"}, description = "Buys a product")
    public ResponseEntity<Purchase> productBought(@PathVariable String id){
              try {
                  var purchase = shopService.productBought(id);
                  return ResponseEntity.ok(purchase);
              } catch (HttpClientErrorException ignore) {
                  return ResponseEntity.status(ignore.getStatusCode()).build();
              } catch (Exception e) {
                  e.printStackTrace();
                  return ResponseEntity.internalServerError().build();
              }
    }

    @PostMapping("sales")
    @Operation(tags = {"sales"}, description = "see sales")
    public ResponseEntity<Receipt> productsSold(@RequestBody List<OfflineSaleDTO> sales) {
        try {
            var receipt = shopService.productsSold(sales);
            return ResponseEntity.ok(receipt);
        } catch (HttpClientErrorException ignore) {
            return ResponseEntity.status(ignore.getStatusCode()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
