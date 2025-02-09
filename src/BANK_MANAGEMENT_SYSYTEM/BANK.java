package BANK_MANAGEMENT_SYSYTEM;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BANK implements Serializable
{
    public String name;


    private List<CLIENT> clientList = new ArrayList<>();
    private List<Accounts> Accountlist = new ArrayList<>();
    private List<Accounts> Accountholders_Array = new ArrayList<>();

    @Override
    public String toString()
    {
        return "BANK{" +
                "name='" + name + '\'' +
                ", clientList=" + clientList +
                ", Accountlist=" + Accountlist +
                '}';
    }

    public BANK() {
    }

    //    Parametrixed Constructor
    public BANK(String name)
    {
        this.name = name;

    }
    public void addclient_to_file() throws IOException
    {
        FileOutputStream fos=new FileOutputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BANK_MANAGEMENT_SYSYTEM\\Client.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(clientList);
        oos.close();
        fos.close();
    }

//    public void clientFile_to_arraylist() throws IOException, ClassNotFoundException {
//        FileInputStream fis=new FileInputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BANK_MANAGEMENT_SYSYTEM\\Client.txt");
//        ObjectInputStream ois=new ObjectInputStream(fis);
//        clientList=(ArrayList<CLIENT>) ois.readObject();
//
//
//        ois.close();
//        fis.close();
//
//    }
public void clientFile_to_arraylist() throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BANK_MANAGEMENT_SYSYTEM\\Client.txt");
    ObjectInputStream ois = new ObjectInputStream(fis);

    // Read the entire ArrayList from the file
    ArrayList<CLIENT> clientsFromFile = (ArrayList<CLIENT>) ois.readObject();

    // Iterate through the clients to find the maximum assigned ID
    int maxAssignedId = 0;
    for (CLIENT client : clientsFromFile) {
        if (client.getId() > maxAssignedId) {
            maxAssignedId = client.getId();
        }
    }

    // Update the Lastassigned_id to the max assigned ID + 1
    CLIENT.Lastassigned_id = maxAssignedId ;

    // Add all clients to your bank's clientList
    this.clientList.addAll(clientsFromFile);

    ois.close();
    fis.close();
}


    // Update the Lastassigned_id to the max assigned ID


    public void addaccount_to_file() throws IOException
    {
        FileOutputStream fos=new FileOutputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BANK_MANAGEMENT_SYSYTEM\\Accounts.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(Accountlist);
        oos.close();
        fos.close();
    }

    public void AccountFile_to_arraylist() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BANK_MANAGEMENT_SYSYTEM\\Accounts.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Accountlist=(ArrayList<Accounts>) ois.readObject();
        ois.close();
        fis.close();
    }
    public void JointAccountHolders_to_file() throws IOException
    {
        FileOutputStream fos=new FileOutputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BANK_MANAGEMENT_SYSYTEM\\JointAccountHolders.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(Accountholders_Array);
        oos.close();
        fos.close();
    }

    public void AccountHoldersFile_to_arraylist() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BANK_MANAGEMENT_SYSYTEM\\JointAccountHolders.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Accountholders_Array=(ArrayList<Accounts>) ois.readObject();
        ois.close();
        fis.close();
    }

    private boolean clientExists(String name, String CNIC) {
        for (CLIENT client : clientList) {
            if (client.getPerson_info().getName().equals(name) && client.getPerson_info().getCNIC().equals(CNIC)) {
                return true; // Client with the same name and CNIC already exists
            }
        }
        return false; // Client does not exist
    }
    //   Method to add client in a Bank
    public void addclient(PERSON person)
   {
        if (!clientExists(person.getName(),person.getCNIC())) {
            CLIENT client = new CLIENT(person);
            clientList.add(client);
            System.out.println("Cleint Added Successfully");
        }else {
            CLIENT client = new CLIENT(person);
            clientList.add(client);
            System.out.println("The person Already Exists");
        }
   }
//   Method to get client by id
    public CLIENT getclientByid(int id)
    {
        for (CLIENT client:clientList) {
            if (client.getId()==id)
            {
                return client;
            }
        }return null;
    }
//    METHOD TO CHECK IS THE ACCOUNT NUMBER ALREADY EXITS OR NOT
    public boolean accountNumberExists(int accountNumber) {
        // Check if an account with the same account number already exists
        for (Accounts account : Accountlist) {
            if (account.getNumber() == accountNumber) {
                return true; // Account with the same number already exists
            }
        }
        return false; // Account does not exist
    }
    //    Method to add account in a Bank
   public void addaccount(Accounts Ac)
    {
        Accountlist.add(Ac);
    }
    public void addAccount(int id, int amount, CLIENT c)
    {
        Accounts accounts = new Accounts(id,amount,c);
        if (!accountNumberExists(accounts.getNumber())) {
            Accountlist.add(accounts);
            c.addaccount(accounts);
            System.out.println("Account Added SuccessFully");

        }else {
            System.out.println("The Account Already Exists");
        }
    }
//    Method to search account in a Bank
    public Accounts searchAccount(int num)
    {
        for (Accounts account:Accountlist)
        {
            if (account.getNumber()==(num))
            {
                return account;
            }
        }return null;
    }

    public List<CLIENT> getClientList() {
        return clientList;
    }

    public void setClientList(List<CLIENT> clientList) {
        this.clientList = clientList;
    }

    public List<Accounts> getAccountlist() {
        return Accountlist;
    }

    public void setAccountlist(List<Accounts> accountlist) {
        Accountlist = accountlist;
    }

    private void updateClientFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\hp\\IdeaProjects\\BMS\\src\\BANK_MANAGEMENT_SYSYTEM\\Client.txt"))) {
            oos.writeObject(clientList);
            System.out.println("Client File Updated SuccessFully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //   Method to remove client in a Bank
    public Boolean removeClient (String id)
   {
        boolean removed = false;
       for (CLIENT client:clientList)
       {
           if (Integer.toString(client.getId()).equals(id));
           {
               clientList.remove(client);
               removed = true;
               updateClientFile();
               break;
           }

       }
       return removed;

   }
//     Method to Search the client details
   public CLIENT searchCustomerDetail(String cnic)
     {
         for (CLIENT client:clientList)
         {
             if (client.getPerson_info().getCNIC().equals(cnic))
             {
                 return client;
             }


         }return null;
     }
    public float totalAmount()
    {
        float total = 0;
        for (Accounts account : Accountlist)
        {
            total += account.getBalance();
        }
        return total;
    }

}
