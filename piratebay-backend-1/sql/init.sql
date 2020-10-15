INSERT INTO "user"
    ( user_id, username, password, email, phone_number,
    cat_user_status, status, tx_id, tx_username, tx_host,
    tx_date)
VALUES
    (  nextval('user_user_id_seq') , 'mgomez', '12345678', 'mgomez@gmail.com', '70655567',
        'ACTIVE', 1, 1, 'root', '127.0.0.1',
        now()
    );


INSERT INTO "user"
( user_id, username, password, email, phone_number,
  cat_user_status, status, tx_id, tx_username, tx_host,
  tx_date)
VALUES
(  nextval('user_user_id_seq') , 'jperez', '6b9ffd71631dd64e1231ef41e138cd29b933c687073c1f72a66571998d9bd2a3', 'jperez@gmail.com', '70655570',
   'ACTIVE', 1, 1, 'root', '127.0.0.1',
   now()
);

INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('PAGE_USER_MANAGEMENT', 'Gestión de usuarios', 1, 1, 'admin', 'localhost', now());

INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('PAGE_WAREHOUSE', 'Gestión de almacenes', 1, 1, 'admin', 'localhost', now());

INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('BUTTON_DELETE_USER', 'Botón para eliminar un usuario', 1, 1, 'admin', 'localhost', now());

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('ADMIN', 1,  1, 'admin', 'localhost', now());

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('PROVIDER', 1,  1, 'admin', 'localhost', now());

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('CLIENT', 1,  1, 'admin', 'localhost', now());

-- ADMIN role
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1, 1, 1,  1, 'admin', 'localhost', now());

INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1, 3, 1,  1, 'admin', 'localhost', now());

-- WAREHOUSE_SUPERVISOR
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 1, 1,  1, 'admin', 'localhost', now());

INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 2, 1,  1, 'admin', 'localhost', now());

-- WAREHOUSE_EMPLOYY
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (3, 2, 1,  1, 'admin', 'localhost', now());

-- CONFIGURACIÓN DE USUARIOS

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 2, 1,  1, 'admin', 'localhost', now());

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 1, 1,  1, 'admin', 'localhost', now());

INSERT INTO "user"
    ( user_id, username, password, email, phone_number,
    cat_user_status, status, tx_id, tx_username, tx_host,
    tx_date)
VALUES
    (  nextval('user_user_id_seq') , 'mgomez', '12345678', 'mgomez@gmail.com', '70655567',
        'ACTIVE', 1, 1, 'root', '127.0.0.1',
        now()
    );

--insert para categoria

