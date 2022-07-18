/* Populate tables */
INSERT INTO categories (name) VALUES('Categoria');
INSERT INTO categories (name) VALUES('Peluquería');
INSERT INTO categories (name) VALUES('Clínica');
INSERT INTO categories (name) VALUES('Tatuajes');
INSERT INTO categories (name) VALUES('Psicología');

-- Insertamos peluquerías --
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company', 'Barberia Rapiño', 'company@ua', '123', '625495788', 'Aspe, España', '09:00', '20:00', 'false', '2');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company2', 'Peluqueria Cristian', 'company2@ua', '123', '674514587', 'Alicante', '09:00', '20:00', 'false', '2');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company3', 'Essence', 'company3@ua', '123', '625472155', 'Aspe, España', '09:00', '20:00', 'false', '2');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company4', 'Peluqueria Pedro y Ana', 'company4@ua', '123', '123456789', 'San Juan de Alicante, España', '09:00', '20:00', 'false', '2');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company5', 'La class', 'company5@ua', '123', '123456789', 'Alicante, España', '09:00', '20:00', 'false', '2');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company6', 'Peluquería Elda', 'company6@ua', '123', '123456789', 'Elda, Alicante, España', '09:00', '20:00', 'false', '2');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company7', 'Antoris', 'company7@ua', '123', '123456789', 'Monforte del Cid, España', '09:00', '20:00', 'false', '2');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company8', 'Al pelo', 'company8@ua', '123', '123456789', 'Alicante, España', '09:00', '20:00', 'false', '2');

-- Insertamos clinicas --
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company9', 'Clinica Rosario', 'company9@ua', '123', '663647143', 'Elche, España', '09:00', '20:00', 'false', '3');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company10', 'Clinica Dental El Puente', 'company10@ua', '123', '625438144', 'Aspe, Alicante, España', '09:00', '20:00', 'false', '3');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company11', 'Virgen de las Nieves', 'company11@ua', '123', '123456789', 'San Juan de Alicante, España', '09:00', '20:00', 'false', '3');

-- Insertamos tatuajes --
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company12', 'El gato negro', 'company12@ua', '123', '123456789', 'San Juan de Alicante, España', '09:00', '20:00', 'false', '4');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company13', 'Tatoos', 'company13@ua', '123', '123456789', 'Avenida Constitución, 10, Aspe, España', '09:00', '20:00', 'false', '4');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company14', 'La buena tinta', 'company14@ua', '123', '123456789', 'Aspe, Alicante, España', '09:00', '20:00', 'false', '4');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company15', 'Printed', 'company15@ua', '123', '123456789', 'San Vicente del Raspeig, España', '09:00', '20:00', 'false', '4');

-- Insertamos psicología --
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company16', 'Centro como tú', 'company16@ua', '123', '123456789', 'Monforte del Cid, España', '09:00', '20:00', 'false', '5');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company17', 'Consulta Mario', 'company17@ua', '123', '123456789', 'Aspe, Alicante, España', '09:00', '20:00', 'false', '5');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company18', 'Isabel Soriano', 'company18@ua', '123', '123456789', 'Novelda, Alicante, España', '09:00', '20:00', 'false', '5');
INSERT INTO companies (username, name, mail, password, phone, address, startday, finishday, premium, category_id)
VALUES('company19', 'Psicología y salud', 'company19@ua', '123', '123456789', 'Alicante, España', '09:00', '20:00', 'false', '5');

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

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Degradado', '30', '6', 'true', '2');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Corte de pelo', '30', '12', 'true', '2');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Tinte', '60', '18', 'true', '2');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Degradado', '30', '5', 'true', '3');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Corte de pelo', '30', '10', 'true', '3');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Tinte', '60', '16', 'true', '3');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Peinado', '30', '10', 'true', '3');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Corte de pelo', '30', '15', 'true', '4');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Tinte', '60', '30', 'true', '4');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Corte de pelo y barba', '30', '18', 'true', '4');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Decoloracion', '60', '18', 'true', '4');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Peinado', '30', '9', 'true', '4');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Corte de pelo', '30', '12', 'true', '5');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Tinte', '60', '18', 'true', '5');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Corte de pelo y barba', '30', '16', 'true', '5');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Corte de pelo', '30', '12', 'true', '6');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Degradado', '30', '7', 'true', '6');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Corte de pelo', '30', '8', 'true', '7');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Corte de pelo', '60', '11', 'true', '8');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Corte de pelo y barba', '60', '15', 'true', '8');

-- Insertamos labours clínicas --
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Limpieza', '60', '25', 'true', '9');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Arreglo caries', '60', '50', 'true', '9');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Limpieza', '60', '25', 'true', '10');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Arreglo caries', '60', '45', 'true', '10');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Limpieza', '60', '25', 'true', '11');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Arreglo caries', '60', '50', 'true', '11');

-- Insertamos labours tatuajes --
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Zona media', '30', '30', 'true', '12');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Zona grande', '60', '70', 'true', '12');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Zona media', '30', '30', 'true', '13');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Zona grande', '60', '70', 'true', '13');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Zona media', '30', '30', 'true', '14');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Zona grande', '60', '70', 'true', '14');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Zona media', '30', '30', 'true', '15');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Zona grande', '60', '70', 'true', '15');

