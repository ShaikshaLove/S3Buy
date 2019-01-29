package io.ibm.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="s3_products")
public class Product implements Comparable<Product>{
    @Id
    //@GenericGenerator(name="prdIdGen",strategy="io.ibm.app.generator.ProductIdGenerator")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String productId;

    private String productName;

    private double mrp;

    private double currentCost;

    private double discountPctg;

    private String imagName;

    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public double getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(double currentCost) {
        this.currentCost = currentCost;
    }

    public double getDiscountPctg() {
        return discountPctg;
    }

    public void setDiscountPctg(double discountPctg) {
        this.discountPctg = discountPctg;
    }

    public String getImagName() {
        return imagName;
    }

    public void setImagName(String imagName) {
        this.imagName = imagName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", mrp=" + mrp +
                ", currentCost=" + currentCost +
                ", discountPctg=" + discountPctg +
                ", imagName='" + imagName + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.getProductId().compareTo(o.getProductId());
    }
}
