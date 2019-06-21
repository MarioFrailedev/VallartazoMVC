package com.manidevs.vallartazomvc.boot;

import com.manidevs.vallartazomvc.model.Product;
import com.manidevs.vallartazomvc.repository.ProdcutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProdcutRepository prodcutRepository;

    @Override
    public void run(String... args) throws Exception {

        Product product1 = new Product();
        product1.setName("Outlander 1000R");
        product1.setDescription("motor Rotax 91HP");
        product1.setCategory("Outlander");
        product1.setType("AVT");
        product1.setPrice(28900.0);

        prodcutRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Maverick x3");
        product2.setDescription("motor Rotax 120HP");
        product2.setCategory("Maverick");
        product2.setType("SST");
        product2.setPrice(38900.0);

        prodcutRepository.save(product2);
    }
}
