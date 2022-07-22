--liquibase formatted sql

--changeset daniil.polyanin:SMS-2

ALTER TABLE employee ADD COLUMN salary bigint NOT NULL;
ALTER TABLE employee ADD COLUMN salary_bonus bigint NOT NULL;
ALTER TABLE project ADD COLUMN benefit bigint NOT NULL;

--rollback ALTER TABLE employee DROP COLUMN salary;
--rollback ALTER TABLE employee DROP COLUMN salary_bonus;
--rollback ALTER TABLE project DROP COLUMN benefit;
