package ge.softgen.softlab.onlineshoptsotne.service;

import ge.softgen.softlab.onlineshoptsotne.model.*;
import ge.softgen.softlab.onlineshoptsotne.repository.ProductsRepository;
import ge.softgen.softlab.onlineshoptsotne.repository.PurchasesRepository;
import ge.softgen.softlab.onlineshoptsotne.repository.ReceiptsRepository;
import ge.softgen.softlab.onlineshoptsotne.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
public class ShopServiceImpl implements ShopService {
    private final ProductsRepository productsRepository;
    private final SalesRepository salesRepository;
    private final PurchasesRepository purchasesRepository;
    private final ReceiptsRepository receiptsRepository;


    public List<Product> findProducts(String productName){
        return productsRepository.findAll();
   }

     public Product addProduct(Product product){
       return productsRepository.save(product);
   }

   @Transactional
   public Sale sellProduct(String id){

       if(id == null || StringUtils.isEmpty(id)){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "no EAN code entered!");
       }
       var product = productsRepository
               .findById(id)
               .orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
       if (product.getRemaining()<=0) {
         throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No product in stock");
       }
       product.setRemaining(product.getRemaining()-1);
       productsRepository.save(product);

       Sale sale = new Sale();
       sale.setProductId(product.getEanCode());
       sale.setSellDate(LocalDateTime.now());
       sale.setSellPrice(product.getSellPrice());
       salesRepository.save(sale);
       return sale;
   }

   @Transactional
   public Purchase productBought(String id){
           if(id == null || StringUtils.isEmpty(id)){
               throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                       "no EAN code entered!");
           }
           productsRepository.findById(id)
                   .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

           var product = productsRepository
                   .findById(id)
                   .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
           product.setRemaining(product.getRemaining()+1);
           productsRepository.save(product);

           Purchase purchase = new Purchase();
           purchase.setProductId(product.getEanCode());
           purchase.setPurchaseDate(LocalDateTime.now());
           purchase.setPurchasePrice(product.getPurchasePrice());
           purchasesRepository.save(purchase);
           return purchase;
         }

      public Receipt productsSold(List<OfflineSaleDTO> sales){

          for (OfflineSaleDTO receipt : sales) {
              String saleId = receipt.getId();
              int quantity = receipt.getQuantity();
              var product = productsRepository.findById(saleId).orElseThrow();
              product.setRemaining(product.getRemaining() - quantity);

              Sale sale = new Sale();
              sale.setProductId(product.getEanCode());
              sale.setSellDate(LocalDateTime.now());
              sale.setSellPrice(product.getSellPrice());
              salesRepository.save(sale);
          }


          Receipt receipt = new Receipt();
          receipt.setReceiptDate(LocalDateTime.now());
          double totalSum;
//          for ( int i=0; i<sales.size(); ++i){
//            totalSum += sales.get(i).getPrice();
//          }
          totalSum = sales.stream().mapToDouble(OfflineSaleDTO::getPrice).sum();
          receipt.setSumPrice(totalSum);
          receiptsRepository.save(receipt);

        return receipt;
    }
}




