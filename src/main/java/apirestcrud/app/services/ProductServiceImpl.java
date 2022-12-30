package apirestcrud.app.services;

import apirestcrud.app.entities.Product;
import apirestcrud.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Optional<Product> deleteById(Long id) {

        Optional<Product> p = productRepository.findById(id);

        if(p.isPresent()){
            productRepository.deleteById(id);
        }

        return p;
    }

    @Override
    public Product update(Product product) {

        if(productRepository.existsById(product.getId())){
            productRepository.save(product);
            return product;
        }

        return null;
    }
}
