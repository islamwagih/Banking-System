/**
 * An Account Class to make the operations on accounts
 */
public class Account
{
    private String account_number;
    private Double balance;

    /**
     * The Constructor for the Account class
     * @param account_number The tracking account number for the client
     * @param balance the initial account money balance for the client
     */
    public Account(String account_number, Double balance)
    {
        this.account_number = account_number;
        this.balance = balance;
    }

    /**
     * Setting the "account_number" for the Account
     * @param account_number the tracking account number for the client
     */
    public void setAccountNumber(String account_number) {
        this.account_number = account_number;
    }

    /**
     * to know the account_number for the class
     * @return String specifying the Account "account_number"
     */
    public String getAccountNumber() {
        return account_number;
    }

    /**
     * Setting the "balance" for Account
     * @param balance the current money in the Account
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * to know the current money balance in the Account
     * @return Double Specifying the "balance"
     */
    public Double getBalance() { return balance; }

    /**
     * Overridden from Object class
     * to know a all information about the Account
     * @return String Specifying the attributes for the Account
     */
    @Override
    public String toString()
    {
        return "Account Details{" +
                "account_number=" + account_number +
                ", balance=" + balance + '}';
    }

    /**
     * Making a withdraw operation using this Account
     * after checking if there is a enough balance
     * @param val the money will be paid
     * @return Boolean indicating weather the operation is done or not
     */
    public Boolean withdraw (Double val)
    {
        if (val > this.balance)
        {
            return false;
        }

        else
        {
            this.balance -= val;
            return true;
        }
    }

    /**
     * Adding deposit for the current balance for the Account
     * @param val Double indicating the amount of money will be added
     */
    public void deposit(Double val){
        this.balance += val;
    }

}
