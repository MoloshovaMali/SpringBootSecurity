package peaksoft.springboot.service;

import peaksoft.springboot.entity.Product;
import peaksoft.springboot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

   public List<Product>getAllProducts(){
       return productRepository.findAll();
   }
   public void save(Product product){
       productRepository.save(product);
   }
   public Product getProductById(Long id){
       return productRepository.findById(id).get();
   }
}
