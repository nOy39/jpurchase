create table article (
  id int8 not null,
  brand varchar(255),
  name varchar(255),
  price numeric(19, 2),
  category_id int8,
  primary key (id)
);

create table article_details (
  id int8 not null,
  name varchar(255),
  primary key (id)
);

create table category (
  id int8 not null,
  name varchar(255),
  primary key (id)
);

create table category_details (
  category_id int8 not null,
  details_set_id int8 not null
);

create table thing_purchase (
  id int8 not null,
  details varchar(255),
  value varchar(255),
  article_id int8,
  primary key (id)
);

alter table if
  exists article
  add constraint FKy5kkohbk00g0w88fi05k2hcw
  foreign key (category_id)
  references category;

alter table if
  exists category_details
  add constraint FKeukvoeyw4q67cd14lny677elj
  foreign key (details_set_id)
  references article_details;

alter table if
  exists category_details
  add constraint FKnpx4ve3aor0lgvdfg9ym5kgiq
  foreign key (category_id)
  references category;

alter table if
  exists thing_purchase
  add constraint FKcnlc58wy25fn683v93mbb9stf
  foreign key (article_id)
  references article;
