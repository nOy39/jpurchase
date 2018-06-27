package org.a2lpo.purchase.joint.purchase.repos;

import org.a2lpo.purchase.joint.purchase.domain.settings.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationSettingsRepo extends JpaRepository<Notification, Long> {
}
