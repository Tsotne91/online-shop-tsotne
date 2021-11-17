package ge.softgen.softlab.onlineshoptsotne.service;

import ge.softgen.softlab.onlineshoptsotne.model.Product;
import ge.softgen.softlab.onlineshoptsotne.model.Sale;
import ge.softgen.softlab.onlineshoptsotne.repository.ProductsRepository;
import ge.softgen.softlab.onlineshoptsotne.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private final ProductsRepository productsRepository;
    private final SalesRepository salesRepository;

    public ShopServiceImpl(ProductsRepository productsRepository, SalesRepository salesRepository) {
        this.productsRepository = productsRepository;
        this.salesRepository = salesRepository;
    }

    private static List<Product> products = new ArrayList<>();

    public List<Product> findProducts(String productName){
        return productsRepository.findAll();
   }

     public Product addProduct(Product product){
       return productsRepository.save(product);
   }

   public Sale sellProduct(String id){
        //ვნახულობთ თუ გვაქვს პროდუქტი ცხრილში
         //თუ ცხრილში products remaining დადებითია
       Sale sale = new Sale();
       sale.setProductId(id);
       sale.setSellDate(LocalDateTime.now());
        return salesRepository.save(sale);
   }

//    public List<Product> seeSales(){
//
//    }


//    public void productBought(Product product){
//
//
//    }
}