create table account (
username varchar(20),
balance smallint
)

create table book (
isbn int,
book_name varchar(20),
price smallint
)

create table book_stock (
isbn int,
stock smallint,
check(stock > 0)
)



insert into account values("AA", 160)

insert into book values
(1001, "Java", 100),
(1002, "Oracle", 70)

insert into book_stock values
(1001, 4),
(1002, 8)

select * from account

select * from book

select * from book_stock
delete from account


update book_stock set stock = 10