-- Insertamos labours psicologías --
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Consulta rutinaria', '60', '40', 'true', '16');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Consulta introducción', '60', '60', 'true', '16');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Consulta rutinaria', '60', '40', 'true', '17');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Consulta introducción', '60', '60', 'true', '17');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Consulta rutinaria', '60', '40', 'true', '18');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Consulta introducción', '60', '60', 'true', '18');

INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Consulta rutinaria', '60', '40', 'true', '19');
INSERT INTO labours (name, duration, price, activated, company_id)
VALUES('Consulta introducción', '60', '60', 'true', '19');

-- Insertamos customers --
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer1', 'Cliente1', 'cliente@ua', '123', '671542529', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer2', 'Cliente2', 'cliente@ua', '123', '123456789', 'male', '1990-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer3', 'Cliente3', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer4', 'Cliente4', 'cliente@ua', '123', '123456789', 'female', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer5', 'Cliente5', 'cliente@ua', '123', '123456789', 'male', '1970-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer6', 'Cliente6', 'cliente@ua', '123', '123456789', 'male', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer7', 'Cliente7', 'cliente@ua', '123', '123456789', 'male', '1950-05-12');
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
VALUES('customer24', 'Cliente24', 'cliente@ua', '123', '123456789', 'female', '2002-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer25', 'Cliente25', 'cliente@ua', '123', '123456789', 'male', '2012-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer26', 'Cliente26', 'cliente@ua', '123', '123456789', 'male', '1975-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer27', 'Cliente27', 'cliente@ua', '123', '123456789', 'female', '1986-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer28', 'Cliente28', 'cliente@ua', '123', '123456789', 'male', '1992-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer29', 'Cliente29', 'cliente@ua', '123', '123456789', 'female', '1962-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer30', 'Cliente30', 'cliente@ua', '123', '123456789', 'female', '1999-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer31', 'Cliente31', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer32', 'Cliente32', 'cliente@ua', '123', '123456789', 'male', '1982-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer33', 'Cliente33', 'cliente@ua', '123', '123456789', 'male', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer34', 'Cliente34', 'cliente@ua', '123', '123456789', 'female', '1996-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer35', 'Cliente35', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer36', 'Cliente36', 'cliente@ua', '123', '123456789', 'female', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer37', 'Cliente37', 'cliente@ua', '123', '123456789', 'male', '1978-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer38', 'Cliente38', 'cliente@ua', '123', '123456789', 'male', '1963-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer39', 'Cliente39', 'cliente@ua', '123', '123456789', 'female', '1974-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer40', 'Cliente40', 'cliente@ua', '123', '123456789', 'male', '1995-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer41', 'Cliente41', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer42', 'Cliente42', 'cliente@ua', '123', '123456789', 'female', '1982-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer43', 'Cliente43', 'cliente@ua', '123', '123456789', 'male', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer44', 'Cliente44', 'cliente@ua', '123', '123456789', 'female', '1996-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer45', 'Cliente45', 'cliente@ua', '123', '123456789', 'female', '1992-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer46', 'Cliente46', 'cliente@ua', '123', '123456789', 'female', '1960-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer47', 'Cliente47', 'cliente@ua', '123', '123456789', 'male', '1998-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer48', 'Cliente48', 'cliente@ua', '123', '123456789', 'male', '1973-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer49', 'Cliente49', 'cliente@ua', '123', '123456789', 'female', '2006-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer50', 'Cliente50', 'cliente@ua', '123', '123456789', 'male', '1995-05-12');

INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer51', 'Cliente51', 'cliente@ua', '123', '671542529', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer52', 'Cliente52', 'cliente@ua', '123', '123456789', 'female', '1990-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer53', 'Cliente53', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer54', 'Cliente54', 'cliente@ua', '123', '123456789', 'female', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer55', 'Cliente55', 'cliente@ua', '123', '123456789', 'female', '1970-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer56', 'Cliente56', 'cliente@ua', '123', '123456789', 'female', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer57', 'Cliente57', 'cliente@ua', '123', '123456789', 'female', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer58', 'Cliente58', 'cliente@ua', '123', '123456789', 'female', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer59', 'Cliente59', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer60', 'Cliente60', 'cliente@ua', '123', '123456789', 'male', '1990-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer61', 'Cliente61', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer62', 'Cliente62', 'cliente@ua', '123', '123456789', 'male', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer63', 'Cliente63', 'cliente@ua', '123', '123456789', 'male', '1970-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer64', 'Cliente64', 'cliente@ua', '123', '123456789', 'male', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer65', 'Cliente65', 'cliente@ua', '123', '123456789', 'male', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer66', 'Cliente66', 'cliente@ua', '123', '123456789', 'male', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer67', 'Cliente67', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer68', 'Cliente68', 'cliente@ua', '123', '123456789', 'male', '1990-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer69', 'Cliente69', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer70', 'Cliente70', 'cliente@ua', '123', '123456789', 'female', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer71', 'Cliente71', 'cliente@ua', '123', '123456789', 'female', '1970-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer72', 'Cliente72', 'cliente@ua', '123', '123456789', 'female', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer73', 'Cliente73', 'cliente@ua', '123', '123456789', 'female', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer74', 'Cliente74', 'cliente@ua', '123', '123456789', 'female', '2002-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer75', 'Cliente75', 'cliente@ua', '123', '123456789', 'male', '2012-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer76', 'Cliente76', 'cliente@ua', '123', '123456789', 'male', '1975-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer77', 'Cliente77', 'cliente@ua', '123', '123456789', 'female', '1986-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer78', 'Cliente78', 'cliente@ua', '123', '123456789', 'male', '1992-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer79', 'Cliente79', 'cliente@ua', '123', '123456789', 'female', '1962-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer80', 'Cliente80', 'cliente@ua', '123', '123456789', 'female', '1999-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer81', 'Cliente81', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer82', 'Cliente82', 'cliente@ua', '123', '123456789', 'male', '1982-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer83', 'Cliente83', 'cliente@ua', '123', '123456789', 'male', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer84', 'Cliente84', 'cliente@ua', '123', '123456789', 'female', '1996-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer85', 'Cliente85', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer86', 'Cliente86', 'cliente@ua', '123', '123456789', 'female', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer87', 'Cliente87', 'cliente@ua', '123', '123456789', 'male', '1978-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer88', 'Cliente88', 'cliente@ua', '123', '123456789', 'male', '1963-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer89', 'Cliente89', 'cliente@ua', '123', '123456789', 'female', '1974-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer90', 'Cliente90', 'cliente@ua', '123', '123456789', 'male', '1995-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer91', 'Cliente91', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer92', 'Cliente92', 'cliente@ua', '123', '123456789', 'female', '1982-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer93', 'Cliente93', 'cliente@ua', '123', '123456789', 'male', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer94', 'Cliente94', 'cliente@ua', '123', '123456789', 'female', '1996-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer95', 'Cliente95', 'cliente@ua', '123', '123456789', 'female', '1992-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer96', 'Cliente96', 'cliente@ua', '123', '123456789', 'female', '1960-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer97', 'Cliente97', 'cliente@ua', '123', '123456789', 'male', '1998-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer98', 'Cliente98', 'cliente@ua', '123', '123456789', 'male', '1973-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer99', 'Cliente99', 'cliente@ua', '123', '123456789', 'female', '2006-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer100', 'Cliente100', 'cliente@ua', '123', '123456789', 'male', '1995-05-12');

INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer101', 'Cliente101', 'cliente@ua', '123', '671542529', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer102', 'Cliente102', 'cliente@ua', '123', '123456789', 'female', '1990-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer103', 'Cliente103', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer104', 'Cliente104', 'cliente@ua', '123', '123456789', 'female', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer105', 'Cliente105', 'cliente@ua', '123', '123456789', 'female', '1970-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer106', 'Cliente106', 'cliente@ua', '123', '123456789', 'female', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer107', 'Cliente107', 'cliente@ua', '123', '123456789', 'female', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer108', 'Cliente108', 'cliente@ua', '123', '123456789', 'female', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer109', 'Cliente109', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer110', 'Cliente110', 'cliente@ua', '123', '123456789', 'male', '1990-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer111', 'Cliente111', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer112', 'Cliente112', 'cliente@ua', '123', '123456789', 'male', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer113', 'Cliente113', 'cliente@ua', '123', '123456789', 'male', '1970-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer114', 'Cliente114', 'cliente@ua', '123', '123456789', 'male', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer115', 'Cliente115', 'cliente@ua', '123', '123456789', 'male', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer116', 'Cliente116', 'cliente@ua', '123', '123456789', 'male', '2022-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer117', 'Cliente117', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer118', 'Cliente118', 'cliente@ua', '123', '123456789', 'male', '1990-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer119', 'Cliente119', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer120', 'Cliente120', 'cliente@ua', '123', '123456789', 'female', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer121', 'Cliente121', 'cliente@ua', '123', '123456789', 'female', '1970-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer122', 'Cliente122', 'cliente@ua', '123', '123456789', 'female', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer123', 'Cliente123', 'cliente@ua', '123', '123456789', 'female', '1950-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer124', 'Cliente124', 'cliente@ua', '123', '123456789', 'female', '2002-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer125', 'Cliente125', 'cliente@ua', '123', '123456789', 'male', '2012-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer126', 'Cliente126', 'cliente@ua', '123', '123456789', 'male', '1975-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer127', 'Cliente127', 'cliente@ua', '123', '123456789', 'female', '1986-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer128', 'Cliente128', 'cliente@ua', '123', '123456789', 'male', '1992-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer129', 'Cliente129', 'cliente@ua', '123', '123456789', 'female', '1962-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer130', 'Cliente130', 'cliente@ua', '123', '123456789', 'female', '1999-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer131', 'Cliente131', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer132', 'Cliente132', 'cliente@ua', '123', '123456789', 'male', '1982-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer133', 'Cliente133', 'cliente@ua', '123', '123456789', 'male', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer134', 'Cliente134', 'cliente@ua', '123', '123456789', 'female', '1996-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer135', 'Cliente135', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer136', 'Cliente136', 'cliente@ua', '123', '123456789', 'female', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer137', 'Cliente137', 'cliente@ua', '123', '123456789', 'male', '1978-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer138', 'Cliente138', 'cliente@ua', '123', '123456789', 'male', '1963-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer139', 'Cliente139', 'cliente@ua', '123', '123456789', 'female', '1974-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer140', 'Cliente140', 'cliente@ua', '123', '123456789', 'male', '1995-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer141', 'Cliente141', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer142', 'Cliente142', 'cliente@ua', '123', '123456789', 'female', '1982-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer143', 'Cliente143', 'cliente@ua', '123', '123456789', 'male', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer144', 'Cliente144', 'cliente@ua', '123', '123456789', 'female', '1996-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer145', 'Cliente145', 'cliente@ua', '123', '123456789', 'female', '1992-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer146', 'Cliente146', 'cliente@ua', '123', '123456789', 'female', '1960-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer147', 'Cliente147', 'cliente@ua', '123', '123456789', 'male', '1998-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer148', 'Cliente148', 'cliente@ua', '123', '123456789', 'male', '1973-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer149', 'Cliente149', 'cliente@ua', '123', '123456789', 'female', '2006-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer150', 'Cliente150', 'cliente@ua', '123', '123456789', 'male', '1995-05-12');

