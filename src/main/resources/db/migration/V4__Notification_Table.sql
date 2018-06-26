create table notification (
  id int8 not null,
  email boolean not null,
  push boolean not null,
  sms boolean not null,
  social_vk boolean not null,
  telegram boolean not null,
  viber boolean not null,
  whats_up boolean not null,
  user_id int8, primary key (id)
);

alter table if
  exists notification
  add constraint notification_constraint
  foreign key (user_id)
  references usr;