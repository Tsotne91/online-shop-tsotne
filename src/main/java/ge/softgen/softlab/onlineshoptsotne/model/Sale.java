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
@SequenceGenerator(name= "saleIdGenerator",
        sequenceName = "onlineshop.sales_id_seq",
        allocationSize = 1)
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saleIdGenerator")
    private Integer id;
    @Column(name = "sell_date")
    private LocalDateTime sellDate;
    @Column(name = "sell_price")
    private Double sellPrice;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "receipt_id")
    private Integer receiptID;
    @Column(name = "quantity")
    private Integer quantity;
}