CREATE TABLE ENTERPRISE (
                        enterprise_id UUID  PRIMARY KEY,
                        tva_number VARCHAR ( 12 ) NOT NULL,
                        address_id UUID UNIQUE,
                         FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id)
);
