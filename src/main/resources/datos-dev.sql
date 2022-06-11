/* Populate tables */
INSERT INTO categories (name) VALUES('Categoria');
INSERT INTO categories (name) VALUES('Peluquería');
INSERT INTO categories (name) VALUES('Clínica');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, category_id)
    VALUES('company', 'Empresa', 'company@ua', '123', '123456789', 'Aspe', '09:00', '20:00', '2');
INSERT INTO labours (name, duration, price, company_id)
    VALUES('Corte de pelo', '30', '12', '1');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer1', 'Cliente', 'cliente@ua', '123', '123456789', 'male', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer2', 'Cliente', 'cliente@ua', '123', '123456789', 'male', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer3', 'Cliente', 'cliente@ua', '123', '123456789', 'male', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer4', 'Cliente', 'cliente@ua', '123', '123456789', 'female', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer5', 'Cliente', 'cliente@ua', '123', '123456789', 'female', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer6', 'Cliente', 'cliente@ua', '123', '123456789', 'female', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer7', 'Cliente', 'cliente@ua', '123', '123456789', 'female', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer8', 'Cliente', 'cliente@ua', '123', '123456789', 'female', '2022-05-12');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
    VALUES('2022-05-25', 'starthour', 'endhour', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
    VALUES('2022-06-10', 'starthour', 'endhour', '1', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
    VALUES('2022-06-08', 'starthour', 'endhour', '1', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
    VALUES('2022-05-05', 'starthour', 'endhour', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
    VALUES('2022-04-20', 'starthour', 'endhour', '1', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
    VALUES('2022-06-13', 'starthour', 'endhour', '1', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
    VALUES('2022-02-13', 'starthour', 'endhour', '1', '7', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
    VALUES('2022-02-16', 'starthour', 'endhour', '1', '8', '1');