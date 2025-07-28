CREATE TABLE IF NOT EXISTS enterprise_contact (
    contact_id UUID NOT NULL,
    enterprise_id UUID NOT NULL,

    CONSTRAINT pk_enterprise_contact PRIMARY KEY (contact_id, enterprise_id),

    CONSTRAINT fk_contact_enterprise_contact_id  FOREIGN KEY (contact_id) REFERENCES contact(id),
    CONSTRAINT fk_contact_enterprise_enterprise_id FOREIGN KEY (enterprise_id) REFERENCES enterprise(id)
);