package BANK_MANAGEMENT_SYSYTEM;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CLIENT implements Serializable
{
    public static int Lastassigned_id = 0;
    private int ID;
    PERSON Person_info;
    private List<Accounts> Acs_List = new ArrayList<>();
    static int count = 0;
//    Unparametrized Constructor
    public CLIENT()
    {
//        this.ID = ++Lastassigned_id;
    }
    //    Parametrized Constructor
    public CLIENT(PERSON Person_info)
    {
        this.Person_info = Person_info;
        this.ID = ++Lastassigned_id; // Generate a unique ID for the client

    }
//........<Making To string to print the object
    @Override
    public String toString() {
        return "Client ID: " + Lastassigned_id + ", Name: " + Person_info.getName();
    }
//    Getters and Setters
    public int getId() {return ID;}

    public void setId(int id) {this.ID = id;}

    public PERSON getPerson_info() {return Person_info;}

    public void setPerson_info(PERSON person)
    {
        this.Person_info = person;
        System.out.println("Person is Registered as a Client in the bank");
    }

    public List<Accounts> getAcs_List() {
        return Acs_List;
    }

    public void setAcs_List(List<Accounts> Acs_List)
    {
        this.Acs_List = Acs_List;
    }

//    public Accounts getAccountholder() {
//        return accountholder;
//    }
//
//    public void setAccountholder(Accounts accountholder) {
//        this.accountholder = accountholder;
//    }

    public static int getCount()
    {
        return count;
    }

    public static void setCount(int count)
    {
        CLIENT.count = count;
    }
//    Method to add Accounts in the Account list of the client
    public void addaccount(Accounts a)
    {
        Acs_List.add(a);

    }
//    Methods of Withdrawing anf Depositing
    public void withdraw(float amount ,String accountno)
    {
        for (Accounts account:Acs_List)
        {
            if (Integer.toString(account.getNumber()).equals(accountno))
            {
                float remainingamount = account.withdraw(amount);
                if (remainingamount>0)
                {
                    System.out.println("withdrawal successfull" + remainingamount);
                }else
                {
                    System.out.println("Withdrawal fails");
                }
            }
        }
    }
    public void deposit(float amount, String accountno)
    {
        for (Accounts account:Acs_List)
        {
            if (Integer.toString(account.getNumber()).equals(accountno))
            {
                float currentamount = account.deposit(amount);
                if (currentamount>0)
                {
                    System.out.println("Deposited successfull" + currentamount);
                }else
                {
                    System.out.println("Deposition fails");
                }
            }


        }

    }
//    Method to get the total amount in all the accounts of the client
    public float totalAmount()
    {
        float total = 0;
        for (Accounts account : Acs_List)
        {
            total += account.getBalance();
        }
        return total;
    }
}
