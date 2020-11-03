package com.dc.truckvendorsystem.service.impl;

import com.dc.truckvendorsystem.dao.VendorDao;
import com.dc.truckvendorsystem.exception.VendorException;
import com.dc.truckvendorsystem.model.Vendor;
import com.dc.truckvendorsystem.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService  {

    @Autowired
    private VendorDao vendorDao;

    @Override
    public boolean addVendor(Vendor vendor) {
        if (this.searcVendor(vendor.getEmail()) != null){
            throw new VendorException("Email id Already exit");
        }
        Vendor v =  vendorDao.save(vendor);


        if (v != null){
            return true;
        }
        return false;

    }

    @Override
    public Vendor searcVendor(String email) {
//        System.out.println(vendorDao.findByEmail(email) + "check");
        if (vendorDao.findByEmail(email) != null){
            Vendor vendor =    vendorDao.findByEmail(email);
            System.out.println(vendor + "inside vendor");
            return  vendor;
        }

        return null;
    }
    public Vendor updateVendor(Vendor vendor){

        System.out.println(vendor.getVendorId());
        Vendor ven  =  vendorDao.findByVendorId(vendor.getVendorId());
        System.out.println(ven + "vendor");
        if (ven != null){
            return  vendorDao.save(vendor);
        }
        return null;
    }

    @Override
    public boolean deleteVendor(Integer id) {
        if (  vendorDao.findByVendorId(id) != null){

            Vendor vendor  =   vendorDao.findByVendorId(id);
            vendorDao.delete(vendor);
            return true;

        }

        return false;
    }

//    @Override
//    public boolean deleteVendor(String email) {
//        if (this.searcVendor(email) != null){
//            Vendor vendor =   this.searcVendor(email);
//            vendorDao.delete(vendor);
//            return  true;
//        }
//
//
//        return false;
//    }

}
