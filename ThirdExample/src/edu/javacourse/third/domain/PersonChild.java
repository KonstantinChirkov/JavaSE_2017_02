package edu.javacourse.third.domain;

/**
 * Created by Mozart on 06.03.2017.
 */
public class PersonChild extends Person{
    public String getBirthDocument() {
        return birthDocument;
    }

    public void setBirthDocument(String birthDocument) {
        this.birthDocument = birthDocument;
    }

    private String birthDocument;

}
