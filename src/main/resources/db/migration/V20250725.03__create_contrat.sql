create TABLE CONTRACT (
                        contract_id UUID  PRIMARY KEY,
                        firstname VARCHAR ( 50 ) NOT NULL,
                        lastname VARCHAR ( 50 ) NOT NULL,
                        is_employee boolean DEFAULT true, -- true to satisfy the constraint by default
                        tva_number VARCHAR ( 12 ),
                        address_id UUID UNIQUE,
                        FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id)
);
