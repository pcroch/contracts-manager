ALTER TABLE CONTRACT
DROP CONSTRAINT check_if_freelancer;

-- A freelancer  must have a TVA number.
ALTER TABLE CONTRACT
ADD CONSTRAINT check_freelancer_has_tva
CHECK (is_employee or tva_number IS NOT NULL);

-- An employee must NOT have a TVA number.
ALTER TABLE CONTRACT
ADD CONSTRAINT check_employee_no_tva
CHECK (NOT is_employee or tva_number IS NULL);