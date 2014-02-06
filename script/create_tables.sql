-- customer table
create table if not exists customer (   C_CUSTKEY INTEGER not null primary key, C_NAME VARCHAR, C_ADDRESS VARCHAR, C_NATIONKEY INTEGER, C_PHONE VARCHAR, C_ACCTBAL VARCHAR, C_MKTSEGMENT VARCHAR, C_COMMENT VARCHAR, C_EMPTY VARCHAR);

-- supplier table
create table if not exists supplier (S_SUPPKEY INTEGER not null primary key, S_NAME VARCHAR, S_ADDRESS VARCHAR, S_NATIONKEY INTEGER, S_PHONE VARCHAR, S_ACCTBAL DOUBLE, S_COMMENT VARCHAR, S_EMPTY VARCHAR);

-- orders table
create table if not exists orders (O_ORDERKEY INTEGER not null primary key, O_CUSTKEY INTEGER not null, O_ORDERSTATUS VARCHAR, O_TOTALPRICE DOUBLE, O_ORDERDATE VARCHAR, O_ORDERPRIORITY VARCHAR, O_CLERK VARCHAR, O_SHIPPRIORITY INTEGER, O_COMMENT VARCHAR, O_EMPTY VARCHAR);

-- lineitem table
Create table if not exists lineitem (L_ORDERKEY INTEGER not null, L_PARTKEY INTEGER not null, L_SUPPKEY INTEGER not null, L_LINENUMBER INTEGER not null, L_QUANTITY DOUBLE, L_EXTENDEDPRICE DOUBLE, L_DISCOUNT DOUBLE, L_TAX DOUBLE, L_RETURNFLAG VARCHAR, L_LINESTATUS VARCHAR, L_SHIPDATE VARCHAR, L_COMMITDATE VARCHAR, L_RECEIPTDATE VARCHAR, L_SHIPINSTRUCT VARCHAR, L_SHIPMODE VARCHAR, L_COMMENT VARCHAR, L_EMPTY VARCHAR constraint lpk primary key(L_ORDERKEY, L_LINENUMBER));

-- part table
create table if not exists part (P_PARTKEY INTEGER not null primary key, P_NAME VARCHAR, P_MFGR VARCHAR, P_BRAND VARCHAR, P_TYPE VARCHAR, P_SIZE INTEGER, P_CONTAINER VARCHAR, P_RETAILPRICE DOUBLE, P_COMMENT VARCHAR, P_EMPTY VARCHAR);

--partsupp table
create table if not exists partsupp (PS_PARTKEY INTEGER not null, PS_SUPPKEY INTEGER not null, PS_AVAILQTY INTEGER, PS_SUPPLYCOST DOUBLE, PS_COMMENT VARCHAR, PS_EMPTY VARCHAR CONSTRAINT PK_PS PRIMARY KEY (PS_PARTKEY, PS_SUPPKEY));

-- nation table
create table if not exists nation (N_NATIONKEY INTEGER not null primary key, N_NAME VARCHAR, N_REGIONKEY INTEGER not null, N_COMMENT VARCHAR, N_EMPTY VARCHAR);

-- region table
create table if not exists region (R_REGIONKEY INTEGER not null primary key, R_NAME VARCHAR, R_COMMENT VARCHAR, R_EMPTY VARCHAR);