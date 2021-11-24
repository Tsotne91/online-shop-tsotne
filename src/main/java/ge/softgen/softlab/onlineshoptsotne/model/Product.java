package ge.softgen.softlab.onlineshoptsotne.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name="products")
public class Product {
    @Id
    @Column(name= "ean_code")
    private String eanCode;
    @Column(name="remaining")
    private Integer remaining;
    @Column(name="category_id")
    private Integer categoryId;
    @Column(name="sell_price")
    private Float sellPrice;
    @Column(name="product_name")
    private String productName;
    @Column(name="purchase_price")
    private Float purchasePrice;
}