CREATE TABLE service_request (
    id                           SERIAL PRIMARY KEY,
    topic_id                     INTEGER NOT NULL REFERENCES topic (id),
    sub_topic_id                 INTEGER NOT NULL REFERENCES sub_topic (id),
    description                  TEXT NOT NULL,
    occurrence_address           VARCHAR(500) NOT NULL,
    requester_person_id          INTEGER NOT NULL REFERENCES person (id),
    responsible_user_account_id  INTEGER NOT NULL REFERENCES user_account (id),
    occurrence_at                TIMESTAMPTZ NOT NULL,
    created_at                   TIMESTAMPTZ NOT NULL,
    updated_at                   TIMESTAMPTZ NOT NULL
);

CREATE INDEX idx_service_request_topic ON service_request (topic_id);
CREATE INDEX idx_service_request_sub_topic ON service_request (sub_topic_id);
CREATE INDEX idx_service_request_requester ON service_request (requester_person_id);
CREATE INDEX idx_service_request_responsible_user ON service_request (responsible_user_account_id);
