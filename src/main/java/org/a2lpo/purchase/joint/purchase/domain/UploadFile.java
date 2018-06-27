package org.a2lpo.purchase.joint.purchase.domain;

import lombok.Data;
import org.a2lpo.purchase.joint.purchase.domain.eav.Article;

import javax.persistence.*;

@Entity
@Data
public class UploadFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serverFilename;
    private String originalFilename;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    private Article article;
}
