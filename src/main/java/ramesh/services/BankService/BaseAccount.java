package ramesh.services.BankService;



import ramesh.services.BankService.Exceptions.InsufficientBalance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseAccount {


    private String id;

    private double balance;

    @XmlTransient
    private String passcode;

    public BaseAccount(String id) {
        this.id = id;
        this.balance = 0.0;

        this.setPasscode(Integer.toString((int)(Math.random()*10000)));
    }


    public abstract double deposit(double amount);

    public abstract double withdraw(double amount) throws InsufficientBalance;

    public abstract double transfer( double amount , BaseAccount acc) throws InsufficientBalance;

    protected double add(double amount) {
       this.balance += amount  ;
       return amount ;
    }


    protected double sub(double amount) {
        this.balance -= amount  ;
        return amount ;


    }

    protected boolean validateBalance( double amount){
        if(this.getBalance() >= amount)  return true;
        return false;
    }

    public boolean validatePassCode(String code){
        return this.passcode.equals(code);
    }

    public double getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }


    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }
}
