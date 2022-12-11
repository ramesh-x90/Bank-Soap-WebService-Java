package ramesh.services.BankService;

import java.util.ArrayList;

public interface AccountRepo {

    BaseAccount findAccountById(String id);

    void addAccount(BaseAccount acc);

    ArrayList<BaseAccount> getAllAccounts();
}