VALUES('customer151', 'Cliente151', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer152', 'Cliente152', 'cliente@ua', '123', '123456789', 'male', '1982-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer153', 'Cliente153', 'cliente@ua', '123', '123456789', 'male', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer154', 'Cliente154', 'cliente@ua', '123', '123456789', 'female', '1996-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer155', 'Cliente155', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer156', 'Cliente156', 'cliente@ua', '123', '123456789', 'female', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer157', 'Cliente157', 'cliente@ua', '123', '123456789', 'male', '1978-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer158', 'Cliente158', 'cliente@ua', '123', '123456789', 'male', '1963-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer159', 'Cliente159', 'cliente@ua', '123', '123456789', 'female', '1974-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer160', 'Cliente160', 'cliente@ua', '123', '123456789', 'female', '1999-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer161', 'Cliente161', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer162', 'Cliente162', 'cliente@ua', '123', '123456789', 'male', '1982-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer163', 'Cliente163', 'cliente@ua', '123', '123456789', 'male', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer164', 'Cliente164', 'cliente@ua', '123', '123456789', 'female', '1996-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer165', 'Cliente165', 'cliente@ua', '123', '123456789', 'male', '2000-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer166', 'Cliente166', 'cliente@ua', '123', '123456789', 'female', '1980-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer167', 'Cliente167', 'cliente@ua', '123', '123456789', 'male', '1978-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer168', 'Cliente168', 'cliente@ua', '123', '123456789', 'male', '1963-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer169', 'Cliente169', 'cliente@ua', '123', '123456789', 'female', '1974-05-12');
INSERT INTO customers (username, name, mail, password, phone, gender, birthday)
VALUES('customer170', 'Cliente170', 'cliente@ua', '123', '123456789', 'male', '1995-05-12');


/* INSERTAMOS REVIEWS EN EMPRESA CON ID 1 Rapiño */
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio', '4', '1', '1');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Excelente, repetiré seguro', '5', '1', '2');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Nada del otro mundo, muy normal', '3', '1', '3');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Todo genial, que majo es Rapiño', '4', '1', '4');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantadoooo', '5', '1', '5');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio', '5', '1', '6');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me gustó mucho, recomendado', '4', '1', '7');

/* INSERTAMOS REVIEWS EN EMPRESA CON ID 4 Pedro y Ana */
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio, ¡lo recomiendo!', '5', '4', '1');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Mi tío es el mejor peluquero', '5', '4', '10');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Desde que tengo 5 años voy a esta peluquería', '4', '4', '12');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Son maravillosos', '4', '4', '8');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Nada como ellos', '4', '4', '6');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Viva Pedro y Ana', '5', '4', '5');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio Me ha encantado el servicio', '5', '4', '4');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio', '5', '4', '3');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio', '5', '4', '20');

/* INSERTAMOS REVIEWS EN EMPRESA CON ID 5 La class */
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Pésimo servicio, deja mucho que desear', '3', '5', '10');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Qué antipáticos son', '3', '5', '11');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio', '5', '5', '12');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Oleee', '4', '5', '15');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio Me ha encantado el servicio Me ha encantado el servicio', '3', '5', '20');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio Me ha encantado el servicio Me ha encantado el servicio', '4', '5', '21');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio Me ha encantado el servicio Me ha encantado el servicio', '5', '5', '22');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio Me ha encantado el servicio Me ha encantado el servicio', '5', '5', '30');
INSERT INTO reviews (text, valuation, company_id, customer_id)
VALUES('Me ha encantado el servicio Me ha encantado el servicio Me ha encantado el servicio', '4', '5', '35');

