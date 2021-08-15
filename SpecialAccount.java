/**
 * Extend from Account Class to have more abilities
 */
public class SpecialAccount extends Account
{

    /**
     * A Constructor for the SpecialAccount which extends from Account
     * @param account_number The tracking account number for the client
     * @param balance the initial account money balance for the client
     */
    public SpecialAccount(String account_number, Double balance)
    {
        super(account_number, balance);
    }

    /**
     * Overridden method from Class Account to allow the SpecialAccount to have a debt with a maximum -1000
     * @param val the money will be paid
     * @return Boolean indicating weather the operation done or not
     */
    @Override
    public Boolean withdraw(Double val)
    {
        if (getBalance() - val >= -1000)
        {
            setBalance(getBalance() - val);
            return true;
        }
        return false;
    }
}
