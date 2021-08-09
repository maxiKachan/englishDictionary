DROP TABLE IF EXISTS ed_learners_dictionary_phrase;
DROP TABLE IF EXISTS ed_learners_dictionary_phrasal_verb;
DROP TABLE IF EXISTS ed_learners_dictionary_irregular_verb;
DROP TABLE IF EXISTS ed_learners_dictionary_word;
DROP TABLE IF EXISTS ed_learners;
DROP TABLE IF EXISTS ed_common_dictionary_phrase;
DROP TABLE IF EXISTS ed_common_dictionary_phrasal_verb;
DROP TABLE IF EXISTS ed_common_dictionary_irregular_verb;
DROP TABLE IF EXISTS ed_common_dictionary_word;

CREATE TABLE ed_common_dictionary_word
(
    word_id SERIAL ,
    word varchar (255) NOT NULL ,
    type_of_word varchar (255) NOT NULL ,
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
    phrasal_verb varchar (255) NOT NULL ,
    meaning_in_russian varchar (255) NOT NULL ,
    describe_phrasal_verb text ,
    using_phrasal_verb text ,
    PRIMARY KEY (phrasal_verb_id)
);

CREATE TABLE ed_common_dictionary_phrase
(
    phrase_id SERIAL ,
    phrase varchar (255) NOT NULL ,
    meaning_in_russian varchar (255) NOT NULL ,
    describe_phrase text ,
    using_phrase text ,
    PRIMARY KEY (phrase_id)
);

CREATE TABLE ed_learners
(
    learner_id SERIAL ,
    learner_name varchar (100) NOT NULL ,
    learner_surname varchar (100) NOT NULL ,
    learner_email varchar (255) NOT NULL ,
    learner_date_of_birth date NOT NULL ,
    PRIMARY KEY (learner_id)
);

CREATE TABLE ed_learners_dictionary_word
(
    dictionary_id BIGSERIAL ,
    learner_id integer NOT NULL ,
    word_id integer NOT NULL ,
    date_of_add date NOT NULL ,
    date_of_repeat date NOT NULL ,
    repeat_count integer NOT NULL ,
    success_repeat_count integer NOT NULL ,
    PRIMARY KEY (dictionary_id) ,
    FOREIGN KEY (learner_id) REFERENCES ed_learners (learner_id) ON DELETE RESTRICT ,
    FOREIGN KEY (word_id) REFERENCES ed_common_dictionary_word (word_id) ON DELETE RESTRICT
);

CREATE TABLE ed_learners_dictionary_irregular_verb
(
    dictionary_id BIGSERIAL ,
    learner_id integer NOT NULL ,
    irregular_verb_id integer NOT NULL ,
    date_of_add date NOT NULL ,
    date_of_repeat date NOT NULL ,
    repeat_count integer NOT NULL ,
    success_repeat_count integer NOT NULL ,
    PRIMARY KEY (dictionary_id) ,
    FOREIGN KEY (learner_id) REFERENCES ed_learners (learner_id) ON DELETE RESTRICT ,
    FOREIGN KEY (irregular_verb_id) REFERENCES ed_common_dictionary_irregular_verb (irregular_verb_id) ON DELETE RESTRICT
);

CREATE TABLE ed_learners_dictionary_phrasal_verb
(
    dictionary_id BIGSERIAL ,
    learner_id integer NOT NULL ,
    phrasal_verb_id integer NOT NULL ,
    date_of_add date NOT NULL ,
    date_of_repeat date NOT NULL ,
    repeat_count integer NOT NULL ,
    success_repeat_count integer NOT NULL ,
    PRIMARY KEY (dictionary_id) ,
    FOREIGN KEY (learner_id) REFERENCES ed_learners (learner_id) ON DELETE RESTRICT ,
    FOREIGN KEY (phrasal_verb_id) REFERENCES ed_common_dictionary_phrasal_verb (phrasal_verb_id) ON DELETE RESTRICT
);

CREATE TABLE ed_learners_dictionary_phrase
(
    dictionary_id BIGSERIAL ,
    learner_id integer NOT NULL ,
    phrase_id integer NOT NULL ,
    date_of_add date NOT NULL ,
    date_of_repeat date NOT NULL ,
    repeat_count integer NOT NULL ,
    success_repeat_count integer NOT NULL ,
    PRIMARY KEY (dictionary_id) ,
    FOREIGN KEY (learner_id) REFERENCES ed_learners (learner_id) ON DELETE RESTRICT ,
    FOREIGN KEY (phrase_id) REFERENCES ed_common_dictionary_phrase (phrase_id) ON DELETE RESTRICT
);

CREATE INDEX idx_learners_id_word ON ed_learners_dictionary_word(learner_id);
CREATE INDEX idx_learners_id_irregular_verb ON ed_learners_dictionary_irregular_verb(learner_id);
CREATE INDEX idx_learners_id_phrasal_verb ON ed_learners_dictionary_phrasal_verb(learner_id);
CREATE INDEX idx_learners_id_phrase ON ed_learners_dictionary_phrase(learner_id);