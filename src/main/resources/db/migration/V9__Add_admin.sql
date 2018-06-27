insert into usr(id, username, password, active, email)
    values (1,'admin','admin',true,'email@email.com');

insert into usr(id, username, password, active,email)
    values (2,'suser','suser',true,'suser@suser.com');

insert into usr(id, username, password, active, email)
    values (3,'org','org',true,'org@org.com');

insert into usr(id, username, password, active,email)
    values (4,'user','user',true,'user@user.com');

insert into user_roles (user_id, roles)
values (1, 'USER'), (1, 'ADMIN'), (1, 'SUPERUSER'), (1, 'ORGANIZER');

insert into user_roles (user_id, roles)
values (2, 'USER'), (2, 'SUPERUSER'), (2, 'ORGANIZER');

insert into user_roles (user_id, roles)
values (4, 'USER');

insert into user_roles (user_id, roles)
values (3, 'USER'), (3, 'ORGANIZER');

