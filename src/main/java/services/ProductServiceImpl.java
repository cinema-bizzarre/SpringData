package services;

import module.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Optional<Product> findOneById(Long id) {
        return productRepository.findById(id);
    }
    public Page<Product> findAllByPriceBetween(int min, int max, int page, int size) {
        return productRepository.findAllByPriceBetween(min, max , PageRequest.of(page,size));
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void incrementPriceById(Long id, int amount) {
        Product p = (Product) productRepository.findById(id).get();
        p.incrementPrice(amount);
    }
    @Transactional
    public void decrementPriceById(Long id, int amount) {
        Product p = (Product) productRepository.findById(id).get();
        p.incrementPrice(amount);
    }

}
