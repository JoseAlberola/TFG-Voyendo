/* Populate tables */
INSERT INTO categories (name) VALUES('Categoria');
INSERT INTO categories (name) VALUES('Peluquería');
INSERT INTO categories (name) VALUES('Clínica');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, category_id)
    VALUES('company', 'Empresa', 'company@ua', '123', '123456789', 'Aspe', '09:00', '20:00', '2');
INSERT INTO labours (name, duration, price, company_id)
    VALUES('Corte de pelo', '30', '12', '1');
INSERT INTO labours (name, duration, price, company_id)
    VALUES('Tinte', '60', '24', '1');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer1', 'Cliente1', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer2', 'Cliente2', 'cliente@ua', '123', '123456789', 'male', '1990-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer3', 'Cliente3', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer4', 'Cliente4', 'cliente@ua', '123', '123456789', 'female', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer5', 'Cliente5', 'cliente@ua', '123', '123456789', 'female', '1970-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer6', 'Cliente6', 'cliente@ua', '123', '123456789', 'female', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer7', 'Cliente7', 'cliente@ua', '123', '123456789', 'female', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer8', 'Cliente8', 'cliente@ua', '123', '123456789', 'female', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer9', 'Cliente9', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer10', 'Cliente10', 'cliente@ua', '123', '123456789', 'male', '1990-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer11', 'Cliente11', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer12', 'Cliente12', 'cliente@ua', '123', '123456789', 'male', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer13', 'Cliente13', 'cliente@ua', '123', '123456789', 'male', '1970-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer14', 'Cliente14', 'cliente@ua', '123', '123456789', 'male', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer15', 'Cliente15', 'cliente@ua', '123', '123456789', 'male', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer16', 'Cliente16', 'cliente@ua', '123', '123456789', 'male', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer17', 'Cliente17', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer18', 'Cliente18', 'cliente@ua', '123', '123456789', 'male', '1990-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer19', 'Cliente19', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer20', 'Cliente20', 'cliente@ua', '123', '123456789', 'female', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer21', 'Cliente21', 'cliente@ua', '123', '123456789', 'female', '1970-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer22', 'Cliente22', 'cliente@ua', '123', '123456789', 'female', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer23', 'Cliente23', 'cliente@ua', '123', '123456789', 'female', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer24', 'Cliente24', 'cliente@ua', '123', '123456789', 'female', '2022-05-12');

/* INSERTAMOS RESERVAS EN EMPRESA CON ID 1*/
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2021-12-13', 'starthour', 'endhour', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2021-12-13', 'starthour', 'endhour', '1', '2', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2021-12-13', 'starthour', 'endhour', '1', '3', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2021-12-17', 'starthour', 'endhour', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2021-12-17', 'starthour', 'endhour', '1', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2021-12-22', 'starthour', 'endhour', '1', '6', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2021-12-23', 'starthour', 'endhour', '1', '7', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2021-12-23', 'starthour', 'endhour', '1', '8', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-01-03', 'starthour', 'endhour', '1', '9', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-01-03', 'starthour', 'endhour', '1', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-01-06', 'starthour', 'endhour', '1', '10', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-01-11', 'starthour', 'endhour', '1', '11', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-01-18', 'starthour', 'endhour', '1', '12', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-01-21', 'starthour', 'endhour', '1', '6', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-01-21', 'starthour', 'endhour', '1', '15', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-01-25', 'starthour', 'endhour', '1', '13', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-02-03', 'starthour', 'endhour', '1', '9', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-02-03', 'starthour', 'endhour', '1', '16', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-02-06', 'starthour', 'endhour', '1', '17', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-02-11', 'starthour', 'endhour', '1', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-02-18', 'starthour', 'endhour', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-02-21', 'starthour', 'endhour', '1', '20', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-02-21', 'starthour', 'endhour', '1', '19', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-02-21', 'starthour', 'endhour', '1', '20', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-02-25', 'starthour', 'endhour', '1', '16', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-02-25', 'starthour', 'endhour', '1', '17', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-02-25', 'starthour', 'endhour', '1', '21', '2');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-03-03', 'starthour', 'endhour', '1', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-03-03', 'starthour', 'endhour', '1', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-03-07', 'starthour', 'endhour', '1', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-03-11', 'starthour', 'endhour', '1', '12', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-03-18', 'starthour', 'endhour', '1', '15', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-03-21', 'starthour', 'endhour', '1', '10', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-03-21', 'starthour', 'endhour', '1', '23', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-03-21', 'starthour', 'endhour', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-03-21', 'starthour', 'endhour', '1', '8', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-03-25', 'starthour', 'endhour', '1', '24', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-04-04', 'starthour', 'endhour', '1', '18', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-04-04', 'starthour', 'endhour', '1', '20', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-04-07', 'starthour', 'endhour', '1', '2', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-04-11', 'starthour', 'endhour', '1', '22', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-04-18', 'starthour', 'endhour', '1', '21', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-04-21', 'starthour', 'endhour', '1', '14', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-04-21', 'starthour', 'endhour', '1', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-04-25', 'starthour', 'endhour', '1', '5', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-04', 'starthour', 'endhour', '1', '17', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-04', 'starthour', 'endhour', '1', '12', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-06', 'starthour', 'endhour', '1', '1', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-11', 'starthour', 'endhour', '1', '2', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-16', 'starthour', 'endhour', '1', '24', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-17', 'starthour', 'endhour', '1', '11', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-18', 'starthour', 'endhour', '1', '23', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-18', 'starthour', 'endhour', '1', '10', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-20', 'starthour', 'endhour', '1', '13', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-20', 'starthour', 'endhour', '1', '13', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-20', 'starthour', 'endhour', '1', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-25', 'starthour', 'endhour', '1', '15', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-25', 'starthour', 'endhour', '1', '7', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-05-27', 'starthour', 'endhour', '1', '23', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-06-03', 'starthour', 'endhour', '1', '7', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-06-03', 'starthour', 'endhour', '1', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-06-06', 'starthour', 'endhour', '1', '15', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-06-10', 'starthour', 'endhour', '1', '9', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-06-17', 'starthour', 'endhour', '1', '8', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-06-20', 'starthour', 'endhour', '1', '16', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-04', 'starthour', 'endhour', '1', '7', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-04', 'starthour', 'endhour', '1', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-05', 'starthour', 'endhour', '1', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-06', 'starthour', 'endhour', '1', '15', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-08', 'starthour', 'endhour', '1', '20', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-08', 'starthour', 'endhour', '1', '24', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-11', 'starthour', 'endhour', '1', '19', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-13', 'starthour', 'endhour', '1', '21', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-13', 'starthour', 'endhour', '1', '5', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-15', 'starthour', 'endhour', '1', '10', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-18', 'starthour', 'endhour', '1', '18', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-19', 'starthour', 'endhour', '1', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-20', 'starthour', 'endhour', '1', '7', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-20', 'starthour', 'endhour', '1', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-20', 'starthour', 'endhour', '1', '17', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-25', 'starthour', 'endhour', '1', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
VALUES('2022-07-25', 'starthour', 'endhour', '1', '12', '1');