INSERT INTO "category" (category_id, category_name, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('caterogy_category_id_seq'), 'Cientifico',1, 1, 'root', '127.0.0.1', now());
INSERT INTO "category" (category_id, category_name, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('category_category_id_seq'), 'Monografias', 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "category" (category_id, category_name, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('category_category_id_seq'), 'Instructivos', 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "category" (category_id, category_name, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('category_category_id_seq'), 'Educativos', 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "category" (category_id, category_name, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('category_category_id_seq'), 'Terror', 1,  1, 'root', '127.0.0.1', now());
INSERT INTO "category" (category_id, category_name, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('category_category_id_seq'), 'Tecnicos', 1,  1, 'root', '127.0.0.1', now());
INSERT INTO "category" (category_id, category_name, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('category_category_id_seq'), 'Religiosos', 1,  1, 'root', '127.0.0.1', now());
INSERT INTO "category" (category_id, category_name, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('category_category_id_seq'), 'Poeticos', 1,  1, 'root', '127.0.0.1', now());
INSERT INTO "category" (category_id, category_name, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('category_category_id_seq'), 'Biograficos', 1,  1, 'root', '127.0.0.1', now());
INSERT INTO "category" (category_id, category_name, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('category_category_id_seq'), 'Artisticos', 1, 1, 'root', '127.0.0.1', now());

--insert para proveedor

INSERT INTO "provider" (provider_id, provider_name, provider_zone, provider_street, email, phone, phone2, latitude, longitude, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('provider_provider_id_seq'), 'ebook', 'Miraflores', 'calle San Salvador #31', 'ebook@gmail.com', '+59170390786', '22227548',0, 0, 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "provider" (provider_id, provider_name, provider_zone, provider_street, email, phone, phone2, latitude, longitude, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('provider_provider_id_seq'), 'WordBooks', 'Obrajes', 'calle 2 #3', 'wordbooks@gmail.com', '+5917039432', '22435548',0, 0, 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "provider" (provider_id, provider_name, provider_zone, provider_street, email, phone, phone2, latitude, longitude, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('provider_provider_id_seq'), 'Nacha', 'Sopocachi', 'calle San Genaro #1988', 'nacha@gmail.com', '+59170395623', '223427548',0, 0, 1, 1, 'root', '127.0.0.1', now());

--insert para product

INSERT INTO "product" (product_id, category_id, provider_id, product_code, author, product_name, product_description, image, unit_price, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('product_product_id_seq'), 1, 3, '0001', 'Charles Darwin', 'El origen de las especies', 'es un libro de Charles Darwin publicado el 24 de noviembre de 1859, considerado uno de los trabajos precursores de la literatura científica y el fundamento de la teoría de la biología evolutiva.','C:\libros\Elorigendelasespecies',130, 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "product" (product_id, category_id, provider_id, product_code, author, product_name, product_description, image, unit_price, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('product_product_id_seq'), 1, 2, '0002', 'Stephen Hawking', 'Breve historia del tiempo', 'del Big Bang a los agujeros negros es un libro de divulgación científica publicado en 1988 y escrito por el físico teórico, astrofísico y cosmólogo británico Stephen Hawking y prologado por Carl Sagan.','C:\libros\Brevehistoriadeltiempo',150, 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "product" (product_id, category_id, provider_id, product_code, author, product_name, product_description, image, unit_price, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('product_product_id_seq'), 1, 1, '0003', 'Rachel Carson', 'Primavera silenciosa', 'es un libro de Rachel Carson publicado el 27 de septiembre de 1962 que advertía de los efectos perjudiciales de los pesticidas en el medio ambiente -especialmente en las aves- y culpaba a la industria química de la creciente contaminación.​','C:\libros\Primaverasilenciosa',120, 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "product" (product_id, category_id, provider_id, product_code, author, product_name, product_description, image, unit_price, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('product_product_id_seq'), 1, 1, '0004', 'Carl Sagan', 'Los dragones del Edén', 'Especulaciones sobre la evolución de la inteligencia humana, es un libro de Carl Sagan galardonado con el Premio Pulitzer en 1978.','C:\libros\LosdragonesdelEdén',140, 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "product" (product_id, category_id, provider_id, product_code, author, product_name, product_description, image, unit_price, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('product_product_id_seq'), 1, 3, '0005', 'Leonard Mlodinow y Stephen Hawking', 'El gran diseño', 'es un libro de divulgación científica escrito por los físicos Stephen Hawking y Leonard Mlodinow, publicado en inglés por la editorial estadounidense Bantam Books el 7 de septiembre de 2010 -el 9 de septiembre en Reino Unido y en español por la Editorial Crítica el 15 de noviembre de 2010.','C:\libros\Elgrandiseño',130, 1, 1, 'root', '127.0.0.1', now());

INSERT INTO "product" (product_id, category_id, provider_id, product_code, author, product_name, product_description, image, unit_price, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('product_product_id_seq'), 5, 2, '0006', 'Bram Stoker', 'Drácula', 'es una novela publicada en 1897 por el irlandés Bram Stoker, quien ha convertido a su protagonista en el vampiro más famoso. Se dice que el escritor se basó en las conversaciones que mantuvo con un erudito húngaro llamado Arminius Vámbéry, quien le habló de Vlad Drăculea.','C:\libros\Drácula',130, 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "product" (product_id, category_id, provider_id, product_code, author, product_name, product_description, image, unit_price, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('product_product_id_seq'), 5, 2, '0007', 'Stephen King', 'It', 'es una novela de terror publicada en 1986 por el escritor estadounidense Stephen King. Cuenta la historia de un grupo de siete niños que son aterrorizados por un malvado monstruo -al que llaman «Eso»- que es capaz de cambiar de forma, alimentándose del terror que produce en sus víctimas.','C:\libros\It',130, 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "product" (product_id, category_id, provider_id, product_code, author, product_name, product_description, image, unit_price, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('product_product_id_seq'), 5, 2, '0008', 'H. P. Lovecraft', 'En las montañas de la locura', 'En las montañas de la locura es una novela del escritor estadounidense H. P. Lovecraft.​','C:\libros\Enlasmontañasdelalocura',130, 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "product" (product_id, category_id, provider_id, product_code, author, product_name, product_description, image, unit_price, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('product_product_id_seq'), 5, 1, '0009', 'Edgar Allan Poe', 'El gato negro', 'es un cuento de horror del escritor estadounidense Edgar Allan Poe, publicado en el periódico Saturday Evening Post de Filadelfia en su número del 19 de agosto de 1843. La crítica lo considera uno de los más espeluznantes de la historia de la literatura.','C:\libros\Elgatonegro',130, 1, 1, 'root', '127.0.0.1', now());
INSERT INTO "product" (product_id, category_id, provider_id, product_code, author, product_name, product_description, image, unit_price, status, tx_id, tx_username, tx_host, tx_date) VALUES (nextval('product_product_id_seq'), 5, 3, '0010', 'Adam L. G. Nevill', 'Apartamento 16', 'En Barrington House, un elegante bloque de pisos londinense, hay un apartamento vacío. Nadie entra, nadie sale. Y ha permanecido así durante cincuenta años.','C:\libros\Apartamento16',130, 1, 1, 'root', '127.0.0.1', now());



