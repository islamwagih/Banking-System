import java.util.Scanner;

/**
 * @author Islam Wagih Emam
 * this class is responsible for providing a sweet console run to a bank, to facilitate
 * all the operations that can be done on it
 */
public class Main
{

    public static void main(String[] args)
    {
        Bank bank = new Bank("Cairo International Bank", "9st Mohandesin", "+033577896");
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("Welcome to "+bank.getName()+", enter the corresponding number to the action you want");
            System.out.println("1 : Sign up with new Account");
            System.out.println("2 : Sign in with existing Account");
            System.out.println("3 : View all Clients");
            System.out.println("4 : View all Accounts");
            System.out.print("5 : Exit\n>>");
            byte command = scan.nextByte();
            if(command == 1)
            {
                ///Sign Up
                System.out.print("Do you want to create commercial Account, Respond with (Yes or No)\n>>");
                String comClient = scan.next();
                String name, address, phone, accNumber;
                double balance;
                System.out.println("Please fill the following information, space separated");
                System.out.print("Name Phone Address\n>>");
                name = scan.next();
                phone = scan.next();
                address = scan.nextLine();
                System.out.print("Do you want a special account, Respond with (Yes or No)\n>>");
                String specialAcc = scan.next();
                System.out.print("Please enter your account number\n>>");
                accNumber = scan.next();
                while(!bank.isUniqueAccNumber(accNumber))
                {
                    System.out.print("This account number is exist please choose a new one\n>>");
                    accNumber = scan.next();
                }
                System.out.print("Enter your initial Balance\n>>");
                balance = scan.nextInt();
                Client currClient;Account currAcc;
                if(specialAcc.equalsIgnoreCase("yes")) {
                    currAcc = new SpecialAccount(accNumber, balance);
                } else {
                    currAcc = new Account(accNumber, balance);
                }
                if(comClient.equalsIgnoreCase("yes")) {
                    //Commercial Client we need (name, address, phone)
                    currClient = new CommercialClient(name, address, phone, currAcc);
                } else {
                    ///normal Client same as above + nationalID
                    System.out.print("Enter National Id\n>>");
                    String natId = scan.next();
                    currClient = new Client(name, natId, address, phone, currAcc);
                }
                bank.addClient(currClient);

            }
            else if(command == 2)
            {
                ///sign in view acc details to deposit withdraw..etc
                System.out.print("Please enter your account number\n>>");
                String accNumber = scan.next();
                if(bank.isClientExist(accNumber))
                {

                    Client curr = bank.getClient(accNumber);
                    while(true) {
                        System.out.println("Enter corresponding number to do an action");
                        System.out.println("1 - Deposit");
                        System.out.println("2 - Withdraw");
                        System.out.println("3 - Transfer money");
                        System.out.println("4 - View account details");
                        System.out.print("5 - Back\n>>");
                        byte innerCommand = scan.nextByte();
                        if (innerCommand == 1) {
                            ///deposit
                            System.out.print("Enter how much to deposit\n>>");
                            double toDeposit = scan.nextDouble();
                            curr.getAccount().deposit(toDeposit);
                            System.out.println("=======================================================================================================");
                            System.out.println("Deposit completed your account info now");
                            System.out.println(curr.getAccount());
                            System.out.println("=======================================================================================================");
                        } else if (innerCommand == 2) {
                            ///withdraw
                            System.out.print("Enter how much to withdraw\n>>");
                            double toWith = scan.nextDouble();
                            System.out.println("=======================================================================================================");
                            if (curr.getAccount().withdraw(toWith)) {
                                System.out.println("Withdraw completed your account info now");
                            } else {
                                System.out.println("There is no enough money to withdraw");
                            }
                            System.out.println(curr.getAccount());
                            System.out.println("=======================================================================================================");
                        }else if(innerCommand == 3){
                            ///transferMoney
                            System.out.print("Please enter how much to transfer\n>>");
                            double amount = scan.nextDouble();
                            System.out.print("Please Enter account number to transfer the money to\n>>");
                            String toTrans = scan.next();
                            while(!bank.isClientExist(toTrans) && (!toTrans.equalsIgnoreCase("exit")))
                            {
                                System.out.print("Invalid account number, please enter the correct one or exit to back to your account\n>>");
                                toTrans = scan.next();
                            }
                            if(toTrans.equalsIgnoreCase("exit")){
                                continue;
                            }
                            boolean ans = bank.transferMoney(curr.getAccount().getAccountNumber(), toTrans, amount);
                            System.out.println("=======================================================================================================");
                            if(!ans){
                                System.out.println("Sorry, you don't have enough money to do the transfer your current balance = "+curr.getAccount().getBalance());
                            }else{
                                System.out.println("Transfer Completed to "+bank.getClient(toTrans).getName());
                            }
                            System.out.println("=======================================================================================================");
                        }else if(innerCommand == 4){
                            ///View acc
                            System.out.println("=======================================================================================================");
                            System.out.println(curr.getAccount());
                            System.out.println("=======================================================================================================");
                        }else{
                            break;
                        }
                    }
                }else{
                    System.out.println("=======================================================================================================");
                    System.out.println("We have no Clients with this account number");
                    System.out.println("=======================================================================================================");
                }
            }
            else if(command == 3)
            {
                ///bank clients
                System.out.println("=======================================================================================================");
                bank.displayClients();
                System.out.println("=======================================================================================================");
            }
            else if(command == 4)
            {
                ///bank accounts
                System.out.println("=======================================================================================================");
                bank.displayAccounts();
                System.out.println("=======================================================================================================");
            }
            else
            {
                ///exit the whole program
                System.out.println("We hope to see you again, bye");
                break;
            }
        }
    }
}
