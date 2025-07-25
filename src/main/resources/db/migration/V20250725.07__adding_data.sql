INSERT INTO ADDRESS (address_id, street_number, box_number, street_name, zipcode, locality, country)
VALUES
    ('e5f6a7b8-c9d0-1234-5678-90abcdef0123', '8', NULL, 'Rue de la Loi', '1000', 'Brussels', 'Belgium'),
    ('f6a7b8c9-d0e1-2345-6789-0abcdef01234', '15', 'Bus 4', 'Leopoldstraat', '2000', 'Antwerp', 'Belgium'),
    ('a1b2c3d4-e5f6-7890-5678-90abcdef0123', '21', NULL, 'Kouter', '9000', 'Ghent', 'Belgium'),
    ('b2c3d4e5-f6a7-8901-2345-1234567890ab', '78', 'B1', 'Avenue du Prince de Orange', '1180', 'Uccle', 'Belgium'),
    ('c3d4e5f6-a7b8-9012-3456-1234567890ac', '1', NULL, 'Grand-Place', '1000', 'Brussels', 'Belgium'),
    ('d4e5f6a7-b8c9-0123-4567-1234567890ad', '180', NULL, 'Rue de la Victoire', '1060', 'Saint-Gilles', 'Belgium');


INSERT INTO CONTRACT (contract_id, firstname, lastname, is_employee, tva_number, address_id)
VALUES
     -- Employee
    (RANDOM_UUID(), 'Alice', 'Smith', TRUE, NULL, 'e5f6a7b8-c9d0-1234-5678-90abcdef0123'),
    -- Freelancer
    (RANDOM_UUID(), 'Bob', 'Johnson', FALSE, 'BE0123456789', 'f6a7b8c9-d0e1-2345-6789-0abcdef01234'),
    -- Employee
    (RANDOM_UUID(), 'Charlie', 'Brown', TRUE, NULL, 'a1b2c3d4-e5f6-7890-5678-90abcdef0123'),
    -- Freelancer
    (RANDOM_UUID(), 'Jane', 'Prince', FALSE, 'BE9876543210', 'b2c3d4e5-f6a7-8901-2345-1234567890ab');


INSERT INTO ENTERPRISE (enterprise_id, tva_number, address_id)
VALUES
    -- Enterprise 1: Uses Brussels address
    (RANDOM_UUID(), 'BE0123456789', 'e5f6a7b8-c9d0-1234-5678-90abcdef0123'),

    -- Enterprise 2: Uses Antwerp address
    (RANDOM_UUID(), 'BE9876543210', 'f6a7b8c9-d0e1-2345-6789-0abcdef01234'),

    -- Enterprise 3: Uses Ghent address
    (RANDOM_UUID(), 'BE1122334455', 'a1b2c3d4-e5f6-7890-5678-90abcdef0123'),

    -- Enterprise 4: Uses Uccle address
    (RANDOM_UUID(), 'BE6789012345', 'b2c3d4e5-f6a7-8901-2345-1234567890ab'),

    -- Enterprise 5: Uses Grand-Place address
    (RANDOM_UUID(), 'BE5432109876', 'c3d4e5f6-a7b8-9012-3456-1234567890ac'),

    -- Enterprise 6: Uses Saint-Gilles address
    (RANDOM_UUID(), 'BE5432109878', 'd4e5f6a7-b8c9-0123-4567-1234567890ad');