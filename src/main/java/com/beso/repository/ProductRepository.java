package com.beso.repository;

import com.beso.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByProductNameContainingIgnoreCase(String keyword);
}

