package com.cibertec.ms_billing.Repository;

import com.cibertec.ms_billing.Model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {


}
