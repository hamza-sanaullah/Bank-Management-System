package BANK_MANAGEMENT_SYSYTEM;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Accounts implements Serializable
{
    private int number;
    private float Balance;
    static int count  =0;
    private CLIENT AccoutnHolder1;
    private CLIENT AccoutnHolder2;
    public List<CLIENT> Accountholders_Array = new ArrayList<>();
    private boolean JointAccount;


//   Unparametrized Constructor
    public Accounts()
    {
    }

//    Parametrized constructor
    public Accounts(int number, float Balance, CLIENT accoutnHolder1)
    {
        this.number = number;
        this.Balance = Balance;
        this.AccoutnHolder1 = accoutnHolder1;
        count++;

    }
    public Accounts(int number, float Balance, CLIENT accoutnHolder1,CLIENT accoutnHolder2)
    {
        this.number = number;
        this.Balance = Balance;
        this.AccoutnHolder1 = accoutnHolder1;
        this.AccoutnHolder2 = accoutnHolder2;
//        this.Accountholders_Array.add(accoutnHolder1);
//        this.Accountholders_Array.add(accoutnHolder2);
        if (!this.Accountholders_Array.contains(accoutnHolder1)) {
            this.Accountholders_Array.add(accoutnHolder1);
        }

        if (!this.Accountholders_Array.contains(accoutnHolder2)) {
            this.Accountholders_Array.add(accoutnHolder2);
        }
        this.JointAccount = true;

        count++;

    }

    public List<CLIENT> getAccountholders_Array() {
        return Accountholders_Array;
    }

    public void Addaccountholders(CLIENT client)
    {
        Accountholders_Array.add(client);
    }
//    Getters and Setters
    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public float getBalance()
    {
        return Balance;
    }

    public void setBalance(float Balance) {
        Balance = Balance;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Accounts.count = count;
    }
    public CLIENT getAccountHolders()
    {
        return AccoutnHolder1;
    }


    public void setAccountHolder(CLIENT accoutnholder) {
        AccoutnHolder1 = accoutnholder;
    }

    public boolean isJointAccount() {
        return this.Accountholders_Array.size()==2;
    }

    public void setJointAccount(boolean jointAccount) {
        JointAccount = jointAccount;
    }

    //MAKING ToString to print the object
    @Override
    public String toString()
    {
        return " is "+ number + "\n"+"The Client's Balance is " + Balance + "\n"+"The AccountHolder of the Account is "+  AccoutnHolder1;

    }
//Methods of withdraw and depositing
    public float withdraw(float Amount)
    {
        if (Amount>0 && Amount<this.Balance)
        {
            this.Balance-=Amount;
            return Amount;

        }return -1.0f;

    }
    public float deposit(float Amount)
    {
        if (Amount>0)
        {
            return this.Balance+=Amount;
        }
        return -1.0f;
    }
}
