package apirestcrud.app.controllers;

import apirestcrud.app.entities.Product;
import apirestcrud.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @PostMapping("/products/new-product")
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product result = productService.save(product);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("products/{id}")
    public Optional<Product> deleteById(@PathVariable Long id){
        return productService.deleteById(id);
    }

    @PutMapping("/products")
    public ResponseEntity<Product> update(@RequestBody Product product){

        productService.update(product);

        return ResponseEntity.ok(product);
    }
}
