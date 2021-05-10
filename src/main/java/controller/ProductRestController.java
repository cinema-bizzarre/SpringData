package controller;

import module.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductRestController {
    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productRepository.deleteById(id);
    }
    @PostMapping
    public Product addUser(@RequestBody Product product) {
        product.setId(0L);
        return (Product) productRepository.save(product);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateUser(@RequestBody Product product) {
        return (Product) productRepository.save(product);
    }
}
