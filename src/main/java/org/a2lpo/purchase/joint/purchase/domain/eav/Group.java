package org.a2lpo.purchase.joint.purchase.domain.eav;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grp_details")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "group_details_saving",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "article_details_id")
    )
    private List<GroupArticleDetails> detailsList;
}
