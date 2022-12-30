package apirestcrud.app.services;

import apirestcrud.app.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    List<Product> findAll();

    Product save(Product product);

    Optional<Product> deleteById(Long id);

    Product update(Product product);
}
