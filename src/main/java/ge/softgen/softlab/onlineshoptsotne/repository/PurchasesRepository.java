package ge.softgen.softlab.onlineshoptsotne.repository;

import ge.softgen.softlab.onlineshoptsotne.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasesRepository extends JpaRepository<Purchase, Integer> {
}
