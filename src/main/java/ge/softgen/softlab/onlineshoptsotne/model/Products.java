package ge.softgen.softlab.onlineshoptsotne.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name="products")
@SequenceGenerator(name= "EAN_Generator", sequenceName = "products_stock_EAN_Code_seq")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EAN_Generator")
    private Integer EAN_Code;
    @Column(name="remaining")
    private Integer remaining;
    @Column(name="category_id")
    private Integer id;
    @Column(name="sell_price")
    private Float sell_price;
    @Column(name="product_name")
    private String product_name;
    public Products(){}

}
