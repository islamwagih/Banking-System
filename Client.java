/**
 * a class in a bank system that manage the features and information about clients in
 * the system
 */
public class Client
{

    private String name, nationalID, address, phone;
    private Account account;

    /**
     * it constructs the client's information to be assigned in a bank system
     * @param name name of the client
     * @param nationalID national ID of the client
     * @param address address of the client
     * @param phone phone number of the client
     * @param account account of the client in the bank system
     */
    public Client(String name, String nationalID, String address, String phone, Account account)
    {
        this.name = name;
        this.nationalID = nationalID;
        this.address = address;
        this.phone = phone;
        this.account = account;
    }

    /**
     * it assign the client's name
     * @param name set the name of the client
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * it gives back the name of the client
     * @return the client's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * it assign the client's national ID
     * @param nationalID assign to the client his or her own national ID
     */
    public void setNationalID(String nationalID){
        this.nationalID = nationalID;
    }

    /**
     * it gives back the national ID of the client
     * @return the client's national ID
     */
    public String getNationalID(){
        return this.nationalID;
    }

    /**
     * it assign the address of the client's in his own information in the bank's system
     * @param address assign to the client his or her own address
     */
    public void setAddress(String address){
        this.address=address;
    }

    /**
     * it gives back the address of the client
     * @return the client's address
     */
    public String getAddress(){
        return this.address;
    }

    /**
     * it assign the client's phone number in client's information
     * @param phone number is assigned to the client's information
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * it gives back the client's phone number
     * @return the client's phone number
     */
    public String getPhone(){
        return this.phone;
    }

    /**
     * it sets an account to the client
     * @param account is assigned to the client
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * it gives back the account of the client
     * @return the account of the client
     */
    public Account getAccount(){
        return this.account;
    }

    /**
     * it display all client's information that found in the bank's system
     * @return all information of the client in the bank system
     */
    @Override
    public String toString()
    {
        return "Client{name = " + name +", NationalID = "+nationalID + ", address = " + address +", phone = "+ phone + "}";

    }

}
