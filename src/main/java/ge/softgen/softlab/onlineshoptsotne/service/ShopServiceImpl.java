package ge.softgen.softlab.onlineshoptsotne.service;

import ge.softgen.softlab.onlineshoptsotne.controller.ProductsController;
import ge.softgen.softlab.onlineshoptsotne.model.Product;
import ge.softgen.softlab.onlineshoptsotne.model.Sale;
import ge.softgen.softlab.onlineshoptsotne.repository.ProductsRepository;
import ge.softgen.softlab.onlineshoptsotne.repository.SalesRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
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

    private static final List<Product> products = new ArrayList<>();

    public List<Product> findProducts(String productName){
        return productsRepository.findAll();
   }

     public Product addProduct(Product product){
       return productsRepository.save(product);
   }

   public Sale sellProduct(String id, ProductsController.sellProductInfo info) throws Exception {
        //ვნახულობთ თუ გვაქვს პროდუქტი ცხრილში
         //თუ ცხრილში products remaining დადებითია
        if(info.id() == null || StringUtils.isEmpty(info.id())){
            throw new ValidationException("no EAN code entered!");
        }
       var product = productsRepository
               .findById(id)
               .orElseThrow(()-> new ValidationException("Product not found"));

       Sale sale = new Sale();
       sale.setProductId(product.getEanCode());
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