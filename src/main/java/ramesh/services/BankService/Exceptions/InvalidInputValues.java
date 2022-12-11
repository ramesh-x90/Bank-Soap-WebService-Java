package ramesh.services.BankService.Exceptions;

public class InvalidInputValues extends Exception{
    public InvalidInputValues(String inputParam)
    {
        super(String.format("Incorrect %s..." , inputParam) );
    }
}
