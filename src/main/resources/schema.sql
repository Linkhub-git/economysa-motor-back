create table oauth_access_token
(
    token_id varchar(256) null,
    token blob null,
    authentication_id varchar(256) not null
        primary key,
    user_name varchar(256) null,
    client_id varchar(256) null,
    authentication blob null,
    refresh_token varchar(256) null
);

create table oauth_refresh_token
(
    token_id varchar(256) null,
    token blob null,
    authentication blob null
);

create table USER
(
    id int(19) not null
        primary key,
    email varchar(50) not null,
    password varchar(256) not null,
    role varchar(10) not null,
    name varchar(100) not null,
    last_name varchar(100) not null,
    phone varchar(9) null,
    creation_date timestamp(6) null,
    status int(1) not null
);