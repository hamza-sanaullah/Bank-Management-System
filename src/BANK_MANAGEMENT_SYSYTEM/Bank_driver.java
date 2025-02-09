package BANK_MANAGEMENT_SYSYTEM;

import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Bank_driver
{

//  static BANK global_bank = new BANK();

    public static void main(String[] args) throws IOException, ClassNotFoundException , EOFException
    {
        String art =
                "__________                __        _____                                                             __      _________               __                  \n" +
                        "\\______   \\_____    ____ |  | __   /     \\ _____    ____ _____     ____   ____   _____   ____   _____/  |_   /   _____/__.__. _______/  |_  ____   _____  \n" +
                        " |    |  _/\\__  \\  /    \\|  |/ /  /  \\ /  \\\\__  \\  /    \\\\__  \\   / ___\\_/ __ \\ /     \\_/ __ \\ /    \\   __\\  \\_____  <   |  |/  ___/\\   __\\/ __ \\ /     \\ \n" +
                        " |    |   \\ / __ \\|   |  \\    <  /    Y    \\/ __ \\|   |  \\/ __ \\_/ /_/  >  ___/|  Y Y  \\  ___/|   |  \\  |    /        \\___  |\\___ \\  |  | \\  ___/|  Y Y  \\\n" +
                        " |______  /(____  /___|  /__|_ \\ \\____|__  (____  /___|  (____  /\\___  / \\___  >__|_|  /\\___  >___|  /__|   /_______  / ____/____  > |__|  \\___  >__|_|  / \n" +
                        "        \\/      \\/     \\/     \\/         \\/     \\/     \\/     \\//_____/      \\/      \\/     \\/     \\/               \\/\\/         \\/            \\/      \\/ \n";
        System.out.println(art);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the name of your Bank");
        String name1 = scanner1.nextLine();
        BANK bank = new BANK(name1);
        String asciiArt =
                " __      __       .__                               \n" +
                        "/  \\    /  \\ ____ |  |   ____  ____   _____   ____  \n" +
                        "\\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\ \n" +
                        " \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/ \n" +
                        "  \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >\n" +
                        "       \\/       \\/          \\/            \\/     \\/ ";

        System.out.println(asciiArt);
        System.out.println("===================== WELCOME TO THE " + name1 +" " + "Bank" + "========================");
        bank.AccountFile_to_arraylist();
        bank.clientFile_to_arraylist();
        bank.AccountHoldersFile_to_arraylist();
        while (true)
        {
            System.out.println("What you want");

            System.out.println("""
                    1. Make Account
                    2. Joint Account
                    3. Check Balance
                    4. Withdraw Amount
                    5. Remove client
                    6. Search Account
                    7. Deposit Money
                    8. Show All clients
                    9. Show All Accounts
                    10.Info of Joint Account
                    11.Exit
                    """);
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if (choice.equals("1"))
            {
                System.out.println("Enter your Name");
                String name = scanner.next();
                System.out.println("Enter your CNIC");
                String CNIC = scanner.next();
                System.out.println("Enter your Phone No.");
                String Phone_no = scanner.next();
//            Todo Making person object
                PERSON person1 = new PERSON(name, CNIC, Phone_no);
//            Todo Making Client object
//                List<Accounts> accountsList = new ArrayList<>();
                CLIENT client1 = new CLIENT();
//            Todo Adding person to client list
                bank.addclient(person1);
//                bank.addclient_to_file();
//            Todo Setting Person in client class
                client1.setPerson_info(person1);
                System.out.println("Enter the Account number For your Account");
                int Numer = scanner.nextInt();
                System.out.println("Enter the initial balance");
                System.out.println("Please Enter the balance in Float");
                float bal =(int) scanner.nextFloat();
//            Todo Making Account Object
                Accounts ac = new Accounts(Numer, bal, client1);
                ac.setAccountHolder(client1);
                bank.addaccount(ac);
                client1.addaccount(ac);
//                bank.addaccount_to_file();
                System.out.println(" Account created successfully");
                String asciiArt1=
                        "___________.__             _________ .__  .__               __ /\\           _____                                   __    .___        _____                      __  .__                .__       /\\/\\ \n" +
                                "\\__    ___/|  |__   ____   \\_   ___ \\|  | |__| ____   _____/  |)/ ______   /  _  \\   ____  ____  ____  __ __  _____/  |_  |   | _____/ ____\\____   _____ _____ _/ |_ __| ____   ____   |__| _____)/)/ \n" +
                                "  |    |   |  |  \\_/ __ \\  /    \\  \\/|  | |  |/ __ \\ /    \\   __\\/  ___/  /  /_\\  \\_/ ___\\/ ___\\/  _ \\|  |  \\/    \\   __\\ |   |/    \\   __\\/  _ \\ /     \\\\__  \\\\   __\\  |/  _ \\ /    \\  |  |/  ___/   \n" +
                                "  |    |   |   Y  \\  ___/  \\     \\___|  |_|  \\  ___/|   |  \\  |  \\___ \\  /    |    \\  \\__\\  \\__(  <_> )  |  /   |  \\  |   |   |   |  \\  | (  <_> )  Y Y  \\/ __ \\|  | |  (  <_> )   |  \\ |  |\\___ \\     \n" +
                                "  |____|   |___|  /\\___  >  \\______  /____/__|\\___  >___|  /__| /____  > \\____|__  /\\___  >___  >____/|____/|___|  /__|   |___|___|  /__|  \\____/|__|_|  (____  /__| |__|\\____/|___|  / |__/____  >   \n" +
                                "                \\/     \\/          \\/             \\/     \\/          \\/          \\/     \\/    \\/                 \\/                \\/                  \\/     \\/                    \\/          \\/     ";

                System.out.println(asciiArt1);
                System.out.println("The Client's Account Number is " + ac.getNumber());
                System.out.println("The Client's Account Initail Balance is " + ac.getBalance());
                System.out.println("The Account Holder's ID  is " + ac.getAccountHolders().toString());
//
            } else if (choice.equals("2"))
            {
                System.out.println("Choose an option:");
                System.out.println("1. Joint with an existing client");
                System.out.println("2. Joint two new clients");
                int jointOption = scanner.nextInt();
                if (jointOption == 1)
                {
                    // Option 1: Joint with an existing client
                    System.out.println("Enter the Id of the client with which you want to make a joint account: ");
                    int firstClientId = scanner.nextInt();
                    System.out.println("Enter the Account Number: ");
                    int accountNumber = scanner.nextInt();

                    CLIENT client = bank.getclientByid(firstClientId);
                    Accounts accounts = bank.searchAccount(accountNumber);

                    if (client != null && accounts != null)
                    {
                        // Existing client and account found, proceed with joint account creation
                        System.out.println("Enter the name of the second account holder: ");
                        String name = scanner.nextLine();
                        PERSON secondPerson = new PERSON(name, "", "");
                        CLIENT secondClient = new CLIENT(secondPerson);
                        bank.addclient(secondPerson);
                        bank.addclient_to_file();


                        Accounts jointAccount = new Accounts(accountNumber, 0, secondClient);
                        jointAccount.setAccountHolder(secondClient);
                        secondClient.addaccount(jointAccount);
                        System.out.println("Joint Account Created Successfully");
                    } else
                    {
                        System.out.println("Client and Account Not Found");
                    }
                } else if (jointOption == 2)
                {
                    // Option 2: Joint two new clients
                    // Code to create a joint account between two new clients
                    System.out.println("Enter the name of the first account holder: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter the name of the second account holder: ");
                    String secondName = scanner.nextLine();

                    // Create two new PERSON objects and two new CLIENT objects
                    PERSON firstPerson = new PERSON(firstName, "", "");
                    PERSON secondPerson = new PERSON(secondName, "", "");

                    CLIENT firstClient = new CLIENT(firstPerson);
                    CLIENT secondClient = new CLIENT(secondPerson);

                    bank.addclient(firstPerson);
                    bank.addclient_to_file();
                    bank.JointAccountHolders_to_file();
                    bank.addclient(secondPerson);
                    bank.addclient_to_file();
                    bank.JointAccountHolders_to_file();


                    // Create a new joint account between the two new clients
                    System.out.println("Enter the Account Number: ");
                    int accountNumber = scanner.nextInt();
                    Accounts jointAccount = new Accounts(accountNumber, 0, firstClient, secondClient);
                    firstClient.addaccount(jointAccount);
                    secondClient.addaccount(jointAccount);
                    bank.addaccount(jointAccount);
                    bank.addaccount_to_file();

                    System.out.println("Joint Account Created Successfully");
                } else
                {
                    System.out.println("Invalid option");
                }
            } else if (choice.equals("3"))
            {
                System.out.println("Enter the Account Number to check the balance:");
                int accountNumber = scanner.nextInt();
                Accounts account = bank.searchAccount(accountNumber);
                if (account != null)
                {
                    System.out.println("Account Balance: " + account.getBalance());
                } else
                {
                    System.out.println("Account not found.");
                }

            } else if (choice.equals("4"))
            {
                System.out.println("Enter the Account Number to withdraw from:");
                int accountNumber = scanner.nextInt();
                Accounts account = bank.searchAccount(accountNumber);
                if (account != null)
                {
                    System.out.println("Enter the amount to withdraw:");
                    float amount = scanner.nextFloat();
                    float remainingAmount = account.withdraw(amount);
                    if (remainingAmount >= 0)
                    {
                        System.out.println("Withdrawal successful. Remaining balance: " + remainingAmount);
                    } else
                    {
                        System.out.println("Withdrawal failed. Insufficient balance.");
                    }
                } else
                {
                    System.out.println("Account not found.");
                }
            } else if (choice.equals("5"))
            {
                System.out.println("Enter the Client ID to remove:");
                int clientID = scanner.nextInt();
                if (bank.removeClient(Integer.toString(clientID)))
                {
                    System.out.println("Client removed successfully.");
                } else {
                    System.out.println("Client not found.");
                }
            } else if (choice.equals("6"))
            {
                System.out.println("Enter the Account Number to search:");
                int accountNumber = scanner.nextInt();
                Accounts account = bank.searchAccount(accountNumber);
                if (account != null)
                {
                    System.out.println("Account found. Holder: " + account.getAccountHolders().getPerson_info().getName());
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice.equals("7"))
            {
                System.out.println("Enter the Account Number to Deposit Money:");
                int accountNumber = scanner.nextInt();
                Accounts account = bank.searchAccount(accountNumber);
                if (account != null)
                {
                    System.out.println("Enter the amount to Deposit:");
                    float amount = scanner.nextFloat();
                    float TotalAmount = account.deposit(amount);
                    if (TotalAmount >= 0)
                    {
                        System.out.println("Deposit successful. Remaining balance: " + TotalAmount);
                    } else
                    {
                        System.out.println("Deposit failed. Insufficient balance.");
                    }
                } else
                {
                    System.out.println("Account not found.");
                }
            } else if (choice.equals("8"))
            {
                System.out.println("Clients in the bank:");
//                System.out.println("There is no Client in the Bank Yet");
                for (CLIENT client : bank.getClientList())
                {
                    System.out.println("Client ID: " + client.getId() + ", Name: " + client.getPerson_info().getName());
                }
            }

//                System.out.println("Accounts in the bank:");
//                for (Accounts account : bank.getAccountlist())
//                {
//                    System.out.println("Account Number: " + account.getNumber() + ", Balance: " + account.getBalance());
//                }
             else if (choice.equals("9"))
             {
//                 System.out.println("Enter the Client ID to show all accounts:");
//                 int clientIdToSearch = scanner.nextInt();
//
//                 CLIENT client = bank.getclientByid(clientIdToSearch);
//
//                 if (client != null) {
//                     System.out.println("Client ID: " + client.getId() + ", Name: " + client.getPerson_info().getName());
//                     System.out.println("Accounts:");
//                         System.out.println(client.getAcs_List().size());
                     for (Accounts account : bank.getAccountlist()) {
                         System.out.println("Account Number: " + account.getNumber() + ", Balance: " + account.getBalance());
                     }
//                 } else {
//                     System.out.println("Client not found.");
//                 }

             }
            else if (choice.equals("10"))
            {
                System.out.println("Joint Accounts and Their Holders:");
                for (Accounts account : bank.getAccountlist())
                {
                    if (account.isJointAccount())
                    {
                        System.out.println("Account Number: " + account.getNumber());
                        System.out.println("Holders:");
                        for (CLIENT client : account.getAccountholders_Array())
                        {
                            System.out.println("Client ID: " + client.getId() + ", Name: " + client.getPerson_info().getName());
                        }
                        System.out.println();
                    }
                }
            } else if (choice.equals("11"))
            {
                break;
            }
            bank.addclient_to_file();
            bank.addaccount_to_file();
            bank.JointAccountHolders_to_file();
        }
    }
}




