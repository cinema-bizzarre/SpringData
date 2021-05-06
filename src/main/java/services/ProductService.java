package services;

import module.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    void save(Product product);
    void deleteById(Long id);
    Optional<Product> findOneById(Long id);
    Page<Product> findAllByPriceBetween(int min, int max, int page, int size);
    void incrementPriceById(Long id, int amount);
    void decrementPriceById(Long id, int amount);
    List<Product> findAll();
}


