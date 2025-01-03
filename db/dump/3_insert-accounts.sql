CREATE OR REPLACE PROCEDURE create_account()
LANGUAGE plpgsql
AS $$
BEGIN
    FOR i IN 1..200 LOOP
        INSERT INTO public.account (creation_time, balance, owner)
        VALUES (
            current_timestamp,
            1000 * i,
            (SELECT id FROM public."client" OFFSET floor(random() * (SELECT COUNT(*) FROM public."client")) LIMIT 1)
        );
    END LOOP;
END;
$$;

CALL create_account();