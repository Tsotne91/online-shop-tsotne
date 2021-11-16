package ge.softgen.softlab.onlineshoptsotne.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
//@SequenceGenerator(name= "EAN_Generator", sequenceName = "products_stock_EAN_Code_seq")
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sell_date")
    private LocalDateTime sellDate;
    @Column(name = "sell_price")
    private Float sellPrice;
    @Column(name = "product_id")
    private String productId;
}