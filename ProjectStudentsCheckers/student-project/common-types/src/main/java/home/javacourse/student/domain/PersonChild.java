package home.javacourse.student.domain;

import java.io.Serializable;

/**
 * Created by Mozart on 10.03.2017.
 */
public class PersonChild  extends Person implements Serializable {
    String birthCertificate;

    public String getBirthCertificate() {
        return birthCertificate;
    }
    public void setBirthCertificate (String birthCertificate) {
        this.birthCertificate = birthCertificate;
    }
}
