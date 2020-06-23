
INSERT INTO SERVICE VALUES (1, 'PS LILLE', '123 rue des postes', '59000', 'LILLE');
INSERT INTO SERVICE VALUES (2, 'PS MARSEILLE', '32 av des Catanes', '13001', 'MARSEILLE');
INSERT INTO SERVICE VALUES (3, 'DADR LENS', '69, rue Massena', '62000', 'LENS');
INSERT INTO SERVICE VALUES (4, 'TGI DOUAI', '12 boulevard du Barlet', '59100', 'DOUAI');
INSERT INTO SERVICE VALUES (5, 'Commissariat de Wattignies', '85, rue de la Marne', '59139', 'WATTIGNIES');
INSERT INTO SERVICE VALUES (6, 'PS LYON', '1, place Part-Dieu', '69001', 'LYON');
INSERT INTO SERVICE VALUES (7, 'PS Toulouse', '44, quai de l espelette', '31000', 'TOULOUSE');


INSERT INTO REQUERANT VALUES (1,'Lieutenant', 'Jean-Pierre','De Smedt', 'jean-pierre.desmedt@mail.com', 1);
INSERT INTO REQUERANT VALUES (2,'Brigadier', 'Chantal','Vanhaert', 'chantal.vanhaert@mail.com', 2);
INSERT INTO REQUERANT VALUES (3,'Juge', 'Maurice','Van Dijck', 'maurice.vandijck@mail.com', 3);
INSERT INTO REQUERANT VALUES (4,'Gendarme', 'Valérie','Vandenbroeck', 'valerie.vandenbroeck@mail.com', 3);
INSERT INTO REQUERANT VALUES (5,'Gendarme', 'Christophe','Niels', 'christophe.niels@mail.com', 4);
INSERT INTO REQUERANT VALUES (6,'Commissaire', 'Rachid','Cohen', 'rachid.cohen@mail.com', 4);
INSERT INTO REQUERANT VALUES (7,'Lieutenant', 'Vincent','Den briek', 'vincent.denbriek@mail.com', 5);
INSERT INTO REQUERANT VALUES (8,'Brigadier-Chef', 'Anne-Sophie','De Bruyn', 'anne-sophie.debruyn@mail.com', 6);
INSERT INTO REQUERANT VALUES (9,'Sous-Chef', 'Evelyne','Van Dongen', 'evelyne.vandongen@mail.com', 7);
INSERT INTO REQUERANT VALUES (10,'Lieutenant', 'Guillaume','De Gendt', 'guillaume.degendt@mail.com', 7);

INSERT INTO SECTION VALUES (1, 'Toxicologie', '10', 'Une section de branquignols', true);
INSERT INTO SECTION VALUES (2, 'Biologie', '20', 'Une autre section de branquignols', true);
INSERT INTO SECTION VALUES (3, 'Physique-Chimie', '30', 'Existe encore ?', true);
INSERT INTO SECTION VALUES (4, 'Balistique', '40', 'Ne pas irriter car dangereux', true);
INSERT INTO SECTION VALUES (5, 'Pluridisciplinaire', '50', 'Font tout et rien', true);
INSERT INTO SECTION VALUES (6, 'Incendie', '60', null, true);

INSERT INTO ANALYSE VALUES (1, 'Recherche Alcoolémie SR', null, 59.90, 1);
INSERT INTO ANALYSE VALUES (2, 'Recherche toxycologie SR', null, 99.99, 1);
INSERT INTO ANALYSE VALUES (3, 'Recherche traces', null, 128.00, 2);
INSERT INTO ANALYSE VALUES (4, 'Recherche individu', null, 99.00, 2);
INSERT INTO ANALYSE VALUES (5, 'Recherche composition', null, 249.99, 3);
INSERT INTO ANALYSE VALUES (6, 'Examen arme et munitions', null, 229.00, 4);
INSERT INTO ANALYSE VALUES (7, 'Comparatif munitions', null, 79.50, 4);
INSERT INTO ANALYSE VALUES (8, 'Releve empreinte digitale', null, 99.50, 5);
INSERT INTO ANALYSE VALUES (9, 'Comparatif écriture', null, 249.90, 5);
INSERT INTO ANALYSE VALUES (10, 'Examen incendies (Déplacement)', null, 99.00, 6);
INSERT INTO ANALYSE VALUES (11, 'Examen incendies (sur photos)', null, 59.00, 6);

INSERT INTO DEMANDE VALUES (1, 'LPS59-2020-00001', '2020-02-16', 1);
INSERT INTO DEMANDE VALUES (2, 'LPS59-2020-00002', '2020-03-05', 2);
INSERT INTO DEMANDE VALUES (3, 'LPS59-2020-00003', '2020-04-20', 3);
INSERT INTO DEMANDE VALUES (4, 'LPS59-2020-00004', '2020-05-06', 4);

INSERT INTO ITEM_DEMANDE VALUES (1, 'CREATED', 1, 1, 1);
INSERT INTO ITEM_DEMANDE VALUES (2, 'CREATED', 2, 1, 2);
INSERT INTO ITEM_DEMANDE VALUES (3, 'CREATED', 1, 2, 1);
INSERT INTO ITEM_DEMANDE VALUES (4, 'CREATED', 2, 2, 2);
INSERT INTO ITEM_DEMANDE VALUES (5, 'CREATED', 1, 3, 3);
INSERT INTO ITEM_DEMANDE VALUES (6, 'CREATED', 2, 3, 8);
INSERT INTO ITEM_DEMANDE VALUES (7, 'CREATED', 3, 3, 6);
INSERT INTO ITEM_DEMANDE VALUES (8, 'CREATED', 1, 4, 10);
INSERT INTO ITEM_DEMANDE VALUES (9, 'CREATED', 2, 4, 5);
INSERT INTO ITEM_DEMANDE VALUES (10, 'CREATED', 3, 4, 4);

INSERT INTO AFFAIRE VALUES (1, '12345/20', null);
INSERT INTO AFFAIRE VALUES (2, '4568/2020', 'Meutre sur le petit Grégorie');
INSERT INTO AFFAIRE VALUES (3, '2020/78966', null);
INSERT INTO AFFAIRE VALUES (4, '2020/456', null);

INSERT INTO DEMANDE_AFFAIRE VALUES (1,1);
INSERT INTO DEMANDE_AFFAIRE VALUES (2,2);
INSERT INTO DEMANDE_AFFAIRE VALUES (3,3);
INSERT INTO DEMANDE_AFFAIRE VALUES (4,4);






