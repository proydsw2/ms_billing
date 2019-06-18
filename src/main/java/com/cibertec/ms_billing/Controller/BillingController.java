package com.cibertec.ms_billing.Controller;

import com.cibertec.ms_billing.Model.Billing;
import com.cibertec.ms_billing.Service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping(path = "/billing")
    public ResponseEntity<Object> retriveAll() {
        return billingService.getAll();
    }

    @GetMapping(path = "/billing/{id}")
    public ResponseEntity<Object> retriveOne(@PathVariable Integer id) {
        return billingService.getOne(id);
    }

    @PostMapping(path = "/billing")
    public ResponseEntity<Object> create(@RequestBody Billing billing) {
        return billingService.insert(billing);
    }

    @PutMapping(path = "/billing/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Billing billing) {
        return billingService.update(id, billing);
    }

    @DeleteMapping(path = "/billing/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return billingService.delete(id);
    }
}
