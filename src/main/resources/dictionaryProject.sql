DROP TABLE IF EXISTS ed_common_dictionary_word;
DROP TABLE IF EXISTS ed_common_dictionary_irregular_verb;
DROP TABLE IF EXISTS ed_common_dictionary_phrasal_verb;

CREATE TABLE ed_common_dictionary_word
(
    word_id SERIAL ,
    word varchar (255) NOT NULL ,
    type_of_word integer NOT NULL ,
    meaning_in_russian_word_w varchar (255) NOT NULL ,
    describe_word text ,
    using_word text ,
    PRIMARY KEY (word_id)
);

CREATE TABLE ed_common_dictionary_irregular_verb
(
    irregular_verb_id SERIAL ,
    first_form varchar (255) NOT NULL ,
    second_form varchar(255) NOT NULL ,
    third_form varchar (255) NOT NULL ,
    meaning_in_russian_iv varchar (255) NOT NULL ,
    describe_irregular_verb text ,
    using_irregular_verb text ,
    PRIMARY KEY (irregular_verb_id)
);

CREATE TABLE ed_common_dictionary_phrasal_verb
(
    phrasal_verb_id SERIAL ,
    first_part varchar NOT NULL ,
    second_part varchar NOT NULL ,
    describe_phrasal_verb text ,
    using_phrasal_verb text ,
    PRIMARY KEY (phrasal_verb_id)
);