package ge.softgen.softlab.onlineshoptsotne.repository;

import ge.softgen.softlab.onlineshoptsotne.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProductsRepository extends JpaRepository<Products, BigInteger> {

}
