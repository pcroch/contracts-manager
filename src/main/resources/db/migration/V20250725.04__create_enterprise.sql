create TABLE enterprise (
                        id UUID  PRIMARY KEY,
                        tva_number VARCHAR ( 12 ) NOT NULL,
                        address_id UUID,
                        FOREIGN KEY (address_id) REFERENCES address (id)
);
