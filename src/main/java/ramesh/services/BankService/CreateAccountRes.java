package ramesh.services.BankService;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

//@XmlAccessorType(XmlAccessType.FIELD)
public class CreateAccountRes {
    public BaseAccount acc;
    public String passCode;


    public CreateAccountRes(BaseAccount acc, String passCode) {
        this.acc = acc;
        this.passCode = passCode;
    }
}
