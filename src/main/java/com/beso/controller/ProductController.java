package com.beso.controller;

import com.beso.entity.Product;
import com.beso.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;


@Controller
public class ProductController {

    @Autowired
   private ProductService productService;

    @GetMapping(value = "/products")
    public  String findAll(Model model, @Param("keyword") String keyword) {
        List<Product> products;
            if (keyword == null) {
             products= productService.findAll();
            }else {
               products=productService.findByProductName(keyword);
               model.addAttribute("keyword", keyword);
            }
            model.addAttribute("products",products);
            return "products";
    }

    @GetMapping(value = "/products/new")
    public String addProduct(Model model){
        Product product=new Product();
        model.addAttribute("product",product);
        model.addAttribute("pageTitle","Create new Product");
        return "product_form";
    }

   @GetMapping(value="/products/{id}")
    public String editProduct(@PathVariable("id") Integer id,Model model,RedirectAttributes redirectAttributes){
        Product product1=productService.findProduct(id);
        model.addAttribute("product",product1);
        model.addAttribute("pageTitle", "Edit Product (ID: " + id + ")");
        return "product_form";
    }

    @PostMapping(value="/products/save")
    public  String insertProduct(Product product,RedirectAttributes redirectAttributes){
        productService.insert(product);
        redirectAttributes.addFlashAttribute("message", "The Product has been saved successfully!");
        return "redirect:/products";
    }

    @GetMapping(value ="/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        productService.delete(id);
        redirectAttributes.addFlashAttribute("message", "The Product with id=" + id + " has been deleted successfully!");
        return "redirect:/products";
    }
}

