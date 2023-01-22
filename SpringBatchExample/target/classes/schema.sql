DROP TABLE IF EXISTS person;

CREATE TABLE sbisavings  (
    account_id BIGINT auto_increment NOT NULL PRIMARY KEY,
    account_name VARCHAR(40),
    balance VARCHAR(40)
);

CREATE TABLE hdfc.hdfcsavings  (
    account_id BIGINT auto_increment NOT NULL PRIMARY KEY,
    account_name VARCHAR(40),
    balance VARCHAR(40)
);

insert into sbi.sbisavings(account_name,balance) values('VIJAY',10000);

insert into sbi.sbisavings(account_name,balance) values('sandhya',5000);

insert into hdfc.hdfcsavings(account_name,balance) values('ramu',10000);

insert into hdfc.hdfcsavings(account_name,balance) values('sita',5000);