package ramesh.services.BankService;

import ramesh.services.BankService.Exceptions.CantFindTheAccount;
import ramesh.services.BankService.Exceptions.InsufficientBalance;
import ramesh.services.BankService.Exceptions.InvalidInputValues;

import javax.jws.WebService;
import java.util.ArrayList;


@WebService(endpointInterface = "ramesh.services.BankService.BankService" ,
        serviceName = "BankService" , portName = "BankServicePort" )
public class BankServiceImp implements BankService {

    AccountRepo accRepo = AccountRepoImpl.getInstance();

    @Override
    public CreateAccountRes createAccount(String firstName , String lastName , String phoneNo , String address , String NIC )  throws InvalidInputValues {

        if(firstName.isEmpty())
            throw new InvalidInputValues("first name");
        if(lastName.isEmpty())
            throw new InvalidInputValues("last name");
        if(phoneNo.isEmpty())
            throw new InvalidInputValues("phone number");
        if(address.isEmpty())
            throw new InvalidInputValues("address");
        if(NIC.isEmpty())
            throw new InvalidInputValues("NIC number");
        BaseAccount acc = new Account(firstName , lastName , phoneNo , address , NIC);
        accRepo.addAccount(acc);
        System.out.printf("new account successfully created. Account id: %s passcode %s%n", acc.getId() , acc.getPasscode() );
        return new CreateAccountRes(acc , acc.getPasscode());
    }

    @Override
    public double checkAccountBalance(String accId , String passCode) throws CantFindTheAccount, InvalidInputValues {
        System.out.println(accId + " " + passCode);
        BaseAccount acc = getAuthUserAccountById(accId,passCode);

        return accRepo.findAccountById(acc.getId()).getBalance();


    }

    @Override
    public double depositMoney(String accId, String passCode, double amount) throws CantFindTheAccount, InvalidInputValues {
        BaseAccount acc = getAuthUserAccountById(accId,passCode);
        return acc.deposit(amount);
    }

    @Override
    public double withdrawMoney(String accId, String passCode, double amount) throws CantFindTheAccount, InvalidInputValues, InsufficientBalance {
        BaseAccount acc = getAuthUserAccountById(accId,passCode);
        return acc.withdraw(amount);
    }

    @Override
    public double transferMoney(String accId, String toAccId, String passCode, double amount) throws CantFindTheAccount, InvalidInputValues, InsufficientBalance {
        BaseAccount transferAcc = getAuthUserAccountById(accId,passCode);
        BaseAccount receiverAcc = findTheAccountById(toAccId);

        return transferAcc.transfer(amount,receiverAcc);
    }

    @Override
    public ArrayList<BaseAccount> getAccounts() {
        //needs to implement master auth
        return accRepo.getAllAccounts();
    }


    private BaseAccount getAuthUserAccountById(String accId , String passCode) throws InvalidInputValues, CantFindTheAccount {
        BaseAccount acc = findTheAccountById(accId);

        if (!acc.validatePassCode(passCode))
            throw new InvalidInputValues("passcode.....");

        return acc;
    }

    private BaseAccount findTheAccountById(String accId) throws CantFindTheAccount {
        BaseAccount acc = accRepo.findAccountById(accId);
        if(acc == null)
            throw new CantFindTheAccount();
        return acc;
    }


}
