package model;

import java.sql.Date;

public class Order {

    private int orderId;
    private Customer customer;
    private User user;
    private int orderStatus;
    private Date orderDate;
    private float freight;
    private String paymentMethod;
    private Date deliveryDate;
    private String shippingAddress;

    public Order() {
    }

    public Order(int orderId, Customer customer, User user, int orderStatus, Date orderDate, float freight, String paymentMethod, Date deliveryDate, String shippingAddress) {
        this.orderId = orderId;
        this.customer = customer;
        this.user = user;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.freight = freight;
        this.paymentMethod = paymentMethod;
        this.deliveryDate = deliveryDate;
        this.shippingAddress = shippingAddress;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public User getUser() {
        return user;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public float getFreight() {
        return freight;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setFreight(float freight) {
        this.freight = freight;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}
