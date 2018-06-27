package org.a2lpo.purchase.joint.purchase.domain.settings;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "setting_notification")
@Data

public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private boolean telegram;
    private boolean whatsUp;
    private boolean viber;
    private boolean sms;
    private boolean email;
    private boolean socialVk;
    private boolean push;
}
