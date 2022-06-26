package com.cg.model;

import java.util.Date;

public class Order {
    private int idOrder;
    private int idUser;
    private String fullName;
    private String phone;
    private String address;
    private Date createAt;

    public Order() {
    }

    public Order(int idOrder, int idUser, String fullName, String phone, String address, Date createAt) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
