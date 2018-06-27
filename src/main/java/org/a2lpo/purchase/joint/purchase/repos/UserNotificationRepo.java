package org.a2lpo.purchase.joint.purchase.repos;

import org.a2lpo.purchase.joint.purchase.domain.user.User;
import org.a2lpo.purchase.joint.purchase.domain.user.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotificationRepo extends JpaRepository<UserNotification, Long> {
    UserNotification findByUser(User user);
}
