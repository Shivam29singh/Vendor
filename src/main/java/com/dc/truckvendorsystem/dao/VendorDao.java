package com.dc.truckvendorsystem.dao;

import com.dc.truckvendorsystem.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorDao extends JpaRepository<Vendor, Integer> {
    public Vendor findByEmail(String Email);
    Vendor findByVendorId(Integer Id);
}
