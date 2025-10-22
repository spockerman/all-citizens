CREATE TABLE sub_topic (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    deadline TIMESTAMP,
    urgency_level VARCHAR(20) NOT NULL,
    topic_id INTEGER NOT NULL,
    department_id INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP,
    FOREIGN KEY (topic_id) REFERENCES topic(id),
    FOREIGN KEY (department_id) REFERENCES department(id)
);