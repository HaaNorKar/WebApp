-- SQL-fil: deltager_tabell.sql

DROP SCHEMA IF EXISTS dat108Oblig4del2 CASCADE;
CREATE SCHEMA dat108Oblig4del2;
SET search_path TO dat108Oblig4del2;

CREATE TABLE deltager (
    tlf CHARACTER (8) PRIMARY KEY, 
    hash CHARACTER (64) NOT NULL,
    salt CHARACTER (32) NOT NULL,
    fornavn CHARACTER VARYING (40) NOT NULL,
    etternavn CHARACTER VARYING (40) NOT NULL,
    kjonn CHARACTER VARYING (6) NOT NULL
);
