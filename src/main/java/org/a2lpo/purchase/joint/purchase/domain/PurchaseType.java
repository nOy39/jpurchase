package org.a2lpo.purchase.joint.purchase.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PurchaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String type;

}
