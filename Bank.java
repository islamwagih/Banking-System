import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Islam Wagih Emam
 * This class is responsible for the integration between Clients and their Accounts.
 * It provides methods to simulate bank operations
 */
public class Bank
{
    private String name, address, phone;
    private ArrayList<Client> bankClients = new ArrayList<>();
    private ArrayList<Account> bankAccounts = new ArrayList<>();
    private HashSet<String> reservedAccounts = new HashSet<>();

    /**
     * Constructor to be provided with bank basic informations
     * @param name name of the bank
     * @param address address of the bank
     * @param phone phone of the bank
     */
    public Bank(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    /**
     * this method is implemented to know if a we have a client with the following accNum or not
     * @param accNum client account number
     * @return boolean value true if this we found this client, false otherwise
     */
    public boolean isClientExist(String accNum)
    {
        for(int i=0;i<bankClients.size();i++)
        {
            if(bankAccounts.get(i).getAccountNumber().equalsIgnoreCase(accNum))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * this method responsible for adding the client to our clients array, his account to accounts array
     * and the account number to the reserved accounts number set
     * @param client new client of the bank
     */
    public void addClient(Client client)
    {
        bankClients.add(client);
        bankAccounts.add(client.getAccount());
        reservedAccounts.add(client.getAccount().getAccountNumber());
    }

    /**
     * this method get corresponding client of the bank given his accNum
     * @param accNum account number of the desired client
     * @return client that has an account with the given accNum
     */
    public Client getClient(String accNum)
    {
        for(int i=0;i<bankAccounts.size();i++)
        {
            if(accNum.equalsIgnoreCase(bankAccounts.get(i).getAccountNumber()))
            {
                return bankClients.get(i);
            }
        }
        return null;
    }

    /**
     * this method iterate over all accounts of a bank to print them
     */
    public void displayAccounts()
    {
        for(int i=0;i<bankAccounts.size();i++)
        {
            System.out.print("Account Owner : "+bankClients.get(i).getName()+", ");
            System.out.println(bankAccounts.get(i));
        }
    }

    /**
     * this method iterate over all clients of a bank to print them
     */
    public void displayClients()
    {
        for(int i=0;i<bankClients.size();i++)
        {
            System.out.println(bankClients.get(i));
        }
    }

    /**
     * this method checks if there is any account have been created with the given accNum
     * @param accNum account number of a new or existing client
     * @return true if accNum is unique, false otherwise
     */
    public boolean isUniqueAccNumber(String accNum)
    {
        if(reservedAccounts.contains(accNum)) { return false; }
        return true;
    }

    /**
     * this method is responsible for transferring money between clients of the same bank
     * @param from account number of the client who want to transfer money
     * @param to account number of the client who will receive the money
     * @param amount amount of money to be transferred
     * @return true if the transfer has done successfully
     */
    public boolean transferMoney(String from, String to, double amount)
    {
        Client source = getClient(from);
        Client destination = getClient(to);
        if(source.getAccount().getBalance() >= amount){
            source.getAccount().withdraw(amount);
            destination.getAccount().deposit(amount);
            return true;
        }
        return false;
    }

    /**
     * set the name of a bank to a new name
     * @param name new name of the bank
     */
    public void setName(String name) { this.name = name; }

    /**
     * set the phone of a bank to a new phone
     * @param phone new phone of the bank
     */
    public void setPhone(String phone) { this.phone = phone; }

    /**
     * set the address of a bank to a new address
     * @param address new address of the bank
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * get the name of the bank
     * @return current name of the bank
     */
    public String getName() { return this.name; }

    /**
     * get the address of the bank
     * @return current address of the bank
     */
    public String getAddress() { return this.address; }

    /**
     * get phone number of the bank
     * @return current phone number of the bank
     */
    public String getPhone() { return this.phone; }
}
