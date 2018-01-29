/* no manual inclusion needed. spring boot handles that. */
INSERT INTO ADDRESS(ID, STREET, HOUSENUMBER, ZIP, PLACE, PARTNER_ID) VALUES ('address1', 'Bundesplatz', '8', '3001', 'Bern', 'person1');
INSERT INTO ADDRESS(ID, STREET, HOUSENUMBER, ZIP, PLACE, PARTNER_ID) VALUES ('address2', 'Sunset Drive', '1', '1234', 'Bakersfield', 'person2');
INSERT INTO EMAIL(ID, ADDRESS, PARTNER_ID) VALUES ('email1', 'test1@example.com', 'person1');
INSERT INTO PHONE(ID, NUMBER, PARTNER_ID) VALUES ('phone1', '076 000 00 00', 'person2');