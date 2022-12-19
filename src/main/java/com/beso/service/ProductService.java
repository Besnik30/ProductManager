package com.beso.service;
import com.beso.entity.Product;
import com.beso.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public  List<Product> findByProductName(String keyword){
        List<Product> products = new ArrayList<Product>();
        productRepository.findByProductNameContainingIgnoreCase(keyword).forEach(products::add);
        return products;
    }

    public void insert(Product product){
        productRepository.save(product);
    }

    public Product findProduct(Integer id){
        Product product=productRepository.findById(id).get();
        return product;
    }

    public void delete(Integer id){
        productRepository.deleteById(id);
    }
}
