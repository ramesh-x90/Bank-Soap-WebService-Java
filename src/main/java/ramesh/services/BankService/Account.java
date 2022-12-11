package ramesh.services.BankService;




import ramesh.services.BankService.Exceptions.InsufficientBalance;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
class Account extends BaseAccount {

    private String firstName;

    private String lastName ;

    private String phoneNo ;

    private String address ;

    private String NIC;

    static int count =0;



    Account(String firstName , String lastName , String phoneNo , String address , String NIC){
        super(Integer.toString(count));
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.NIC = NIC;

        count++;
    }


    @Override
    public double deposit(double amount) {
        this.add(amount);
        System.out.println( amount + " is successfully deposited on account id: " + this.getId());
        return amount;
    }

    @Override
    public double withdraw(double amount) throws InsufficientBalance {
        if(!validateBalance(amount))
            throw new InsufficientBalance();
        this.sub(amount);
        System.out.println( amount + " is successfully withdrawn from account id: " + this.getId());


        return amount;
    }



    @Override
    public double transfer(  double amount , BaseAccount acc) throws InsufficientBalance {
        if(!validateBalance(amount))
            throw new InsufficientBalance();
        acc.add(this.sub(amount));
        System.out.println( amount + " of money successfully transferred  from account id: " + this.getId() + " to account id: " + acc.getId());
        return amount;

    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

}
