package Library.User;
import java.util.*;

public class User {
    protected String Name;
    protected String Birthdate;
    protected String Gender;
    protected String PhoneNumber;
    protected String Address;
    protected String PrivateID;

    @Override
    public boolean equals(Object o){
        User oU = (User)o;
        if(this.Name == oU.Name && this.Birthdate==oU.Birthdate && this.PhoneNumber == oU.PhoneNumber
        && this.Address == oU.Address) return true;

        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.Name, this.Birthdate, this.PhoneNumber, this.Address);
    }
}