package ramesh.services.BankService;

import java.util.ArrayList;

public class AccountRepoImpl implements  AccountRepo{

    private static final AccountRepo repo = new AccountRepoImpl();
    private ArrayList<BaseAccount> accounts ;

    private AccountRepoImpl(){
        this.accounts = new  ArrayList<>();
    }


    @Override
    public BaseAccount findAccountById(String id) {
        try {
            return accounts.stream().filter(acc -> id.equals(acc.getId())).findFirst().get();
        }catch ( Exception e){
            return null;
        }
    }

    @Override
    public void addAccount(BaseAccount acc){
        accounts.add(acc );
    }

    @Override
    public ArrayList<BaseAccount> getAllAccounts(){
        return accounts;
    }


    public static AccountRepo getInstance() {
        return repo;
    }
}
