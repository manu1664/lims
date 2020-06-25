DROP TABLE item_demande IF EXISTS;
DROP TABLE analyse IF EXISTS;
DROP TABLE section IF EXISTS;
DROP TABLE affaire IF EXISTS;
DROP TABLE demande IF EXISTS;
DROP TABLE requerant IF EXISTS;
DROP TABLE service IF EXISTS;

CREATE TABLE service
(
    id          INTEGER IDENTITY PRIMARY KEY,
    libelle     VARCHAR(64)  NOT NULL,
    adresse     VARCHAR(255) NOT NULL,
    code_postal VARCHAR(32)  NOT NULL,
    ville       VARCHAR(128) NOT NULL
);
CREATE INDEX service_libelle ON service (libelle);

CREATE TABLE requerant
(
    id         INTEGER IDENTITY PRIMARY KEY,
    grade      VARCHAR(32)  NOT NULL,
    prenom     VARCHAR(64)  NOT NULL,
    nom        VARCHAR(64)  NOT NULL,
    email      VARCHAR(128) NOT NULL UNIQUE,
    service_id INTEGER
);
CREATE INDEX requerant_nom ON requerant (nom);
ALTER TABLE requerant
    ADD CONSTRAINT fk_requerant_service FOREIGN KEY (service_id) REFERENCES service (id);

CREATE TABLE section
(
    id          INTEGER IDENTITY PRIMARY KEY,
    libelle     VARCHAR(32) NOT NULL,
    code        VARCHAR(3)  NOT NULL,
    description VARCHAR(255),
    actif       BOOLEAN
);
CREATE INDEX section_libelle ON section (libelle);

CREATE TABLE analyse
(
    id          INTEGER IDENTITY PRIMARY KEY,
    libelle     VARCHAR(128) NOT NULL,
    description VARCHAR(255),
    prix        DECIMAL,
    section_id  INTEGER
);
CREATE INDEX analyse_libelle ON analyse (libelle);
ALTER TABLE analyse
    ADD CONSTRAINT fk_analyse_section FOREIGN KEY (section_id) REFERENCES section (id);

CREATE TABLE affaire
(
    id INTEGER IDENTITY PRIMARY KEY,
    numero_pv VARCHAR(32) NOT NULL ,
    description VARCHAR(255)
);
CREATE INDEX affaire_numero_pv ON affaire(numero_pv);

CREATE TABLE demande
(
    id           INTEGER IDENTITY PRIMARY KEY,
    reference    VARCHAR(32) NOT NULL,
    edition_date DATE        NOT NULL,
    requerant_id INTEGER
);
CREATE INDEX demande_reference ON demande (reference);
ALTER TABLE demande
    ADD CONSTRAINT fk_demande_requerant FOREIGN KEY (requerant_id) REFERENCES requerant (id);

CREATE TABLE demande_affaire
(
    demande_id INTEGER NOT NULL,
    affaire_id INTEGER NOT NULL
);
ALTER TABLE demande_affaire ADD CONSTRAINT fk_demande_affaire_demande FOREIGN KEY (demande_id) REFERENCES demande(id);
ALTER TABLE demande_affaire ADD CONSTRAINT fk_demande_affaire_affaire FOREIGN KEY (affaire_id) REFERENCES affaire(id);

CREATE TABLE item_demande
(
    id            INTEGER IDENTITY PRIMARY KEY,
    status        VARCHAR(32) NOT NULL,
    ordre_passage INTEGER,
    demande_id    INTEGER NOT NULL,
    analyse_id    INTEGER     NOT NULL
);
ALTER TABLE item_demande
    ADD CONSTRAINT fk_item_demande_demande FOREIGN KEY (demande_id) REFERENCES demande(id);
ALTER TABLE item_demande
    ADD CONSTRAINT fk_item_demande_analyse FOREIGN KEY (analyse_id) REFERENCES analyse (id);





