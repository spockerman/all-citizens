
CREATE TABLE department (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description varchar(255) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100),
    active boolean not null,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP

);