	CREATE DATABASE "telegram_travel_guide_db"
    WITH
    ENCODING = 'UTF8'
	CONNECTION LIMIT = -1;


\c telegram_travel_guide_db


	CREATE TABLE public."guide"
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    city character varying(20) NOT NULL UNIQUE,
    city_info character varying(2000) NOT NULL,
    PRIMARY KEY (id)
);
