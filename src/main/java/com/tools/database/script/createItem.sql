create table item
(
    item_id  binary(16),
    owner_id binary(16),
    name     varchar(150),
    primary key (item_id),
    foreign key (owner_id) references user (uuid)
);
