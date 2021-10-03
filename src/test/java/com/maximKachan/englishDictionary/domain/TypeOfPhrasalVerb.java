package com.maximKachan.englishDictionary.domain;

public enum TypeOfPhrasalVerb {
    INTRANSITIVE,               //непереходной без дополнения
    TRANSITIVE_WITH_ADD,        //переходной с дополнением
    TRANSITIVE_WITH_ADD_MIDDLE, //переходной с дополнением в передине
    TRANSITIVE_WITH_ADD_AFTER,  //переходной с дополнением в конце
    TRANSITIVE_WITH_TWICE_ADD   //переходной с дополнением в середине и конце
}
