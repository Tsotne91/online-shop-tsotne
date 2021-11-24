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
@SequenceGenerator(name = "purchaseIdGenerator",
        sequenceName = "onlineshop.purchases_id_seq",
        allocationSize = 1)
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchaseIdGenerator")
    private Integer id;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;
    @Column(name = "purchase_price")
    private Float purchasePrice;
}
