package ramesh.services.BankService;

import ramesh.services.BankService.Exceptions.CantFindTheAccount;
import ramesh.services.BankService.Exceptions.InsufficientBalance;
import ramesh.services.BankService.Exceptions.InvalidInputValues;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;

@WebService
@SOAPBinding( style = SOAPBinding.Style.DOCUMENT)
@XmlSeeAlso({Account.class , CreateAccountRes.class})
public interface BankService {

    @WebMethod()
    CreateAccountRes createAccount(@WebParam(name = "firstName") String firstName,
                                   @WebParam(name = "lastName") String lastName,
                                   @WebParam(name = "phoneNo") String phoneNo,
                                   @WebParam(name = "address") String address,
                                   @WebParam(name = "NIC") String NID) throws InvalidInputValues;

    @WebMethod()
    double checkAccountBalance(
            @WebParam(name = "accountId") String accId ,
            @WebParam(name = "passCode") String passCode) throws CantFindTheAccount, InvalidInputValues;

    @WebMethod()
    double depositMoney(
            @WebParam(name = "accountId") String accId ,
            @WebParam(name = "passCode") String passCode ,
            @WebParam(name = "depositAmount") double amount) throws CantFindTheAccount, InvalidInputValues;


    @WebMethod()
    double withdrawMoney(
            @WebParam(name = "accountId") String accId ,
            @WebParam(name = "passCode") String passCode ,
            @WebParam(name = "withdrawAmount") double amount) throws CantFindTheAccount, InvalidInputValues, InsufficientBalance;

    @WebMethod()
    double transferMoney(
            @WebParam(name = "transferAccountId") String accId ,
            @WebParam(name = "receiverAccountId") String toAccId ,
            @WebParam(name = "passCode") String passCode ,
            @WebParam(name = "transferAmount") double amount) throws CantFindTheAccount, InvalidInputValues, InsufficientBalance;

    @WebMethod
    ArrayList< BaseAccount> getAccounts();





}
