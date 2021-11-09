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
//@SequenceGenerator(name= "EAN_Generator", sequenceName = "products_stock_EAN_Code_seq")
@Entity
@Table (name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY /*generator = "EAN_Generator"*/)
    @Column(name= "ean_code")
    private String ean_code;
    @Column(name="remaining")
    private Integer remaining;
    @Column(name="category_id")
    private Integer category_id;
    @Column(name="sell_price")
    private Float sell_price;
    @Column(name="product_name")
    private String product_name;
}