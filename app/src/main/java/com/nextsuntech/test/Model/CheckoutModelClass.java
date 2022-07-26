package com.nextsuntech.test.Model;

public class CheckoutModelClass {

    public static final int CART_ITEMS = 1;
    public static final int PRICE_DETAILS = 2;
    public static final int SHOPPING_DETAILS = 3;

    private int viewType;
    Integer image;
    String title;
    String price;

    public CheckoutModelClass(int viewType,Integer image,String title, String price) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.viewType = viewType;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    //price layout dataModel

    String subTotal;
    String shippingFee;
    String coupon;
    String orderTotal;

    public CheckoutModelClass(int viewType,String subTotal, String shippingFee, String coupon, String orderTotal) {
        this.subTotal = subTotal;
        this.shippingFee = shippingFee;
        this.coupon = coupon;
        this.orderTotal = orderTotal;
        this.viewType = viewType;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(String shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
