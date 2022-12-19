package com.beso.entity;
import javax.persistence.*;

@Entity
@Table(name="Product ")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    @Column(length = 128)
    private String productName;

    @Column(length = 128)
    private String madeIn;

    @Column(length = 128)
    private String category;

    @Column
    private Integer inStock;

    public Product(){}

    public Product(Integer id, String productName, String madeIn, String category,Integer inStock){
        this.id=id;
        this.productName=productName;
        this.madeIn=madeIn;
        this.category=category;
        this.inStock=inStock;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Product [id= "+id+" Product Name "+productName+" Made In "+madeIn+" Category "+category+" In stock "+inStock;
    }
}
