DROP TABLE IF EXISTS sp_words;

CREATE TABLE sp_words
(
    word_id SERIAL,
    word varchar(255) NOT NULL ,
    meaning_in_russian varchar(255) NOT NULL ,
    PRIMARY KEY (word_id)
);