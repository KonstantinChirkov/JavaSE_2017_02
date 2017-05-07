package edu.javacourse.thirdhome.domain;

/**
 * Created by Mozart on 10.03.2017.
 */
public class PersonChild  extends Person{
    String birthCertificate;

    public String getBirthCertificate() {
        return birthCertificate;
    }
    public void setBirthCertificate (String birthCertificate) {
        this.birthCertificate = birthCertificate;
    }
}
