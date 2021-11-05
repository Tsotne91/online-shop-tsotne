package ge.softgen.softlab.onlineshoptsotne.repository;

import ge.softgen.softlab.onlineshoptsotne.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product, String> {

}