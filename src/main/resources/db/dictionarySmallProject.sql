DROP TABLE IF EXISTS sp_words;

CREATE TABLE sp_words
(
    word_id SERIAL,
    word varchar(255) NOT NULL ,
    type varchar(30) NOT NULL ,
    meaning varchar(255) NOT NULL ,
    PRIMARY KEY (word_id)
);

INSERT INTO sp_words (word, type, meaning)
VALUES ('go', 'VERB', 'идти'),
       ('do', 'VERB','делать'),
       ('say', 'VERB','сказать'),
       ('get', 'VERB','получать'),
       ('make', 'VERB','делать');