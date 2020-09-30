-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-05-08 01:36:40.693
--MODIFICACION
-- Table: feature
CREATE TABLE feature (
    feature_id serial  NOT NULL,
    feature_code varchar(50)  NOT NULL,
    feature_name varchar(100)  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT feature_pk PRIMARY KEY (feature_id)
);
-- Table: role
CREATE TABLE role (
    role_id serial  NOT NULL,
    role_name varchar(100)  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (role_id)
);

-- Table: role_feature
CREATE TABLE role_feature (
    role_feature_id serial  NOT NULL,
    role_id int  NOT NULL,
    feature_id int  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT role_feature_pk PRIMARY KEY (role_feature_id)
);
-- Table: user
CREATE TABLE "user" (
    user_id serial  NOT NULL,
    username varchar(100)  NOT NULL,
    password varchar(100)  NOT NULL,
    email varchar(100)  NOT NULL,
    phone_number varchar(50)  NOT NULL,
    cat_user_status varchar(30)  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
);

-- Table: user_role
CREATE TABLE user_role (
    user_role_id serial  NOT NULL,
    role_id int  NOT NULL,
    user_id int  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (user_role_id)
);

-- Reference: role_feature_feature (table: role_feature)
ALTER TABLE role_feature ADD CONSTRAINT role_feature_feature
    FOREIGN KEY (feature_id)
    REFERENCES feature (feature_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: role_feature_role (table: role_feature)
ALTER TABLE role_feature ADD CONSTRAINT role_feature_role
    FOREIGN KEY (role_id)
    REFERENCES role (role_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role
    FOREIGN KEY (role_id)
    REFERENCES role (role_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (user_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;
-- Table: category
CREATE TABLE category (
    category_id serial  NOT NULL ,
    category_name varchar(30)  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT category_pk PRIMARY KEY (category_id)
);
ALTER SEQUENCE caterogy_category_id_seq
OWNED BY category.category_id;
-- Table: product
CREATE TABLE product (
    product_id serial  NOT NULL,
    category_id int  NOT NULL,
    provider_id int NOT NULL,
    product_code varchar(30)  NOT NULL,
    author varchar(100)  NOT NULL,
    product_name varchar(100)  NOT NULL,
    product_description varchar(500) NULL,
    image varchar(100) NULL,
    unit_price decimal(10,5)  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (product_id)
);

-- Table: person
CREATE TABLE person (
    person_id serial  NOT NULL,
    user_id int NOT NULL,
    first_name varchar(100)  NOT NULL,
    second_name varchar(100)  NULL,
    third_name varchar(100)  NULL,
    first_surname varchar(100)  NOT NULL,
    second_surname varchar(100)  NULL,
    third_surname varchar(100)  NULL,
    birthdate date  NULL,
	zone_direction varchar(100),
	street_direction varchar(100),
    document_id varchar(100)  NOT NULL,
    document_expedition varchar(30)  NULL,
    cat_document_type varchar(30)  NULL,
    cat_genre varchar(30)  NULL,
    cat_marital_status varchar(30)  NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (person_id)
);
-- Table: order
CREATE TABLE "order" (
    order_id serial  NOT NULL,
    user_id int  NOT NULL,
    date timestamp  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (order_id)
);

-- Reference: order_user (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (user_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Table: product_order
CREATE TABLE product_order (
    provider_product_id serial  NOT NULL,
    order_id int  NOT NULL,
    product_id int  NOT NULL,
    qtty_requested int  NOT NULL,
    unit_price decimal(10,5)  NOT NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT product_order_pk PRIMARY KEY (provider_product_id)
);
-- Reference: product_order_order (table: product_order)
ALTER TABLE product_order ADD CONSTRAINT product_order_order
    FOREIGN KEY (order_id)
    REFERENCES "order" (order_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;
-- Reference: product_order_product (table: product_order)
ALTER TABLE product_order ADD CONSTRAINT product_order_product
    FOREIGN KEY (product_id)
    REFERENCES product (product_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;





-- Table: provider
CREATE TABLE provider (
    provider_id serial  NOT NULL,
    provider_name varchar(100) NOT NULL,
    provider_zone varchar(100)  NOT NULL,
    provider_street varchar(100)  NOT NULL,
    email varchar(100) NOT NULL,
    phone varchar(100) NOT NULL,
    phone2 varchar(100) ,
    latitude real  NULL,
    longitude real  NULL,
    status int  NOT NULL,
    tx_id int  NOT NULL,
    tx_username varchar(100)  NOT NULL,
    tx_host varchar(100)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT provider_pk PRIMARY KEY (provider_id)
);






-- Reference: product_category (table: product_category)
ALTER TABLE product ADD CONSTRAINT product_category
    FOREIGN KEY (category_id)
    REFERENCES category (category_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;
-- Reference: product_provider (table: product_provider)
ALTER TABLE product ADD CONSTRAINT product_provider
    FOREIGN KEY (provider_id)
    REFERENCES provider (provider_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: product_provider (table: product_provider)
ALTER TABLE person ADD CONSTRAINT person_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (user_id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;
--aqui acaba