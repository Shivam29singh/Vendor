package com.dc.truckvendorsystem.controller;

import com.dc.truckvendorsystem.model.Vendor;
import com.dc.truckvendorsystem.service.VendorService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;

@RestController
@RequestMapping("/vendor")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @PostMapping("/addvendr")
    public ResponseEntity<String> addVendor(@RequestBody Vendor vendor){
        boolean savedVendor =   vendorService.addVendor(vendor);
        if ( !savedVendor){
            return  new ResponseEntity<>( "THERE WAS A PROBLEAM TO ADD VENDOR", HttpStatus.BAD_REQUEST );
        }
        return  new ResponseEntity<>( "VENDOR ADDED", HttpStatus.OK );
    }

    @GetMapping("/searchvendor/{email}")
    public ResponseEntity searchVendor(@PathVariable String email){
        Vendor vendor =     vendorService.searcVendor(email);
        if (vendor != null){
            return  ResponseEntity.status(HttpStatus.OK).body(vendor);

        }
        return   new ResponseEntity<>( " VENDOR NOT FOUND", HttpStatus.NOT_FOUND );
    }

    @PutMapping("/update/vendor")
    public ResponseEntity<Vendor> updateVendor(@RequestBody Vendor vendor){
        Vendor vendor1 =  vendorService.updateVendor(vendor);

        if (vendor1 != null){
            return    ResponseEntity.status(HttpStatus.OK).body(vendor);
        }
        return  new ResponseEntity( "CAN NOT BE UPDATE", HttpStatus.BAD_REQUEST );

    }

    @DeleteMapping("/delete/vendor/{id}")
    public ResponseEntity deleteVendor(@PathVariable Integer id){
        boolean vendor =  vendorService.deleteVendor(id);
        if (!vendor){
            return  new ResponseEntity<>( "CAN NOT DELETE DC", HttpStatus.BAD_REQUEST );
        }
        return  new ResponseEntity<>( "DELETE SUCCESSFULL", HttpStatus.OK );
    }

}
