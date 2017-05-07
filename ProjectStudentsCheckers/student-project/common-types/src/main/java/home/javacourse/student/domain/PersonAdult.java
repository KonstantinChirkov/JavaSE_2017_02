package home.javacourse.student.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mozart on 10.03.2017.
 */
public class PersonAdult extends Person implements Serializable {
    private String passportSeria;
    private String passportNumber;
    private Date passportDateIssue;
    private Date passportDateExpire;


    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Date getPassportDateIssue() {
        return passportDateIssue;
    }

    public void setPassportDateIssue(Date passportDateIssue) {
        this.passportDateIssue = passportDateIssue;
    }

    public Date getPassportDateExpire() {
        return passportDateExpire;
    }

    public void setPassportDateExpire(Date passportDateExpire) {
        this.passportDateExpire = passportDateExpire;
    }
}
