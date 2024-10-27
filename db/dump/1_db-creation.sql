DROP TABLE IF EXISTS public.client CASCADE;
DROP TABLE IF EXISTS public.account CASCADE;
DROP TABLE IF EXISTS public.insurance CASCADE;

CREATE TABLE client (
    id UUID PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    birth_date DATE NOT NULL
);

CREATE TABLE public.insurance (
	insurance_id serial4 NOT NULL,
	"name" varchar(100) NULL,
    CONSTRAINT insurance_pkey PRIMARY KEY (insurance_id)
);

CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    creation_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    balance BIGINT NOT NULL,
    owner UUID NOT NULL,
    FOREIGN KEY (owner) REFERENCES client(id)
);

CREATE TABLE client_insurance (
    client_id UUID,
    insurance_id serial4,
    PRIMARY KEY (client_id, insurance_id),
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
    CONSTRAINT fk_insurance FOREIGN KEY (insurance_id) REFERENCES insurance(insurance_id) ON DELETE CASCADE
);
