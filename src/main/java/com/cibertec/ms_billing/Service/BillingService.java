package com.cibertec.ms_billing.Service;

import com.cibertec.ms_billing.Model.Billing;
import org.springframework.http.ResponseEntity;

public interface BillingService {

   ResponseEntity<Object> getAll();

   ResponseEntity<Object> getOne(Integer id);

   ResponseEntity<Object> insert(Billing billing);

   ResponseEntity<Object> update(Integer id, Billing billing);

   ResponseEntity<Object> delete(Integer id);
}
