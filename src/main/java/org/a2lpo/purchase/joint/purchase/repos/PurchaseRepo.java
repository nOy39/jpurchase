package org.a2lpo.purchase.joint.purchase.repos;

import org.a2lpo.purchase.joint.purchase.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
}
