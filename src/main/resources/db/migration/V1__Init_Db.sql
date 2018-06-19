create table purchase (id int8 not null, description varchar(255), title varchar(255), user_id int8, purchase_type_id int8, primary key (id));
create table purchase_type (id int8 not null, type varchar(255), primary key (id));
create table user_roles (user_id int8 not null, roles varchar(255));
create table usr (id int8 not null, activation_code varchar(255), active boolean not null, email varchar(255), password varchar(255), username varchar(255), primary key (id));
create sequence hibernate_sequence start 1 increment 1;
alter table if exists purchase add constraint FK3r66gfyxphi1ed3wlnaxqvc19 foreign key (user_id) references usr;
alter table if exists purchase add constraint FK7swf6bsw71ldkbnkkq4e1ynp6 foreign key (purchase_type_id) references purchase_type;
alter table if exists user_roles add constraint FKg6agnwreityp2vf23bm2jgjm3 foreign key (user_id) references usr;