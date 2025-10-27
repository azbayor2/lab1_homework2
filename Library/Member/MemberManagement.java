package Library.Member;

import Library.Exception.*;
import Library.User.*;
import java.util.*;

interface LibraryMemberManagement{
    void addMember(User o, String user);
    void editMember(Member o, User mod);
    void deleteMember(Member o);
}

public class MemberManagement implements LibraryMemberManagement{
    List<Member> Members = new ArrayList<>();
    //HashMap<Member, Integer> Members = new HashMap<Member, Integer>();

    public void addMember(User o, String user){
        try{
            Member newMember = new Member(o, user);
            if(Members.contains(newMember)){
                throw new MemberAlreadyExistsException();
            }

            Members.add(newMember);
            //memberCount++;
        } catch(MemberAlreadyExistsException e){
            System.out.println(e);
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void deleteMember(Member o){
        try{
            if(!Members.contains(o))
                throw new NoMemberException();

            Members.remove(o);
        } catch(NoMemberException e){
            System.out.println(e);
        }
    }

    public void editMember(Member o, User mod){
        try{
            if(!Members.contains(o))
                throw new NoMemberException();
            //int val=-1;
            
            o.editUser(mod);
        } catch(NoMemberException e){
            System.out.println(e);
        }
    }

}