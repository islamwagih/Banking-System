/**
 * a class that is the same as client class and other addition information and features
 * that manage a information about special clients which are commercial clients which may
 * be and organization or a company or else
 */
public class CommercialClient extends Client
{
    private String commercialID;

    /**
     * it constructs the information about this commercial client
     * @param name the name of the commercial client
     * @param address address of the commercial client
     * @param phone phone number of the commercial client
     * @param account the account of the commercial client in the bank's system
     */
    public CommercialClient(String name , String address , String phone , Account account)
    {
        super(name ,  "00000000000000", address , phone , account);
        commercialID = "Default";
    }

    /**
     * it sets a updates the commercial ID information for the commercial client in bank system
     * @param commercialID of the commercial client
     */
    public void setCommercialID(String commercialID) {
        this.commercialID = commercialID;
    }

    /**
     * it gives back the commercial ID of that commercial client
     * @return the commercial ID of the commercial client
     */
    public String getCommercialID() {
        return this.commercialID;
    }

    /**
     * it display all commercial client's information that found in the bank's system
     * @return all information of the commercial client found in the bank system
     */
    public String toString()
    {
        return "Client{name = " + this.getName() +", commercialID = "+commercialID+", address = " + this.getAddress() +", phone = "+ this.getPhone()+"}";

    }

}
