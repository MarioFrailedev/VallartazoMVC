package com.manidevs.vallartazomvc.repository;

import com.manidevs.vallartazomvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdcutRepository extends JpaRepository<Product, String> {
}
