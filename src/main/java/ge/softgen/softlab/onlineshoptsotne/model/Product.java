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
@SequenceGenerator(name= "EAN_Generator", sequenceName = "products_stock_EAN_Code_seq", initialValue = 0012312451234)
@Entity
@Table (name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "EAN_Generator")
    @Column(name= "EAN_Code")
    private String EAN_Code;
    @Column(name="remaining")
    private Integer remaining;
    @Column(name="category_id")
    private Integer id;
    @Column(name="sell_price")
    private Float sell_price;
    @Column(name="product_name")
    private String product_name;
}