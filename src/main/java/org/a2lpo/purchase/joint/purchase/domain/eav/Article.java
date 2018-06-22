package org.a2lpo.purchase.joint.purchase.domain.eav;

import lombok.Data;
import org.a2lpo.purchase.joint.purchase.domain.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;
    private String name;
    private String category;
    private BigDecimal price;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User organizer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;
}
