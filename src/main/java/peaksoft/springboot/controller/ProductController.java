package peaksoft.springboot.controller;
import peaksoft.springboot.entity.Product;
import peaksoft.springboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public  String getAllProducts(Model model){
        List<Product> products=productService.getAllProducts();
        model.addAttribute("products",products);
        return "products";
    }
    @GetMapping("/new")
    public String addProduct(Model model){
        model.addAttribute("product",new Product());
        return "save_product";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product")Product product){
        productService.save(product);
        return "redirect:/product";
    }

}
