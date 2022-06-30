/* Populate tables */
INSERT INTO categories (name) VALUES('Categoria');
INSERT INTO categories (name) VALUES('Peluquería');
INSERT INTO categories (name) VALUES('Clínica');

INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company', 'Empresa', 'company@ua', '123', '123456789', 'Aspe', '09:00', '20:00', 'false', '2');

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

INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer1', 'Cliente1', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
    VALUES('customer2', 'Cliente2', 'cliente@ua', '123', '123456789', 'female', '1990-05-12');
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
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer25', 'Cliente25', 'cliente@ua', '123', '123456789', 'male', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer26', 'Cliente26', 'cliente@ua', '123', '123456789', 'male', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer27', 'Cliente27', 'cliente@ua', '123', '123456789', 'female', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer28', 'Cliente28', 'cliente@ua', '123', '123456789', 'male', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer29', 'Cliente29', 'cliente@ua', '123', '123456789', 'female', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer30', 'Cliente30', 'cliente@ua', '123', '123456789', 'female', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer31', 'Cliente31', 'cliente@ua', '123', '123456789', 'male', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer32', 'Cliente32', 'cliente@ua', '123', '123456789', 'male', '2022-05-12');

/* INSERTAMOS REVIEWS */
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio Me ha encantado el servicio Me ha encantado el servicio', '4', '1', '1');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio', '3', '1', '1');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio si si si', '1', '1', '1');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio', '2', '1', '1');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicioole mi tio', '5', '1', '1');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio', '5', '1', '1');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Deja mucho que desear, nada profesional', '2', '1', '2');

/* INSERTAMOS RESERVAS EN EMPRESA CON ID 1*/
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-13', '09:00', '09:30', '1', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id,  labour_id, appointment_type, customer_id)
VALUES('2021-12-13', '09:30', '10:30', '1', '2', '1', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-13', '11:00', '12:00', '1', '2', '1', '3');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-17', '10:00', '10:30', '1', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-17', '10:30', '11:00', '1', '5', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-22', '14:00', '15:00', '1', '6', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '09:00', '09:30', '1', '7', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '09:30', '10:00', '1', '8', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '10:00', '10:30', '1', '12', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '12:00', '12:30', '1', '7', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '12:30', '13:00', '1', '3', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '13:00', '14:00', '1', '11', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '14:00', '15:00', '1', '15', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '15:00', '15:30', '1', '5', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '15:30', '16:00', '1', '4', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '16:00', '17:00', '1', '6', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '17:00', '17:30', '1', '1', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '17:30', '18:00', '1', '2', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '18:00', '18:30', '1', '13', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2021-12-23', '19:30', '20:00', '1', '13', '5', '1');


INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-03', '10:00', '11:00', '1', '9', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-03', '17:00', '17:30', '1', '3', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-06', '09:00', '10:00', '1', '10', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-11', '11:30', '12:00', '1', '11', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-18', '12:00', '12:30', '1', '12', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-21', '11:00', '12:00', '1', '6', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-21', '13:30', '14:00', '1', '15', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-25', '09:00', '09:30', '1', '13', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-25', '09:30', '10:00', '1', '9', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-25', '10:00', '10:30', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-25', '10:30', '11:30', '1', '6', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-25', '12:00', '12:30', '1', '11', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-25', '12:30', '13:00', '1', '12', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-25', '14:00', '15:00', '1', '14', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-25', '15:00', '16:00', '1', '3', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-25', '16:00', '16:30', '1', '17', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-25', '18:00', '18:30', '1', '13', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-25', '18:30', '19:00', '1', '15', '5', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-03', '10:00', '11:00', '1', '9', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-03', '12:00', '12:30', '1', '16', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-06', '11:00', '11:30', '1', '17', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-11', '18:00', '18:30', '1', '4', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-18', '19:30', '20:00', '1', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-21', '12:00', '13:00', '1', '20', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-21', '09:00', '09:30', '1', '19', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-21', '17:00', '17:30', '1', '20', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-25', '10:30', '11:30', '1', '16', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-25', '11:30', '12:00', '1', '17', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-25', '12:00', '13:00', '1', '21', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-25', '13:00', '13:30', '1', '18', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-25', '15:30', '16:00', '1', '11', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-25', '16:00', '16:30', '1', '7', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-25', '16:30', '17:30', '1', '22', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-25', '18:00', '19:00', '1', '20', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-25', '19:00', '19:30', '1', '25', '5', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-03', '10:00', '10:30', '1', '2', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-03', '12:00', '12:30', '1', '3', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-07', '18:00', '18:30', '1', '5', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-11', '17:30', '18:00', '1', '12', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-18', '09:30', '10:00', '1', '15', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-21', '10:00', '10:30', '1', '10', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-21', '10:30', '11:00', '1', '23', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-21', '12:30', '13:00', '1', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-21', '19:00', '19:30', '1', '8', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-25', '09:00', '09:30', '1', '24', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-25', '09:30', '10:00', '1', '4', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-25', '10:00', '10:30', '1', '2', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-25', '10:30', '11:30', '1', '28', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-25', '12:00', '13:00', '1', '26', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-25', '13:00', '14:00', '1', '24', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-25', '15:00', '16:00', '1', '12', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-25', '16:00', '16:30', '1', '16', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-25', '16:30', '17:00', '1', '11', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-25', '18:00', '18:30', '1', '8', '3', '1');


INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-04', '10:00', '11:00', '1', '18', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-04', '12:00', '13:00', '1', '20', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-07', '16:00', '17:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-11', '09:00', '10:00', '1', '22', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-18', '11:00', '12:00', '1', '21', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-21', '10:00', '10:30', '1', '14', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-21', '11:00', '11:30', '1', '3', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-25', '10:30', '11:00', '1', '5', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-25', '11:00', '11:30', '1', '1', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-25', '17:00', '18:00', '1', '2', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-25', '18:30', '19:00', '1', '29', '5', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-04', '09:00', '10:00', '1', '17', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-04', '12:30', '13:30', '1', '12', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-06', '14:00', '15:00', '1', '1', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-11', '10:00', '11:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-16', '11:30', '12:00', '1', '24', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-17', '12:00', '12:30', '1', '11', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-18', '16:00', '17:00', '1', '23', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-18', '17:00', '17:30', '1', '10', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-20', '09:30', '10:00', '1', '13', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-20', '10:00', '10:30', '1', '13', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-20', '11:30', '12:00', '1', '9', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-25', '10:00', '10:30', '1', '15', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-25', '11:00', '11:30', '1', '7', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '09:00', '09:30', '1', '23', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '09:30', '10:00', '1', '25', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '10:00', '10:30', '1', '26', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '10:30', '11:00', '1', '32', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '11:00', '11:30', '1', '13', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '11:30', '12:00', '1', '21', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '12:00', '13:00', '1', '14', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '13:00', '14:00', '1', '9', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '15:30', '16:00', '1', '10', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '16:00', '16:30', '1', '6', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '17:00', '17:30', '1', '14', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '17:30', '18:00', '1', '23', '5', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-03', '11:00', '11:30', '1', '7', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-03', '12:30', '13:00', '1', '2', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-06', '10:00', '11:00', '1', '15', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-10', '17:00', '18:00', '1', '9', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-17', '09:00', '10:00', '1', '8', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '10:00', '10:30', '1', '16', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '10:30', '11:00', '1', '5', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '11:00', '11:30', '1', '17', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '12:00', '13:00', '1', '24', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '13:00', '14:00', '1', '31', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '14:00', '15:00', '1', '29', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '15:00', '15:30', '1', '12', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '16:30', '17:00', '1', '6', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '17:00', '18:00', '1', '1', '4', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '09:30', '10:00', '1', '7', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '11:00', '11:30', '1', '2', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-05', '10:00', '10:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-06', '11:30', '12:30', '1', '15', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-08', '09:00', '10:00', '1', '20', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-08', '10:00', '11:00', '1', '24', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-11', '11:00', '12:00', '1', '19', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-13', '16:00', '16:30', '1', '21', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-13', '18:00', '19:00', '1', '5', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-15', '13:00', '13:30', '1', '10', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-18', '10:00', '11:00', '1', '18', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-19', '09:00', '09:30', '1', '4', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '11:00', '11:30', '1', '7', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '11:30', '12:00', '1', '5', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '13:30', '14:00', '1', '17', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '16:00', '16:30', '1', '4', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '18:30', '19:00', '1', '12', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '19:00', '19:30', '1', '2', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '19:30', '20:00', '1', '3', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '09:00', '09:30', '1', '4', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '09:30', '10:00', '1', '30', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '10:00', '11:00', '1', '29', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '11:00', '12:00', '1', '28', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '12:00', '13:00', '1', '27', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '13:00', '13:30', '1', '26', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '13:30', '14:00', '1', '25', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '15:30', '16:00', '1', '31', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '16:00', '16:30', '1', '32', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '17:00', '17:30', '1', '19', '5', '1');