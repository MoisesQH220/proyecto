DROP TABLE IF EXISTS "proyecto"."user" CASCADE;
DROP TABLE IF EXISTS "proyecto"."university" CASCADE;

DROP TYPE  IF EXISTS "proyecto"."role";

DROP SEQUENCE IF EXISTS "proyecto"."university_id_seq";
CREATE SEQUENCE "proyecto"."university_id_seq" INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;

DROP SEQUENCE IF EXISTS "proyecto"."user_id_seq";
CREATE SEQUENCE "proyecto"."user_id_seq" INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;


CREATE TYPE "proyecto"."role" AS ENUM (
    'ADMIN',
    'USER'
);

CREATE TABLE "proyecto"."university" (
    "id" integer DEFAULT nextval('university_id_seq') NOT NULL,
    "name" character varying(100) NOT NULL,
    "district" character varying(50) NOT NULL,
    "city" character varying(50) NOT NULL,
    "ruc" character varying(10) NOT NULL,
    "country" character varying(10) NOT NULL,
    CONSTRAINT "university_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "unique_university_name" UNIQUE ("name"),
    CONSTRAINT "unique_university_ruc" UNIQUE ("ruc")
) WITH (oids = false);

CREATE TABLE "proyecto"."user" (
    "id" integer DEFAULT nextval('user_id_seq') NOT NULL,
    "university_id" integer NOT NULL,
    "name" character varying(100) NOT NULL,
    "last_name" character varying(50) NOT NULL,
    "email" character varying(50) NOT NULL,
    "password" character varying(50) NOT NULL,
    "role" role NOT NULL,
    CONSTRAINT "user_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "unique_university_id_name" UNIQUE ("university_id", "name"),
    CONSTRAINT "fkey_user_university" FOREIGN KEY (university_id) REFERENCES university(id) NOT DEFERRABLE
) WITH (oids = false);