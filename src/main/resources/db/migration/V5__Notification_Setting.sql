create table setting_notification (
  id int8 not null,
  email boolean not null,
  push boolean not null,
  sms boolean not null,
  social_vk boolean not null,
  telegram boolean not null,
  viber boolean not null,
  whats_up boolean not null,
  primary key (id)
);
