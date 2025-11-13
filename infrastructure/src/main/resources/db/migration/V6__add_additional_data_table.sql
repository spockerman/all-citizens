
CREATE TABLE category_additional_field (
    id            INTEGER PRIMARY KEY,
    code          VARCHAR(100) UNIQUE NOT NULL,
    name          VARCHAR(200) NOT NULL,
    description   VARCHAR(400),
    created_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    deleted_at    TIMESTAMPTZ
);


CREATE TABLE field_type (
    id        SMALLSERIAL PRIMARY KEY,
    code      VARCHAR(50) UNIQUE NOT NULL,
    ui_widget VARCHAR(100) NOT NULL
);

INSERT INTO field_type (code, ui_widget) VALUES
        ('text','TextInput'),
        ('textarea','TextArea'),
        ('integer','NumberInput'),
        ('decimal','NumberInput'),
        ('date','DatePicker'),
        ('datetime','DateTimePicker'),
        ('boolean','Switch'),
        ('select','Select'),
        ('multiselect','MultiSelect'),
        ('radio','RadioGroup'),
        ('checkbox','CheckboxGroup'),
        ('file','FileUpload'),
        ('json','JsonEditor');

CREATE TABLE additional_field (
    id                INTEGER PRIMARY KEY,
    category_id       INTEGER NOT NULL REFERENCES category_additional_field(id) ON DELETE CASCADE,
    name              VARCHAR(100) NOT NULL,
    label             VARCHAR(200) NOT NULL,
    help_text         VARCHAR(400),
    placeholder       VARCHAR(200),
    field_type_id     SMALLINT NOT NULL REFERENCES field_type(id),
    required          BOOLEAN NOT NULL DEFAULT FALSE,
    read_only         BOOLEAN NOT NULL DEFAULT FALSE,
    visible           BOOLEAN NOT NULL DEFAULT TRUE,
    min_length        INTEGER,
    max_length        INTEGER,
    min_value         NUMERIC(18,4),
    max_value         NUMERIC(18,4),
    pattern_regex     VARCHAR(300),
    mask              VARCHAR(100),
    default_value     TEXT,
    sort_order        INTEGER NOT NULL DEFAULT 0,
    width             VARCHAR(20),
    group_name        VARCHAR(100),
    data_source_type  VARCHAR(30) NOT NULL DEFAULT 'STATIC', -- STATIC | API
    data_source_ref   VARCHAR(400), -- STATIC: null, API: URL/rota/identificador de fonte
    created_at        TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at        TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    deleted_at        TIMESTAMPTZ,
    CONSTRAINT uq_category_name UNIQUE (category_id, name)
);

CREATE TABLE additional_field_option (
    id              INTEGER PRIMARY KEY,
    field_id        INTEGER NOT NULL REFERENCES additional_field(id) ON DELETE CASCADE,
    value           VARCHAR(200) NOT NULL,   -- valor enviado (ex.: 'SP')
    label           VARCHAR(200) NOT NULL,   -- rótulo (ex.: 'São Paulo')
    sort_order      INTEGER NOT NULL DEFAULT 0,
    active          BOOLEAN NOT NULL DEFAULT TRUE,
    metadata        JSONB,                   -- opcional (cor, ícone, tags, etc.)
    created_at      TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT uq_field_value UNIQUE (field_id, value)
);

CREATE TABLE additional_data_value (
    id              INTEGER PRIMARY KEY,
    category_id     INTEGER NOT NULL REFERENCES category_additional_field(id) ON DELETE RESTRICT,
    field_id        INTEGER NOT NULL REFERENCES additional_field(id) ON DELETE RESTRICT,

    target_table    VARCHAR(100) NOT NULL,  -- ex.: 'citizen', 'neighborhood', 'order'
    target_id       INTEGER NOT NULL,        -- id do registro alvo

    -- Armazenamento flexível do valor digitado/selecionado
    value_text      TEXT,
    value_number    NUMERIC(18,4),
    value_boolean   BOOLEAN,
    value_date      DATE,
    value_datetime  TIMESTAMPTZ,
    value_json      JSONB,                  -- ex.: multiselect: lista, file: metadados

    created_by      VARCHAR(100),
    created_at      TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT uq_value_unique UNIQUE (category_id, field_id, target_table, target_id)
);

-- Índices úteis
CREATE INDEX idx_additional_field_category ON additional_field(category_id);
CREATE INDEX idx_additional_field_option_field ON additional_field_option(field_id);
CREATE INDEX idx_additional_data_value_target ON additional_data_value(target_table, target_id);