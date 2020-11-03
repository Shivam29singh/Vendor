package com.dc.truckvendorsystem.service;

import com.dc.truckvendorsystem.model.Vendor;

public interface VendorService {


    public boolean addVendor(Vendor vendor);
    public Vendor searcVendor(String email  );//
    Vendor updateVendor(Vendor vendor);
    //    boolean deleteVendor(String email);
    boolean deleteVendor(Integer id);
}
