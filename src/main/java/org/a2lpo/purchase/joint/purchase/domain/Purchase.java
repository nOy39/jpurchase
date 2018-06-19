package org.a2lpo.purchase.joint.purchase.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_type_id")
    private PurchaseType purchaseCategory;

}
