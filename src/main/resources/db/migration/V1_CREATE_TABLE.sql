create table hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE users(
    id bigint auto_increment primary key,
    email      varchar(255) not null,
    first_name varchar(255) null,
    last_name  varchar(255) null,
    login      varchar(255) not null,
    password   varchar(255) not null
) engine=MyISAM;

CREATE TABLE todo(
    id bigint auto_increment primary key,
    completed bit          null,
    title     varchar(255) null,
    user_id   bigint       null,
    constraint FKdcopxq1yu1u8ijb7rjexhsr6v
        foreign key (user_id) references users (id)
) engine=MyISAM;





