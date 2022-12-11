package ramesh.services.BankService.Exceptions;

public class InsufficientBalance extends Exception{
    public InsufficientBalance()
    {
        super("Targeted account doesn't have sufficient balance to perform the operation");
    }

    public InsufficientBalance(String error)
    {
        super(String.format("Targeted account doesn't have sufficient balance to perform the operation. %s" , error) );
    }
}
