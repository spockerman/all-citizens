ALTER TABLE department ADD COLUMN parent_department_id INTEGER;
ALTER TABLE department ADD CONSTRAINT fk_parent_department
    FOREIGN KEY (parent_department_id) REFERENCES department(id);