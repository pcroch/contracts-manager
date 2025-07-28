INSERT INTO ADDRESS (id, street_number, box_number, street_name, zipcode, locality, country)
VALUES
    ('e5f6a7b8-c9d0-1234-5678-90abcdef0123', '8', NULL, 'Rue de la Loi', '1000', 'Brussels', 'Belgium'),
    ('f6a7b8c9-d0e1-2345-6789-0abcdef01234', '15', 'Bus 4', 'Leopoldstraat', '2000', 'Antwerp', 'Belgium'),
    ('a1b2c3d4-e5f6-7890-5678-90abcdef0123', '21', NULL, 'Kouter', '9000', 'Ghent', 'Belgium'),
    ('b2c3d4e5-f6a7-8901-2345-1234567890ab', '78', 'B1', 'Avenue du Prince de Orange', '1180', 'Uccle', 'Belgium'),
    ('c3d4e5f6-a7b8-9012-3456-1234567890ac', '1', NULL, 'Grand-Place', '1000', 'Brussels', 'Belgium'),
    ('d4e5f6a7-b8c9-0123-4567-1234567890ad', '180', NULL, 'Rue de la Victoire', '1060', 'Saint-Gilles', 'Belgium');


INSERT INTO contact (id, name, last_name, is_employee, vat_number, address_id)
VALUES
     -- Employee
    ('e01f2fc2-d559-4e3b-b667-b4078bf0fefa', 'Alice', 'Smith', TRUE, NULL, 'e5f6a7b8-c9d0-1234-5678-90abcdef0123'),
    -- Freelancer
    ('2efd6efe-6998-4299-b883-177fe11da065', 'Bob', 'Johnson', FALSE, 'BE0123456789', 'f6a7b8c9-d0e1-2345-6789-0abcdef01234'),
    -- Employee
    ('f0d9feeb-f25e-45dd-b688-5524a3fbb985', 'Charlie', 'Brown', TRUE, NULL, 'a1b2c3d4-e5f6-7890-5678-90abcdef0123'),
    -- Freelancer
    ('7a0dbc2a-9897-4409-82cf-cbce8e8e8a51', 'Jane', 'Prince', FALSE, 'BE9876543210', 'b2c3d4e5-f6a7-8901-2345-1234567890ab');


INSERT INTO ENTERPRISE (id, vat_number, address_id)
VALUES
    -- Enterprise 1: Uses Brussels address
    ('e6a7ff8b-9c5c-4174-a823-3ffd261a5fcc', 'BE0123456789', 'e5f6a7b8-c9d0-1234-5678-90abcdef0123'),

    -- Enterprise 2: Uses Antwerp address
    ('e36946d5-e30f-412d-bdbf-43ee2c9a08d6', 'BE9876543210', 'f6a7b8c9-d0e1-2345-6789-0abcdef01234'),

    -- Enterprise 3: Uses Ghent address
    ('a78818b8-2427-40cd-9a07-9e5c2ce9e798', 'BE1122334455', 'a1b2c3d4-e5f6-7890-5678-90abcdef0123'),

    -- Enterprise 4: Uses Uccle address
    ('67f40bdf-d137-4968-a970-4e285ea0fb2e', 'BE6789012345', 'b2c3d4e5-f6a7-8901-2345-1234567890ab'),

    -- Enterprise 5: Uses Grand-Place address
    ('d6316aef-1848-41ff-a7e5-b12a01666ce5', 'BE5432109876', 'c3d4e5f6-a7b8-9012-3456-1234567890ac'),

    -- Enterprise 6: Uses Saint-Gilles address
    ('fe612de9-0f8e-4d8a-9648-1fbb1f2bab46', 'BE5432109878', 'd4e5f6a7-b8c9-0123-4567-1234567890ad');