package model;

import java.sql.Date;

public class Review {

    private int reviewId;
    private Customer customer;
    private Product product;
    private String title;
    private String descrption;
    private Date date;
    private int modifiedBy;
    private Date modifiedOn;

    public Review() {
    }

    public Review(int reviewId, Customer customer, Product product, String title, String descrption, Date date, int modifiedBy, Date modifiedOn) {
        this.reviewId = reviewId;
        this.customer = customer;
        this.product = product;
        this.title = title;
        this.descrption = descrption;
        this.date = date;
        this.modifiedBy = modifiedBy;
        this.modifiedOn = modifiedOn;
    }

    public int getReviewId() {
        return reviewId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public String getTitle() {
        return title;
    }

    public String getDescrption() {
        return descrption;
    }

    public Date getDate() {
        return date;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

}
