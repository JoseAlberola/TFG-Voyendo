/* Populate tables */
INSERT INTO categories (name) VALUES('Categoria');
INSERT INTO categories (name) VALUES('Peluquería');
INSERT INTO categories (name) VALUES('Clínica');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, category_id)
    VALUES('company', 'Empresa', 'company@ua', '123', '123456789', 'Aspe', '09:00', '20:00', '2');
INSERT INTO labours (name, duration, price, company_id)
    VALUES('Corte de pelo', '30', '12', '1');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer', 'Cliente', 'cliente@ua', '123', '123456789', 'male', '2022-05-12');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
    VALUES('2022-05-25', 'starthour', 'endhour', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id)
    VALUES('2022-06-13', 'starthour', 'endhour', '1', '1', '1');
