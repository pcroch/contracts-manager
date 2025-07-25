-- as if not employee then is freelancer
alter table CONTACT
ADD CONSTRAINT check_if_freelancer
CHECK ( (NOT is_employee) OR (tva_number IS NOT NULL) )
