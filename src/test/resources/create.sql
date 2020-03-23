	CREATE TABLE "guide"
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    city character varying(20) NOT NULL UNIQUE,
    city_info character varying(2000) NOT NULL,
    PRIMARY KEY (id)
);
