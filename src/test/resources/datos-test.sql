/* Populate tables */
INSERT INTO categories (name) VALUES('Categoria');
INSERT INTO categories (name) VALUES('Peluquería');
INSERT INTO categories (name) VALUES('Clínica');

-- Insertamos peluquerías --
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company', 'Barberia Rapiño', 'company@ua', '123', '625495788', 'Aspe, España', '09:00', '20:00', 'false', '2');

-- Insertamos labours peluquerías --
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Corte de pelo', '30', '12', 'true', '1');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Tinte', '60', '24', 'true', '1');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Corte de pelo y barba', '30', '15', 'true', '1');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Decoloracion', '60', '20', 'true', '1');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Peinado', '30', '10', 'true', '1');

-- Insertamos customers --
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer1', 'Cliente1', 'cliente@ua', '123', '671542529', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer2', 'Cliente2', 'cliente@ua', '123', '123456789', 'male', '1990-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer3', 'Cliente3', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');

/* INSERTAMOS REVIEWS EN EMPRESA CON ID 1 Rapiño */
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio', '4', '1', '1');

/* INSERTAMOS RESERVAS EN EMPRESA CON ID 1 Rapiño */

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-21', '13:30', '14:00', '1', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-22', '16:00', '16:30', '1', '2', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-29', '17:00', '17:30', '1', '3', '5', '1');
