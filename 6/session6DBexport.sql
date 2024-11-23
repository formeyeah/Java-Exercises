-- H2 2.3.232;
;             
CREATE USER IF NOT EXISTS "SA" SALT '629c7b84a04a6287' HASH '6b90b1cffed129c2a7fd9f32ba55f5dac97fcfd116ae770cf1e198393a3d214c' ADMIN;         
CREATE CACHED TABLE "PUBLIC"."REGIONS"(
    "REGION_ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "REGION_NAME" CHARACTER VARYING(25) DEFAULT NULL
);           
ALTER TABLE "PUBLIC"."REGIONS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_6" PRIMARY KEY("REGION_ID");               
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.REGIONS; 
INSERT INTO "PUBLIC"."REGIONS" VALUES
(1, 'Europe'),
(2, 'Americas'),
(3, 'Asia'),
(4, 'Middle East and Africa');         
CREATE CACHED TABLE "PUBLIC"."COUNTRIES"(
    "COUNTRY_NAME" CHARACTER VARYING(40) DEFAULT NULL,
    "COUNTRY_ID" CHARACTER(2) NOT NULL,
    "REGION_ID" INTEGER NOT NULL
);              
ALTER TABLE "PUBLIC"."COUNTRIES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F" PRIMARY KEY("COUNTRY_ID");            
-- 26 +/- SELECT COUNT(*) FROM PUBLIC.COUNTRIES;              
INSERT INTO "PUBLIC"."COUNTRIES" VALUES
('Argentina', 'AR', 2),
('Australia', 'AU', 3),
('Belgium', 'BE', 1),
('Brazil', 'BR', 2),
('Canada', 'CA', 2),
('Switzerland', 'CH', 1),
('China', 'CN', 3),
('GERMANY', 'DE', 1),
('Denmark', 'DK', 1),
('Egypt', 'EG', 4),
('France', 'FR', 1),
('HongKong', 'HK', 3),
('Israel', 'IL', 4),
('India', 'IN', 3),
('Italy', 'IT', 1),
('Japan', 'JP', 3),
('Kuwait', 'KW', 4),
('Mexico', 'MX', 2),
('Nigeria', 'NG', 4),
('Netherlands', 'NL', 1),
('Singapore', 'SG', 3),
('United Kingdom', 'UK', 1),
('United States of America', 'US', 2),
('Zambia', 'ZM', 4),
('Zimbabwe', 'ZW', 4),
('IRAN', 'IR', 3);             
CREATE CACHED TABLE "PUBLIC"."LOCATIONS"(
    "LOCATION_ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "STREET_ADDRESS" CHARACTER VARYING(40) DEFAULT NULL,
    "POSTAL_CODE" CHARACTER VARYING(12) DEFAULT NULL,
    "CITY" CHARACTER VARYING(30) NOT NULL,
    "STATE_PROVINCE" CHARACTER VARYING(25) DEFAULT NULL,
    "COUNTRY_ID" CHARACTER(2) NOT NULL
);              
ALTER TABLE "PUBLIC"."LOCATIONS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_5" PRIMARY KEY("LOCATION_ID");           
-- 7 +/- SELECT COUNT(*) FROM PUBLIC.LOCATIONS;               
INSERT INTO "PUBLIC"."LOCATIONS" VALUES
(1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US'),
(1500, '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US'),
(1700, '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US'),
(1800, '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA'),
(2400, '8204 Arthur St', NULL, 'London', NULL, 'UK'),
(2500, 'Magdalen Centre, The Oxford Science Park', 'OX9 9ZB', 'Oxford', 'Oxford', 'UK'),
(2700, 'Schwanthalerstr. 7031', '80925', 'Munich', 'Bavaria', 'DE');
CREATE CACHED TABLE "PUBLIC"."JOBS"(
    "JOB_ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "JOB_TITLE" CHARACTER VARYING(35) NOT NULL,
    "MIN_SALARY" NUMERIC(8, 2) DEFAULT NULL,
    "MAX_SALARY" NUMERIC(8, 2) DEFAULT NULL
);           
ALTER TABLE "PUBLIC"."JOBS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("JOB_ID");     
-- 19 +/- SELECT COUNT(*) FROM PUBLIC.JOBS;   
INSERT INTO "PUBLIC"."JOBS" VALUES
(1, 'Public Accountant', 4200.00, 9000.00),
(2, 'Accounting Manager', 8200.00, 16000.00),
(3, 'Administration Assistant', 3000.00, 6000.00),
(4, 'President', 20000.00, 40000.00),
(5, 'Administration Vice President', 15000.00, 30000.00),
(6, 'Accountant', 4200.00, 9000.00),
(7, 'Finance Manager', 8200.00, 16000.00),
(8, 'Human Resources Representative', 4000.00, 9000.00),
(9, 'Programmer', 4000.00, 10000.00),
(10, 'Marketing Manager', 9000.00, 15000.00),
(11, 'Marketing Representative', 4000.00, 9000.00),
(12, 'Public Relations Representative', 4500.00, 10500.00),
(13, 'Purchasing Clerk', 2500.00, 5500.00),
(14, 'Purchasing Manager', 8000.00, 15000.00),
(15, 'Sales Manager', 10000.00, 20000.00),
(16, 'Sales Representative', 6000.00, 12000.00),
(17, 'Shipping Clerk', 2500.00, 5500.00),
(18, 'Stock Clerk', 2000.00, 5000.00),
(19, 'Stock Manager', 5500.00, 8500.00);              
CREATE CACHED TABLE "PUBLIC"."DEPARTMENTS"(
    "DEPARTMENT_ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "DEPARTMENT_NAME" CHARACTER VARYING(30) NOT NULL,
    "LOCATION_ID" INTEGER DEFAULT NULL
);          
ALTER TABLE "PUBLIC"."DEPARTMENTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" PRIMARY KEY("DEPARTMENT_ID");       
-- 11 +/- SELECT COUNT(*) FROM PUBLIC.DEPARTMENTS;            
INSERT INTO "PUBLIC"."DEPARTMENTS" VALUES
(1, 'Administration', 1700),
(2, 'Marketing', 1800),
(3, 'Purchasing', 1700),
(4, 'Human Resources', 2400),
(5, 'Shipping', 1500),
(6, 'IT', 1400),
(7, 'Public Relations', 2700),
(8, 'Sales', 2500),
(9, 'Executive', 1700),
(10, 'Finance', 1700),
(11, 'Accounting', 1700);          
CREATE CACHED TABLE "PUBLIC"."EMPLOYEES"(
    "EMPLOYEE_ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 3) NOT NULL,
    "FIRST_NAME" CHARACTER VARYING(20) DEFAULT NULL,
    "LAST_NAME" CHARACTER VARYING(25) NOT NULL,
    "EMAIL" CHARACTER VARYING(100) NOT NULL,
    "PHONE_NUMBER" CHARACTER VARYING(20) DEFAULT NULL,
    "HIRE_DATE" DATE NOT NULL,
    "JOB_ID" INTEGER NOT NULL,
    "SALARY" NUMERIC(8, 2) NOT NULL,
    "MANAGER_ID" INTEGER DEFAULT NULL,
    "DEPARTMENT_ID" INTEGER DEFAULT NULL
);         
ALTER TABLE "PUBLIC"."EMPLOYEES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4" PRIMARY KEY("EMPLOYEE_ID");           
-- 46 +/- SELECT COUNT(*) FROM PUBLIC.EMPLOYEES;              
INSERT INTO "PUBLIC"."EMPLOYEES" VALUES
(100, 'Steven', 'King', 'steven.king@sqltutorial.org', '515.123.4567', DATE '1987-06-17', 4, 24000.00, NULL, 9),
(101, 'Neena', 'Kochhar', 'neena.kochhar@sqltutorial.org', '515.123.4568', DATE '1989-09-21', 5, 17000.00, 100, 9),
(102, 'Lex', 'De Haan', 'lex.de haan@sqltutorial.org', '515.123.4569', DATE '1993-01-13', 5, 17000.00, 100, 9),
(103, 'Alexander', 'Hunold', 'alexander.hunold@sqltutorial.org', '590.423.4567', DATE '1990-01-03', 9, 9000.00, 102, 6),
(104, 'Bruce', 'Ernst', 'bruce.ernst@sqltutorial.org', '590.423.4568', DATE '1991-05-21', 9, 6000.00, 103, 6),
(105, 'David', 'Austin', 'david.austin@sqltutorial.org', '590.423.4569', DATE '1997-06-25', 9, 4800.00, 103, 6),
(106, 'Valli', 'Pataballa', 'valli.pataballa@sqltutorial.org', '590.423.4560', DATE '1998-02-05', 9, 4800.00, 103, 6),
(107, 'Diana', 'Lorentz', 'diana.lorentz@sqltutorial.org', '590.423.5567', DATE '1999-02-07', 9, 4200.00, 103, 6),
(108, 'Nancy', 'Greenberg', 'nancy.greenberg@sqltutorial.org', '515.124.4569', DATE '1994-08-17', 7, 12000.00, 101, 10),
(109, 'Daniel', 'Faviet', 'daniel.faviet@sqltutorial.org', '515.124.4169', DATE '1994-08-16', 6, 9000.00, 108, 10),
(110, 'John', 'Chen', 'john.chen@sqltutorial.org', '515.124.4269', DATE '1997-09-28', 6, 8200.00, 108, 10),
(111, 'Ismael', 'Sciarra', 'ismael.sciarra@sqltutorial.org', '515.124.4369', DATE '1997-09-30', 6, 7700.00, 108, 10),
(112, 'Jose Manuel', 'Urman', 'jose manuel.urman@sqltutorial.org', '515.124.4469', DATE '1998-03-07', 6, 7800.00, 108, 10),
(113, 'Luis', 'Popp', 'luis.popp@sqltutorial.org', '515.124.4567', DATE '1999-12-07', 6, 6900.00, 108, 10),
(114, 'Den', 'Raphaely', 'den.raphaely@sqltutorial.org', '515.127.4561', DATE '1994-12-07', 14, 11000.00, 100, 3),
(115, 'Alexander', 'Khoo', 'alexander.khoo@sqltutorial.org', '515.127.4562', DATE '1995-05-18', 13, 3100.00, 114, 3),
(116, 'Shelli', 'Baida', 'shelli.baida@sqltutorial.org', '515.127.4563', DATE '1997-12-24', 13, 2900.00, 114, 3),
(117, 'Sigal', 'Tobias', 'sigal.tobias@sqltutorial.org', '515.127.4564', DATE '1997-07-24', 13, 2800.00, 114, 3),
(118, 'Guy', 'Himuro', 'guy.himuro@sqltutorial.org', '515.127.4565', DATE '1998-11-15', 13, 2600.00, 114, 3),
(119, 'Karen', 'Colmenares', 'karen.colmenares@sqltutorial.org', '515.127.4566', DATE '1999-08-10', 13, 2500.00, 114, 3),
(120, 'Matthew', 'Weiss', 'matthew.weiss@sqltutorial.org', '650.123.1234', DATE '1996-07-18', 19, 8000.00, 100, 5),
(121, 'Adam', 'Fripp', 'adam.fripp@sqltutorial.org', '650.123.2234', DATE '1997-04-10', 19, 8200.00, 100, 5),
(122, 'Payam', 'Kaufling', 'payam.kaufling@sqltutorial.org', '650.123.3234', DATE '1995-05-01', 19, 7900.00, 100, 5),
(123, 'Shanta', 'Vollman', 'shanta.vollman@sqltutorial.org', '650.123.4234', DATE '1997-10-10', 19, 6500.00, 100, 5),
(126, 'Irene', 'Mikkilineni', 'irene.mikkilineni@sqltutorial.org', '650.124.1224', DATE '1998-09-28', 18, 2700.00, 120, 5),
(145, 'John', 'Russell', 'john.russell@sqltutorial.org', NULL, DATE '1996-10-01', 15, 14000.00, 100, 8),
(146, 'Karen', 'Partners', 'karen.partners@sqltutorial.org', NULL, DATE '1997-01-05', 15, 13500.00, 100, 8),
(176, 'Jonathon', 'Taylor', 'jonathon.taylor@sqltutorial.org', NULL, DATE '1998-03-24', 16, 8600.00, 100, 8),
(177, 'Jack', 'Livingston', 'jack.livingston@sqltutorial.org', NULL, DATE '1998-04-23', 16, 8400.00, 100, 8),
(178, 'Kimberely', 'Grant', 'kimberely.grant@sqltutorial.org', NULL, DATE '1999-05-24', 16, 7000.00, 100, 8),
(179, 'Charles', 'Johnson', 'charles.johnson@sqltutorial.org', NULL, DATE '2000-01-04', 16, 6200.00, 100, 8),
(192, 'Sarah', 'Bell', 'sarah.bell@sqltutorial.org', '650.501.1876', DATE '1996-02-04', 17, 4000.00, 123, 5),
(193, 'Britney', 'Everett', 'britney.everett@sqltutorial.org', '650.501.2876', DATE '1997-03-03', 17, 3900.00, 123, 5),
(200, 'Jennifer', 'Whalen', 'jennifer.whalen@sqltutorial.org', '515.123.4444', DATE '1987-09-17', 3, 4400.00, 101, 1),
(201, 'Michael', 'Hartstein', 'michael.hartstein@sqltutorial.org', '515.123.5555', DATE '1996-02-17', 10, 13000.00, 100, 2),
(202, 'Pat', 'Fay', 'pat.fay@sqltutorial.org', '603.123.6666', DATE '1997-08-17', 11, 6000.00, 201, 2);     
INSERT INTO "PUBLIC"."EMPLOYEES" VALUES
(203, 'Susan', 'Mavris', 'susan.mavris@sqltutorial.org', '515.123.7777', DATE '1994-06-07', 8, 6500.00, 101, 4),
(204, 'Hermann', 'Baer', 'hermann.baer@sqltutorial.org', '515.123.8888', DATE '1994-06-07', 12, 10000.00, 101, 7),
(205, 'Shelley', 'Higgins', 'shelley.higgins@sqltutorial.org', '515.123.8080', DATE '1994-06-07', 2, 12000.00, 101, 11),
(206, 'William', 'Gietz', 'william.gietz@sqltutorial.org', '515.123.8181', DATE '1994-06-07', 1, 8300.00, 205, 11),
(207, 'rojina', 'someone', 'rojin@gmail.com', '09876', DATE '2023-11-22', 8, 899999.00, 102, 2),
(208, 'rojina', 'someone', 'rojin@gmail.com', '09876', DATE '2023-11-22', 8, 899999.00, 102, 2),
(209, 'rojina', 'someone', 'rojin@gmail.com', '09876', DATE '2023-11-22', 8, 899999.00, 102, 2),
(210, 'rojina', 'someone', 'rojin@gmail.com', '09876', DATE '2023-11-22', 8, 899999.00, 102, 2),
(211, 'rojina', 'someone', 'rojin@gmail.com', '09876', DATE '2023-11-22', 8, 899999.00, 102, 2),
(213, 'rojina', 'someone', 'rojin@gmail.com', '09876', DATE '2023-11-22', 8, 899999.00, 102, 2);      
CREATE CACHED TABLE "PUBLIC"."DEPENDENTS"(
    "DEPENDENT_ID" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "FIRST_NAME" CHARACTER VARYING(50) NOT NULL,
    "LAST_NAME" CHARACTER VARYING(50) NOT NULL,
    "RELATIONSHIP" CHARACTER VARYING(25) NOT NULL,
    "EMPLOYEE_ID" INTEGER NOT NULL
);
ALTER TABLE "PUBLIC"."DEPENDENTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("DEPENDENT_ID");         
-- 30 +/- SELECT COUNT(*) FROM PUBLIC.DEPENDENTS;             
INSERT INTO "PUBLIC"."DEPENDENTS" VALUES
(1, 'Penelope', 'Gietz', 'Child', 206),
(2, 'Nick', 'Higgins', 'Child', 205),
(3, 'Ed', 'Whalen', 'Child', 200),
(4, 'Jennifer', 'King', 'Child', 100),
(5, 'Johnny', 'Kochhar', 'Child', 101),
(6, 'Bette', 'De Haan', 'Child', 102),
(7, 'Grace', 'Faviet', 'Child', 109),
(8, 'Matthew', 'Chen', 'Child', 110),
(9, 'Joe', 'Sciarra', 'Child', 111),
(10, 'Christian', 'Urman', 'Child', 112),
(11, 'Zero', 'Popp', 'Child', 113),
(12, 'Karl', 'Greenberg', 'Child', 108),
(13, 'Uma', 'Mavris', 'Child', 203),
(14, 'Vivien', 'Hunold', 'Child', 103),
(15, 'Cuba', 'Ernst', 'Child', 104),
(16, 'Fred', 'Austin', 'Child', 105),
(17, 'Helen', 'Pataballa', 'Child', 106),
(18, 'Dan', 'Lorentz', 'Child', 107),
(19, 'Bob', 'Hartstein', 'Child', 201),
(20, 'Lucille', 'Fay', 'Child', 202),
(21, 'Kirsten', 'Baer', 'Child', 204),
(22, 'Elvis', 'Khoo', 'Child', 115),
(23, 'Sandra', 'Baida', 'Child', 116),
(24, 'Cameron', 'Tobias', 'Child', 117),
(25, 'Kevin', 'Himuro', 'Child', 118),
(26, 'Rip', 'Colmenares', 'Child', 119),
(27, 'Julia', 'Raphaely', 'Child', 114),
(28, 'Woody', 'Russell', 'Child', 145),
(29, 'Alec', 'Partners', 'Child', 146),
(30, 'Sandra', 'Taylor', 'Child', 176);      
ALTER TABLE "PUBLIC"."EMPLOYEES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4351" FOREIGN KEY("MANAGER_ID") REFERENCES "PUBLIC"."EMPLOYEES"("EMPLOYEE_ID") NOCHECK;  
ALTER TABLE "PUBLIC"."DEPARTMENTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9F" FOREIGN KEY("LOCATION_ID") REFERENCES "PUBLIC"."LOCATIONS"("LOCATION_ID") ON DELETE CASCADE NOCHECK;               
ALTER TABLE "PUBLIC"."EMPLOYEES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_43" FOREIGN KEY("JOB_ID") REFERENCES "PUBLIC"."JOBS"("JOB_ID") ON DELETE CASCADE NOCHECK;
ALTER TABLE "PUBLIC"."EMPLOYEES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_435" FOREIGN KEY("DEPARTMENT_ID") REFERENCES "PUBLIC"."DEPARTMENTS"("DEPARTMENT_ID") ON DELETE CASCADE NOCHECK;          
ALTER TABLE "PUBLIC"."DEPENDENTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1B" FOREIGN KEY("EMPLOYEE_ID") REFERENCES "PUBLIC"."EMPLOYEES"("EMPLOYEE_ID") ON DELETE CASCADE NOCHECK;
ALTER TABLE "PUBLIC"."COUNTRIES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F6" FOREIGN KEY("REGION_ID") REFERENCES "PUBLIC"."REGIONS"("REGION_ID") ON DELETE CASCADE NOCHECK;       
ALTER TABLE "PUBLIC"."LOCATIONS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_5E" FOREIGN KEY("COUNTRY_ID") REFERENCES "PUBLIC"."COUNTRIES"("COUNTRY_ID") ON DELETE CASCADE NOCHECK;   