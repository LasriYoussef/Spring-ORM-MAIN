INSERT INTO public."insurance" ("name")
SELECT name FROM (
    VALUES ('assurance_habitation'),
    ('assurance_sante'),
    ('assurance_vie'),
    ('assurance_automobile'),
    ('assurance_scolaire'),
    ('rc_pro')
) AS insurances ("name");
