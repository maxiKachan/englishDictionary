DROP TABLE IF EXISTS sp_words;

CREATE TABLE sp_words
(
    word_id SERIAL,
    word varchar(255) NOT NULL ,
    meaning_in_russian varchar(255) NOT NULL ,
    PRIMARY KEY (word_id)
);

INSERT INTO sp_words (word, meaning_in_russian)
VALUES ('go', 'идти'),
       ('do', 'делать'),
       ('say', 'сказать'),
       ('get', 'получать'),
       ('make', 'делать');