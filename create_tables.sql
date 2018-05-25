create table Contacts
(
  id                       int auto_increment,
  first_name               varchar(30) not null,
  surname                  varchar(30) not null,
  phone_number             varchar(13) not null,
  alternative_phone_number varchar(13) not null,
  email                    varchar(30) not null,
  alternative_email        varchar(30) not null,
  constraint id
  unique (id)
);

alter table Contacts
  add primary key (id);

create table Gymnasts
(
  id                    int auto_increment
    primary key,
  first_name            varchar(30) not null,
  surname               varchar(30) not null,
  identification_number varchar(13) not null,
  date_of_birth         varchar(10) not null
);

create table Gymnasts_Additional
(
  id             int auto_increment
    primary key,
  gymnast_id     int         not null,
  middle_name    varchar(30) not null,
  preferred_name varchar(30) not null,
  category       varchar(10) not null,
  constraint gymnast_id
  unique (gymnast_id)
);

create table Gymnasts_Address
(
  id             int auto_increment
    primary key,
  gymnast_id     int          not null,
  address_line_1 varchar(200) not null,
  address_line_2 varchar(200) not null,
  address_line_3 varchar(200) not null,
  address_code   varchar(30)  not null,
  school         varchar(200) not null,
  constraint gymnast_id
  unique (gymnast_id)
);

create table Gymnasts_Contacts
(
  id              int auto_increment,
  gymnast_id      int                    not null,
  contact_id      int                    not null,
  primary_contact tinyint(1) default '0' not null,
  relationship    varchar(30)            not null,
  constraint gymnast_id
  unique (gymnast_id, contact_id),
  constraint id
  unique (id)
);

alter table Gymnasts_Contacts
  add primary key (id);

create table Gymnasts_Events
(
  id         int auto_increment
    primary key,
  gymnast_id int                     not null,
  date       date                    not null,
  event_type varchar(10) default '1' not null,
  constraint gymnast_id
  unique (gymnast_id)
);

create table Gymnasts_Legal
(
  id                     int auto_increment
    primary key,
  gymnast_id             int                                     not null,
  indemnity_form_date    timestamp default CURRENT_TIMESTAMP     not null,
  registration_form_date timestamp default '0000-00-00 00:00:00' not null,
  constraint gymnast_id
  unique (gymnast_id)
);

create table Gymnasts_Medical
(
  id                    int auto_increment
    primary key,
  gymnast_id            int          not null,
  medical_aid_name      varchar(30)  not null,
  medical_aid_number    varchar(30)  not null,
  physical_disabilities varchar(100) not null,
  constraint gymnast_id
  unique (gymnast_id)
);

create table Gymnasts_Transactions
(
  id             int auto_increment
    primary key,
  gymnast_id     int          not null,
  date           date         not null,
  amount         double       not null,
  payment_type   varchar(30)  not null,
  payment_method varchar(30)  not null,
  notes          varchar(200) not null
);
