package Library.User;

public class User {
    protected String Name;
    protected String Birthdate;
    protected String Gender;
    protected String PhoneNumber;
    protected String Address;
    protected String PrivateID;
}

class UserBuilder{
    protected String Name="";
    protected String Birthdate="";
    protected String Gender="";
    protected String PhoneNumber="";
    protected String Address="";
    protected String PrivateID="";

    public UserBuilder name(String name){
        this.Name = name;
        return this;
    }

    public UserBuilder birthdate(String birthdate){
        this.Birthdate = birthdate;
        return this;
    }

    public UserBuilder gender(String gender){
        this.Gender = gender;
        return this;
    }

    public UserBuilder phonenumber(String phonenumber){
        this.PhoneNumber = phonenumber;
        return this;
    }

    public UserBuilder address(String address){
        this.Address = address;
        return this;
    }

    public UserBuilder privateid(String privateid){
        this.PrivateID = privateid;
        return this;
    }
}


