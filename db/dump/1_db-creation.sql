DROP TABLE IF EXISTS public.client CASCADE;
DROP TABLE IF EXISTS public.client CASCADE;

CREATE TABLE client (
    id UUID PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    birth_date DATE NOT NULL
);

CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    creation_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    balance BIGINT NOT NULL,
    owner UUID NOT NULL,
    FOREIGN KEY (owner) REFERENCES client(id)
);

CREATE TABLE insurance (
    id UUID PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    monthly_premium DECIMAL(10,2) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    coverage_amount DECIMAL(10,2) NOT NULL,
    client_id UUID NOT NULL,
    account_id BIGINT,
    FOREIGN KEY (client_id) REFERENCES client(id),
    FOREIGN KEY (account_id) REFERENCES account(id)
);