package com.cibertec.ms_billing.Model;

import lombok.*;

import javax.persistence.*;

@SequenceGenerator(name="seq_billing_id", initialValue=1, allocationSize=1)
@Entity
@Data
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_billing_id")
    @Column(name = "num_billing_id")
    private Integer num_billing_id;

    @Column(name = "num_user_id")
    private Integer num_user_id;

    @Column(name = "dte_billing_date")
    private String dte_billing_date;
}
