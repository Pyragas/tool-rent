INSERT INTO PUBLIC.PROFILE (CUSTOMER_TYPE, ID, EMAIL, PASSWORD, PHONENO, RATING, OPT_LOCK_VERSION, COMPANYCODE, NAME, PERSONALCODE, SURNAME) VALUES (1, 1, 'statyknama@stroike.com', 'slaptesnis', '4455', 7.400000095367432, 0, '123', 'Statita', null, null);
INSERT INTO PUBLIC.PROFILE (CUSTOMER_TYPE, ID, EMAIL, PASSWORD, PHONENO, RATING, OPT_LOCK_VERSION, COMPANYCODE, NAME, PERSONALCODE, SURNAME) VALUES (0, 2, 'xkavatorius@one.lt', 'slaptas', '867421299', 8.300000190734863, 0, null, 'Bronis', '123', 'Burokas');

INSERT INTO PUBLIC.ADVERTISEMENT (ID, FUELLEVEL, FUELTYPE, IMAGE, LOCATION, MEASUREMENTS, NAME, OPERATORPRICE, RENTPRICE, STATUS, TEXT, TYPE, WEIGHT, PROFILE_ID) VALUES (1, 'Pilnas', 'Dyzelinas', 'D:\IdeaProjects\tool-rent\target\ToolRent-1.0-SNAPSHOT\WEB-INF\classes\images\samsung.jpg', 'Didlaukio g. 59', '4x4x2', 'Ekskavatorius Samsung 3310', 99.99, 39.99, 'Laisvas', 'Puikus ekskavatorius, puikiai kasa duobes', 'Ekskavatorius', 4400, 1);

INSERT INTO PUBLIC.ORDER_TABLE (ID, DELIVERYLOCATION, OPERATOR, OPERATORPRICE, RENTPRICE, RENTTIMEEND, RENTTIMESTART, STATUS, ADVERTISEMENT_ID, PROFILE_ID) VALUES (1, 'Naugarduko g. 24', false, 345.12, 345.12, '2021-05-27 08:15:05.118863000', '2021-05-26 08:15:05.114860000', 'IN_PROGRESS', 1, 2);