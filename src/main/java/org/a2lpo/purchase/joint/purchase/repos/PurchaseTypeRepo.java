package org.a2lpo.purchase.joint.purchase.repos;

import org.a2lpo.purchase.joint.purchase.domain.PurchaseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseTypeRepo extends JpaRepository<PurchaseType, Long> {
}
