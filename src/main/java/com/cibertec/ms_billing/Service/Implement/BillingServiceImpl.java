package com.cibertec.ms_billing.Service.Implement;

import com.cibertec.ms_billing.Model.Billing;
import com.cibertec.ms_billing.Repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BillingServiceImpl {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    BillingRepository billingRepository;

    public ResponseEntity<Object> getAll() {
        try {
            List<Billing> billings = billingRepository.findAll();

            if (billings == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(billings);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> getOne(Integer id) {
        try {
            Optional<Billing> billing = billingRepository.findById(id);

            if (!billing.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(billing);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> insert(Billing billing) {
        try {
            Billing entity = billingRepository.save(billing);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(entity.getNum_billing_id()).toUri();

            return ResponseEntity.ok().body(entity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> update(Integer id, Billing billing) {
        try {
            Optional<Billing> entity = billingRepository.findById(id);

            if (!entity.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            billing.setNum_billing_id(id);
            Billing bill = billingRepository.save(billing);
            return ResponseEntity.ok().body(bill);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> delete(Integer id) {

        try {
            Optional<Billing> entity = billingRepository.findById(id);
            if (!entity.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            billingRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
