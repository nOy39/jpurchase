package org.a2lpo.purchase.joint.purchase.repos;

import org.a2lpo.purchase.joint.purchase.domain.eav.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
}
