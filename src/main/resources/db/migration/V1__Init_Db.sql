create sequence hibernate_sequence start 1 increment 1;

create table article (
  id int8 not null,
  brand varchar(255),
  category varchar(255),
  description varchar(255),
  name varchar(255),
  price numeric(19, 2),
  group_id int8,
  user_id int8,
  primary key (id)
);

create table eav_table (
  id int8 not null,
  details varchar(255),
  value varchar(255),
  article_id int8,
  primary key (id)
);

create table group_details_saving (
  group_id int8 not null,
  article_details_id int8 not null
);

create table group_article_details (
  id int8 not null,
  name varchar(255),
  primary key (id)
);

create table grp_details (
  id int8 not null,
  name varchar(255),
  primary key (id)
);

create table upload_file (
  id int8 not null,
  original_filename varchar(255),
  server_filename varchar(255),
  project_id int8,
  primary key (id)
);

create table user_roles (
  user_id int8 not null,
  roles varchar(255)
);

create table usr (
  id int8 not null,
  activation_code varchar(255),
  active boolean not null,
  email varchar(255),
  password varchar(255),
  username varchar(255),
  primary key (id)
);

alter table if
  exists article
  add constraint article_constraint_group_id
  foreign key (group_id)
  references grp_details;

alter table if
  exists article
  add constraint article_constraint_user_id
  foreign key (user_id)
  references usr;

alter table if
  exists eav_table
  add constraint eav_table_constraint_article_id
  foreign key (article_id)
  references article;

alter table if
  exists group_details_saving
  add constraint group_details_constraint_article
  foreign key (article_details_id)
  references group_article_details;

alter table if
  exists group_details_saving
  add constraint group_details_constraint_group_id
  foreign key (group_id)
  references grp_details;

alter table if
  exists upload_file
  add constraint upload_file_constraint_article_id
  foreign key (article_id)
  references article;

alter table if
  exists user_roles
  add constraint user_roles_constraint_user_id
  foreign key (user_id)
  references usr;
