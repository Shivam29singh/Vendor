package com.dc.truckvendorsystem.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "VendorTable")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  vendorId;
    @NotNull
    @Column(name="email")

    private String email;

    @NotNull
    @Column(name="vendorName")
    private String vendorName;

    @NotNull
    @Column(name="phoneNumber")
    private String phoneNumber;

    @NotNull
    @Column(name="address")
    private String address;

    public Vendor() {

    }

    public Vendor(Integer vendorId, String email, String vendorName, String phoneNumber, String address) {
        this.vendorId = vendorId;
        this.email = email;
        this.vendorName = vendorName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
