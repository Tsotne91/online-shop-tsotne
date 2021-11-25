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
@SequenceGenerator(name = "receiptIdGenerator", sequenceName = "onlineshop.receipts_id_seq", allocationSize = 1)
@Table (name = "receipts")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receiptIdGenerator")
    private Integer id;
    @Column(name = "receipt_date")
    private LocalDateTime receiptDate;
    @Column(name = "sum_price")
    private Double sumPrice;

}
