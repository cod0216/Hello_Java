CREATE TABLE account (
    username    VARCHAR(255),
    password    VARCHAR(255),
    nickname    VARCHAR(255),

    status      VARCHAR(255),
    created_at  TIMESTAMP           DEFAULT NOW(),
    updated_at  TIMESTAMP
);