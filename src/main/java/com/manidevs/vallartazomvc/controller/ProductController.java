package com.manidevs.vallartazomvc.controller;

import com.manidevs.vallartazomvc.model.Product;
import com.manidevs.vallartazomvc.repository.ProdcutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {


    private ProdcutRepository prodcutRepository;
    @Autowired
    public void prodcutRepository(ProdcutRepository prodcutRepository) {
        this.prodcutRepository = prodcutRepository;
    }

    @RequestMapping(path = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(path = "/products/add", method = RequestMethod.GET)
    public String createProduct(Model model){
        model.addAttribute("product", new Product());
        return "edit";
    }

    @RequestMapping(path = "products", method = RequestMethod.POST)
    public String saveProduct(Product product){
        prodcutRepository.save(product);
        return "redirect:/products";
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public String getAllProducts(Model model){
        model.addAttribute("products", prodcutRepository.findAll());
        return "products";
    }

    @RequestMapping(path = "/products/edit/{id}", method = RequestMethod.GET)
    public String editProduct(Model model, @PathVariable(value = "id") String id){
        model.addAttribute("product", prodcutRepository.getOne(id));
        return "edit";
    }

    @RequestMapping(path = "/products/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(name = "id") String id){
        Product deleteProduct =prodcutRepository.getOne(id);
        prodcutRepository.delete(deleteProduct);
        return "redirect:/products";

    }
}
