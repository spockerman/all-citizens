CREATE TABLE person (
 id              SERIAL PRIMARY KEY,
 full_name       VARCHAR(200) NOT NULL,
 cpf_number VARCHAR(40),             -- National ID / Tax ID (e.g., CPF, CNPJ, etc.)
 birth_date      DATE,
 created_at      TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE citizen (
 person_id   SERIAL PRIMARY KEY REFERENCES person(id) ON DELETE CASCADE,
 social_id   VARCHAR(20),                 -- Social identification number (e.g., NIS)
 type VARCHAR(20) NOT NULL,
 created_at  TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE employee (
 person_id       SERIAL PRIMARY KEY REFERENCES person(id) ON DELETE CASCADE,
 department_id   INTEGER NOT NULL,        -- Department / Secretariat
 position_title  VARCHAR(100),
 document_number VARCHAR(40),
 created_at      TIMESTAMP NOT NULL DEFAULT NOW()
);

-- User account (who logs into the system)
CREATE TABLE user_account (
 id              SERIAL PRIMARY KEY,
 person_id       INTEGER NOT NULL REFERENCES person(id) ON DELETE RESTRICT,
 auth_provider   VARCHAR(40) NOT NULL,    -- e.g., 'keycloak'
 auth_subject    VARCHAR(120) NOT NULL,   -- Unique subject ID from the identity provider (token sub)
 mobile VARCHAR(20) NOT NULL,
 email VARCHAR(100) NOT NULL,
 is_active       BOOLEAN NOT NULL DEFAULT TRUE,
 UNIQUE (auth_provider, auth_subject)
);
CREATE TABLE service_request (
 id                   SERIAL PRIMARY KEY,
 ticket_number        VARCHAR(20) NOT NULL,
 requester_person_id  INTEGER NOT NULL REFERENCES person(id) ON DELETE RESTRICT,
 created_by_user_id   INTEGER NOT NULL REFERENCES user_account(id) ON DELETE RESTRICT,
 address_id           INTEGER NOT NULL,
 sub_topic_id         INTEGER REFERENCES sub_topic(id) ON DELETE RESTRICT,
 incident_id          INTEGER,
 description          VARCHAR(3000),
 external_doc_type_id INTEGER,
 external_doc_desc    VARCHAR(60),
 response_channel_id  INTEGER,
 revision_flag        BOOLEAN NOT NULL DEFAULT FALSE,
 confidential_flag    BOOLEAN NOT NULL DEFAULT FALSE,
 notes                VARCHAR(500),
 sms_notification     BOOLEAN NOT NULL DEFAULT FALSE,
 parent_request_id    INTEGER REFERENCES service_request(id),
 channel              VARCHAR(20) NOT NULL,      -- 'PHONE','MOBILE','WEB','BACKOFFICE'
 created_at           TIMESTAMP NOT NULL DEFAULT NOW(),
 CONSTRAINT ux_service_request_ticket_number UNIQUE (ticket_number)
);