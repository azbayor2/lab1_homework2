package Library.User;
import Library.Exception.UserCreationShortArgsException;
import Library.Member.*;
import java.util.*;

public class User {
    protected String Name;  //필수
    protected String Birthdate;  //필수
    protected String Gender;
    protected String PhoneNumber;  //필수
    protected String Address;  //필수
    protected String PrivateID;

    @Override
    public boolean equals(Object o){
        if(o==null) return false;

        User oU=null;
        if(o instanceof User)
            oU = (User)o;
        else if(o instanceof Member){
            Member oo = (Member)o;
            oU = oo.getUser();

        }
        else{
            System.out.println("error: not compatible type");
        }
        if(this.Name.equals(oU.Name)&& this.Birthdate.equals(oU.Birthdate) && this.PhoneNumber.equals(oU.PhoneNumber)
        && this.Address.equals(oU.Address)) return true;

        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.Name, this.Birthdate, this.PhoneNumber, this.Address);
    }

    public User(User u){
        this.Name = u.Name;
        this.Birthdate = u.Birthdate;
        this.Gender = u.Gender;
        this.PhoneNumber = u.PhoneNumber;
        this.Address = u.Address;
        this.PrivateID = u.PrivateID;
    }

    public boolean CheckChangable(User u){
        if(this.Birthdate!=u.Birthdate) return false;
        return true;
    }

    public User(String Name, String Birthdate, String Gender, String PhoneNumber, String Address, String PrivateID){
        //필수조건 확인
        try{
            if(Name.equals("") || Birthdate.equals("") ||
                PhoneNumber.equals("") | Address.equals(""))
                throw new UserCreationShortArgsException();
            
            this.Name = Name;
            this.Birthdate = Birthdate;
            this.Gender = Gender;
            this.PhoneNumber = PhoneNumber;
            this.Address = Address;
            this.PrivateID = PrivateID;
        } catch(UserCreationShortArgsException e){
            System.out.println(e);
        }
    }
}