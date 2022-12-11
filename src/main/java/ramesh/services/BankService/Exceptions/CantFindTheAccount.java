package ramesh.services.BankService.Exceptions;



public class CantFindTheAccount extends Exception{
    public CantFindTheAccount( String error ){
        super(String.format("No matching account is found with the given information %s")  + error);
    }

    public CantFindTheAccount(  ){
        super("No matching account is found with the given information");
    }
}
