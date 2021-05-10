package controller;

import lombok.RequiredArgsConstructor;
import module.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.ProductRepository;
import services.ProductServiceImpl;

@RequestMapping("product")
@Controller
public class ProductController {
    private ProductServiceImpl productService;
    private ProductRepository productRepository;

    public ProductController() {
    }
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/products/{id}")
    public String showProductInfo(@PathVariable(name = "id") Long id, Model model) {
        productService.findOneById(id).ifPresent(p -> model.addAttribute("product", p));
        return "product_info";
    }

    @GetMapping("/products/add")
    public String showCreateProductForm() {
        return "create_product_form";
    }

    @PostMapping("/products/add")
    public String createNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/";
    }
    @GetMapping("/products/{id}/price/inc")
    public String incrementProductPrice(@PathVariable Long id) {
        productService.incrementPriceById(id, 10);
        return "redirect:/";
    }
    @GetMapping("/products/{id}/price/dec")
    public String decrementProductPrice(@PathVariable Long id) {
        productService.decrementPriceById(id, -10);
        return "redirect:/";
    }



    @GetMapping("/products/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }
}
