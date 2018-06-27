package org.a2lpo.purchase.joint.purchase.domain.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "notification")
@Data
public class UserNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private boolean telegram;
    private boolean whatsUp;
    private boolean viber;
    private boolean sms;
    private boolean email;
    private boolean socialVk;
    private boolean push;
}
