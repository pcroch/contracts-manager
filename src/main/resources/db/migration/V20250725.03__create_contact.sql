CREATE TABLE IF NOT EXISTS contact (
                        id UUID  PRIMARY KEY,
                        name VARCHAR ( 50 ) NOT NULL,
                        last_name VARCHAR ( 50 ) NOT NULL,
                        is_employee boolean DEFAULT true, -- true to satisfy the constraint by default
                        tva_number VARCHAR ( 12 ),
                        address_id UUID,
                        FOREIGN KEY (address_id) REFERENCES address (id)
);
