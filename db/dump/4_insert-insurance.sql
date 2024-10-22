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