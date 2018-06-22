package org.a2lpo.purchase.joint.purchase.repos;

import org.a2lpo.purchase.joint.purchase.domain.eav.EavTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThingRepo extends JpaRepository<EavTable, Long> {
}
