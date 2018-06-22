package org.a2lpo.purchase.joint.purchase.domain.eav;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class EavTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String details;
    private String value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    private Article article;
}
