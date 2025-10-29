package Library.Member;
import Library.Exception.DifferentUserInfoException;
import Library.User.*;

public class Member{
    private String username;
    private User user;

    public Member(User user, String username){
        this.user = new User(user); //방어적 복사
        this.username = username;
    }

    public void editUser(User o){
        try{
            if(user.CheckChangable(o))
                user = new User(o);
            else
                throw new DifferentUserInfoException();
            
            return;
        } catch(DifferentUserInfoException e){
            System.out.println(e);
        }
    }

    public Member(Member m){
        this.user= new User(m.user);  //방어적 복사
        this.username = m.username;
    }

    public User getUser(){
        return new User(user);  //방어적 복사
    }

    @Override
    public boolean equals(Object o){
        if(o==null) return false;

        User u = null;

        if(o instanceof Member){
            Member oo = (Member)o;
            u = oo.user;
        } else if(o instanceof User)
            u = (User)o;
        else{
            System.out.println("not compatible type: Member");
        }
        
        if(u==null){
            System.out.println("member: u is null");
        }
        if(this.user.equals(u)) return true;
        return false;
    }

    @Override
    public int hashCode(){
        return user.hashCode();
    }
}