/* INSERTAMOS RESERVAS EN EMPRESA CON ID 1 Rapiño */
/*
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-13', '09:00', '09:30', '1', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-13', '09:30', '10:30', '1', '2', '1', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-13', '10:30', '11:00', '1', '1', '1', '3');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-13', '11:00', '11:30', '1', '5', '1', '4');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-13', '11:30', '12:30', '1', '4', '1', '5');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-13', '12:30', '13:00', '1', '3', '1', '6');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-14', '09:00', '09:30', '1', '1', '1', '7');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-14', '09:30', '10:30', '1', '2', '1', '8');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-14', '10:30', '11:00', '1', '1', '1', '9');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-14', '11:00', '11:30', '1', '5', '1', '10');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-14', '11:30', '12:30', '1', '4', '1', '11');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-14', '12:30', '13:00', '1', '3', '1', '12');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-15', '09:00', '09:30', '1', '1', '1', '13');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-15', '09:30', '10:30', '1', '2', '1', '14');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-15', '10:30', '11:00', '1', '1', '1', '15');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-15', '11:00', '11:30', '1', '5', '1', '16');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-15', '11:30', '12:30', '1', '4', '1', '17');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-15', '12:30', '13:00', '1', '3', '1', '18');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-16', '09:00', '09:30', '1', '1', '1', '19');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-16', '09:30', '10:30', '1', '2', '1', '20');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-16', '10:30', '11:00', '1', '1', '1', '21');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-16', '11:00', '11:30', '1', '5', '1', '22');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-16', '11:30', '12:30', '1', '4', '1', '23');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-16', '12:30', '13:00', '1', '3', '1', '24');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-17', '09:00', '09:30', '1', '1', '1', '25');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-17', '09:30', '10:30', '1', '2', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-17', '10:30', '11:00', '1', '1', '1', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-17', '11:00', '11:30', '1', '5', '1', '3');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-17', '11:30', '12:30', '1', '4', '1', '4');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-17', '12:30', '13:00', '1', '3', '1', '5');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-20', '09:00', '09:30', '1', '1', '1', '6');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-20', '09:30', '10:30', '1', '2', '1', '7');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-20', '10:30', '11:00', '1', '1', '1', '8');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-20', '11:00', '11:30', '1', '5', '1', '9');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-20', '11:30', '12:30', '1', '4', '1', '10');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-20', '12:30', '13:00', '1', '3', '1', '11');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-21', '09:00', '09:30', '1', '1', '1', '12');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-21', '09:30', '10:30', '1', '2', '1', '13');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-21', '10:30', '11:00', '1', '1', '1', '14');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-21', '11:00', '11:30', '1', '5', '1', '15');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-21', '11:30', '12:30', '1', '4', '1', '16');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-21', '12:30', '13:00', '1', '3', '1', '17');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-22', '09:00', '09:30', '1', '1', '1', '18');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-22', '09:30', '10:30', '1', '2', '1', '19');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-22', '10:30', '11:00', '1', '1', '1', '20');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-22', '11:00', '11:30', '1', '5', '1', '21');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-22', '11:30', '12:30', '1', '4', '1', '22');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-22', '12:30', '13:00', '1', '3', '1', '23');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-23', '09:00', '09:30', '1', '1', '1', '24');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-23', '09:30', '10:30', '1', '2', '1', '25');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-23', '10:30', '11:00', '1', '1', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-23', '11:00', '11:30', '1', '5', '1', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-23', '11:30', '12:30', '1', '4', '1', '3');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-23', '12:30', '13:00', '1', '3', '1', '4');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-24', '09:00', '09:30', '1', '1', '1', '5');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-24', '09:30', '10:30', '1', '2', '1', '6');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-24', '10:30', '11:00', '1', '1', '1', '7');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-24', '11:00', '11:30', '1', '5', '1', '8');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-24', '11:30', '12:30', '1', '4', '1', '9');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-24', '12:30', '13:00', '1', '3', '1', '10');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-27', '09:00', '09:30', '1', '1', '1', '11');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-27', '09:30', '10:30', '1', '2', '1', '12');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-27', '10:30', '11:00', '1', '1', '1', '13');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-27', '11:00', '11:30', '1', '5', '1', '14');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-27', '11:30', '12:30', '1', '4', '1', '15');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-27', '12:30', '13:00', '1', '3', '1', '16');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-28', '09:00', '09:30', '1', '1', '1', '17');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-28', '09:30', '10:30', '1', '2', '1', '18');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-28', '10:30', '11:00', '1', '1', '1', '19');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-28', '11:00', '11:30', '1', '5', '1', '20');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-28', '11:30', '12:30', '1', '4', '1', '21');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-28', '12:30', '13:00', '1', '3', '1', '22');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-29', '09:00', '09:30', '1', '1', '1', '23');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-29', '09:30', '10:30', '1', '2', '1', '24');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-29', '10:30', '11:00', '1', '1', '1', '25');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-29', '11:00', '11:30', '1', '5', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-29', '11:30', '12:30', '1', '4', '1', '2');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-29', '12:30', '13:00', '1', '3', '1', '3');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-30', '09:00', '09:30', '1', '1', '1', '4');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-30', '09:30', '10:30', '1', '2', '1', '5');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-30', '10:30', '11:00', '1', '1', '1', '6');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-30', '11:00', '11:30', '1', '5', '1', '7');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-30', '11:30', '12:30', '1', '4', '1', '8');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-30', '12:30', '13:00', '1', '3', '1', '9');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-31', '09:00', '09:30', '1', '1', '1', '10');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-31', '09:30', '10:30', '1', '2', '1', '11');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-31', '10:30', '11:00', '1', '1', '1', '12');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-31', '11:00', '11:30', '1', '5', '1', '13');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-31', '11:30', '12:30', '1', '4', '1', '14');
INSERT INTO appointments (date, starthour, endhour, company_id, labour_id, appointment_type, customer_id)
VALUES('2021-12-31', '12:30', '13:00', '1', '3', '1', '15');
 */


INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-03', '09:00', '10:00', '1', '9', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-03', '10:00', '10:30', '1', '3', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-03', '11:00', '12:00', '1', '3', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-04', '10:00', '10:30', '1', '3', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-04', '11:00', '12:00', '1', '3', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-05', '09:00', '10:00', '1', '9', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-05', '11:00', '12:00', '1', '3', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-06', '09:00', '10:00', '1', '9', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-06', '10:00', '10:30', '1', '3', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-10', '10:30', '11:00', '1', '3', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-10', '11:00', '12:00', '1', '3', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-11', '09:00', '10:00', '1', '9', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-12', '10:00', '10:30', '1', '3', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-17', '09:00', '10:00', '1', '9', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-17', '10:00', '10:30', '1', '3', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-18', '09:00', '10:00', '1', '4', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-18', '11:00', '12:00', '1', '8', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-19', '09:00', '10:00', '1', '10', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-20', '09:00', '10:00', '1', '21', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-21', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-21', '11:00', '12:00', '1', '8', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-24', '11:00', '12:00', '1', '23', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-26', '11:00', '12:00', '1', '6', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-27', '09:00', '10:00', '1', '5', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-01-28', '10:00', '10:30', '1', '13', '3', '1');


INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-01', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-01', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-01', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-02', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-02', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-02', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-02', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-03', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-03', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-04', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-04', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-04', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-04', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-04', '12:00', '12:30', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-07', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-07', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-07', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-08', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-08', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-09', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-09', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-09', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-09', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-10', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-10', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-10', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-10', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-14', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-14', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-14', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-15', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-15', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-15', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-15', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-16', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-16', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-17', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-17', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-17', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-17', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-18', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-18', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-18', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-21', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-21', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-21', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-22', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-22', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-22', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-23', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-23', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-24', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-25', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-25', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-25', '11:30', '12:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-28', '09:00', '10:00', '1', '2', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-28', '10:00', '11:00', '1', '4', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-28', '11:00', '11:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-02-28', '11:30', '12:00', '1', '8', '3', '1');


INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-03', '10:00', '10:30', '1', '20', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-03', '12:00', '12:30', '1', '25', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-04', '12:00', '12:30', '1', '2', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-07', '10:00', '10:30', '1', '2', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-07', '12:00', '12:30', '1', '3', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-07', '12:30', '13:30', '1', '3', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-09', '10:00', '10:30', '1', '2', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-09', '12:00', '12:30', '1', '17', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-11', '10:00', '10:30', '1', '19', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-11', '12:00', '12:30', '1', '18', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-14', '10:00', '10:30', '1', '22', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-15', '10:00', '10:30', '1', '2', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-15', '12:00', '12:30', '1', '3', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-15', '12:30', '13:30', '1', '3', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-16', '10:00', '10:30', '1', '15', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-16', '12:00', '12:30', '1', '14', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-21', '10:00', '10:30', '1', '20', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-21', '12:00', '12:30', '1', '25', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-23', '10:00', '11:00', '1', '24', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-23', '12:00', '12:30', '1', '22', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-25', '10:00', '10:30', '1', '8', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-28', '10:00', '10:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-29', '10:00', '10:30', '1', '5', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-29', '12:00', '13:00', '1', '7', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-03-30', '10:00', '11:00', '1', '21', '2', '1');


INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-04', '11:00', '12:00', '1', '18', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-04', '14:00', '15:00', '1', '2', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-05', '14:00', '15:00', '1', '10', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-12', '11:00', '12:00', '1', '22', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-12', '14:00', '15:00', '1', '23', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-13', '11:00', '12:00', '1', '18', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-15', '11:00', '12:00', '1', '24', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-15', '14:00', '15:00', '1', '20', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-19', '11:00', '12:00', '1', '18', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-19', '14:00', '15:00', '1', '25', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-20', '14:00', '15:00', '1', '20', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-21', '11:00', '12:00', '1', '18', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-21', '14:00', '15:00', '1', '20', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-25', '11:00', '12:00', '1', '18', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-25', '14:00', '15:00', '1', '20', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-04-29', '11:00', '12:00', '1', '18', '2', '1');


INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-02', '09:00', '10:00', '1', '17', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-02', '10:00', '10:30', '1', '17', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-02', '10:30', '11:00', '1', '3', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-03', '09:00', '10:00', '1', '4', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-03', '10:00', '10:30', '1', '5', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-03', '10:30', '11:00', '1', '6', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-04', '09:00', '10:00', '1', '12', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-06', '09:00', '10:00', '1', '20', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-06', '10:00', '10:30', '1', '21', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-06', '10:30', '11:00', '1', '17', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-06', '14:00', '15:00', '1', '1', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-09', '09:00', '10:00', '1', '12', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-09', '10:00', '10:30', '1', '9', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-09', '10:30', '11:00', '1', '8', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-10', '09:00', '10:00', '1', '7', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-10', '10:00', '10:30', '1', '18', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-10', '10:30', '11:00', '1', '14', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-13', '09:00', '10:00', '1', '11', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-13', '10:00', '10:30', '1', '17', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-13', '10:30', '11:00', '1', '17', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-13', '11:30', '12:00', '1', '24', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-17', '12:00', '12:30', '1', '11', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-18', '16:00', '17:00', '1', '23', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-18', '17:00', '17:30', '1', '10', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-20', '09:30', '10:00', '1', '13', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-20', '10:00', '10:30', '1', '10', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-20', '11:30', '12:00', '1', '9', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-25', '10:00', '10:30', '1', '15', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-25', '11:00', '11:30', '1', '7', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '09:00', '09:30', '1', '23', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '09:30', '10:00', '1', '7', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '10:00', '10:30', '1', '2', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '10:30', '11:00', '1', '21', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '11:00', '11:30', '1', '20', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '11:30', '12:00', '1', '21', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '12:00', '13:00', '1', '14', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '13:00', '14:00', '1', '9', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-05-27', '15:30', '16:00', '1', '8', '5', '1');


INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-03', '09:00', '09:30', '1', '3', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-03', '09:30', '10:00', '1', '7', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-03', '11:00', '11:30', '1', '17', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-03', '12:30', '13:00', '1', '16', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-06', '10:00', '11:00', '1', '15', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-07', '09:00', '10:00', '1', '14', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-07', '10:00', '10:30', '1', '11', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-10', '09:00', '10:00', '1', '18', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-10', '10:00', '10:30', '1', '22', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-10', '17:00', '18:00', '1', '9', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-13', '09:00', '10:00', '1', '7', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-15', '10:00', '10:30', '1', '23', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-17', '09:00', '10:00', '1', '8', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-17', '10:00', '10:30', '1', '16', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-17', '10:30', '11:00', '1', '5', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-21', '11:00', '11:30', '1', '17', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-21', '12:00', '13:00', '1', '24', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-23', '13:00', '14:00', '1', '21', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-24', '14:00', '15:00', '1', '9', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-24', '15:00', '15:30', '1', '12', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-24', '16:30', '17:00', '1', '6', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-28', '17:00', '18:00', '1', '14', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-29', '17:00', '18:00', '1', '16', '4', '1');


INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-01', '09:30', '10:00', '1', '12', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-01', '10:00', '10:30', '1', '19', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-01', '10:30', '11:00', '1', '9', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-01', '11:00', '12:00', '1', '31', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '09:30', '10:00', '1', '12', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '10:00', '10:30', '1', '35', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '10:30', '11:30', '1', '1', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-05', '11:30', '12:30', '1', '15', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-05', '12:30', '13:00', '1', '20', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-05', '16:00', '16:30', '1', '3', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-05', '16:30', '17:00', '1', '30', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-06', '10:00', '10:30', '1', '6', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-06', '11:30', '12:30', '1', '15', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-08', '09:00', '10:00', '1', '20', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-08', '10:00', '11:00', '1', '24', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-08', '11:00', '12:00', '1', '19', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-13', '16:00', '16:30', '1', '21', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-13', '18:00', '19:00', '1', '5', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-15', '13:00', '13:30', '1', '10', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-15', '13:30', '14:00', '1', '78', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-15', '16:00', '16:30', '1', '4', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-15', '16:30', '17:00', '1', '4', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-15', '18:00', '19:00', '1', '5', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-18', '10:00', '11:00', '1', '18', '2', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-19', '09:00', '09:30', '1', '4', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '11:00', '11:30', '1', '7', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '11:30', '12:00', '1', '5', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-21', '13:30', '14:00', '1', '17', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-22', '16:00', '16:30', '1', '4', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-22', '18:30', '19:00', '1', '12', '1', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-22', '19:00', '19:30', '1', '2', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-22', '19:30', '20:00', '1', '3', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '09:00', '09:30', '1', '4', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '09:30', '10:00', '1', '30', '3', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '10:00', '11:00', '1', '29', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-26', '11:00', '12:00', '1', '28', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-26', '12:00', '13:00', '1', '27', '4', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-27', '13:00', '13:30', '1', '26', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-28', '13:30', '14:00', '1', '25', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-29', '15:30', '16:00', '1', '31', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-29', '16:00', '16:30', '1', '32', '5', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-29', '17:00', '17:30', '1', '19', '5', '1');

