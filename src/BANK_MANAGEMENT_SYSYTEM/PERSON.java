package BANK_MANAGEMENT_SYSYTEM;

import java.io.Serializable;

public class PERSON implements Serializable
{
    public String name;
    private String CNIC;
    public String Phone_no;

    // Unparametrized constructor
    public PERSON()
    {
    }

    //Parametrized Constructor
    public PERSON(String name, String CNIC, String phone_no)
    {
        this.name = name;
        this.CNIC = CNIC;
        Phone_no = phone_no;
    }
//<...........Getters and Setters..........>
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getPhone_no() {
        return Phone_no;
    }

    public void setPhone_no(String phone_no) {
        Phone_no = phone_no;
    }

    // Making toString to print the object
    @Override
    public String toString()
    {
        return " is "+ name + "\n"+"The Client's CNIC is " + CNIC + "\n"+"The Client's phone number is "+  Phone_no;
    }
}

//
