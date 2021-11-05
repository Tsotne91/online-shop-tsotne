package ge.softgen.softlab.onlineshoptsotne.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name="sales")
public class Sales {
    @Id
    private Integer id;
    @Column(name="sell_date")
    private LocalDate sell_date;
}