-- INSERTAMOS RESERVAS EN EMPRESA CON ID 2 Cristian --
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-03', '11:00', '11:15', '2', '7', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-03', '11:30', '11:45', '2', '2', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-06', '11:45', '12:15', '2', '15', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-10', '10:00', '10:15', '2', '9', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-17', '09:00', '09:30', '2', '8', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '10:00', '10:15', '2', '16', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '10:30', '10:45', '2', '5', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '11:00', '11:15', '2', '17', '7', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '12:00', '12:15', '2', '24', '8', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '13:00', '13:15', '2', '31', '7', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '14:00', '14:30', '2', '29', '8', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '15:00', '15:30', '2', '12', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '16:30', '17:00', '2', '6', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '17:00', '17:30', '2', '1', '6', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-01', '09:30', '10:00', '2', '12', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-01', '10:30', '10:45', '2', '19', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-01', '10:45', '11:15', '2', '9', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-01', '11:30', '12:00', '2', '31', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '09:30', '09:45', '2', '12', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '10:00', '10:30', '2', '35', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '10:45', '11:00', '2', '15', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '12:30', '13:00', '2', '20', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '16:00', '16:30', '2', '3', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '16:30', '17:00', '2', '30', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-05', '10:00', '10:30', '2', '6', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-06', '11:30', '12:00', '2', '15', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-08', '09:00', '09:15', '2', '20', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-08', '10:00', '10:30', '2', '24', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-11', '11:00', '11:15', '2', '19', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-13', '16:00', '16:15', '2', '21', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-13', '18:00', '18:30', '2', '5', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-15', '13:00', '13:30', '2', '10', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-18', '10:00', '10:30', '2', '18', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-19', '09:00', '09:30', '2', '4', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '11:00', '11:15', '2', '7', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '11:30', '12:00', '2', '5', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '13:30', '13:45', '2', '17', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '16:00', '16:30', '2', '4', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '18:30', '19:00', '2', '12', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '19:00', '19:30', '2', '2', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '19:30', '20:00', '2', '3', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '09:00', '09:30', '2', '4', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '09:30', '10:00', '2', '30', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '10:30', '11:00', '2', '29', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '11:00', '11:30', '2', '28', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '12:00', '12:30', '2', '27', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '13:00', '13:15', '2', '26', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '13:30', '14:00', '2', '25', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '15:30', '16:00', '2', '31', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '16:00', '16:15', '2', '32', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '17:00', '17:30', '2', '19', '6', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-29', '10:30', '10:45', '2', '1', '6', '1');


-- INSERTAMOS RESERVAS EN EMPRESA CON ID 3 essence --
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-03', '11:00', '11:30', '3', '40', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-03', '12:30', '13:00', '3', '41', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-06', '10:00', '11:00', '3', '42', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-10', '17:00', '18:00', '3', '43', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-17', '09:00', '10:00', '3', '44', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '10:00', '10:30', '3', '45', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '10:30', '11:00', '3', '46', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '11:00', '11:30', '3', '47', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '12:00', '13:00', '3', '48', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '13:00', '14:00', '3', '49', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '14:00', '15:00', '3', '50', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '15:00', '15:30', '3', '51', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '16:30', '17:00', '3', '52', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-06-20', '17:00', '18:00', '3', '53', '9', '1');

INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-01', '09:30', '10:00', '3', '54', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-01', '10:00', '10:30', '3', '55', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-01', '10:30', '11:00', '3', '56', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-01', '11:00', '12:00', '3', '57', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '09:30', '10:00', '3', '58', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '10:00', '10:30', '3', '59', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '11:30', '12:30', '3', '60', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '12:30', '13:00', '3', '61', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '16:00', '16:30', '3', '62', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-04', '16:30', '17:00', '3', '63', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-05', '10:00', '10:30', '3', '64', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-06', '11:30', '12:30', '3', '65', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-08', '09:00', '10:00', '3', '66', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-08', '10:00', '11:00', '3', '67', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-11', '11:00', '12:00', '3', '68', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-13', '16:00', '16:30', '3', '69', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-13', '18:00', '19:00', '3', '70', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-15', '13:00', '13:30', '3', '71', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-18', '10:00', '11:00', '3', '72', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-19', '09:00', '09:30', '3', '73', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '11:00', '11:30', '3', '74', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '11:30', '12:00', '3', '75', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '13:30', '14:00', '3', '76', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '16:00', '16:30', '3', '77', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '18:30', '19:00', '3', '78', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '19:00', '19:30', '3', '79', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-20', '19:30', '20:00', '3', '80', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '09:00', '09:30', '3', '81', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '09:30', '10:00', '3', '82', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '10:00', '11:00', '3', '83', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '11:00', '12:00', '3', '84', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '12:00', '13:00', '3', '85', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '13:00', '13:30', '3', '86', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '13:30', '14:00', '3', '87', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '15:30', '16:00', '3', '88', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '16:00', '16:30', '3', '89', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-25', '17:00', '17:30', '3', '90', '9', '1');
INSERT INTO appointments (date, starthour, endhour, company_id, customer_id, labour_id, appointment_type)
VALUES('2022-07-29', '10:30', '11:30', '3', '91', '9', '1');