package Library.Member;

import Library.Exception.*;
import Library.User.*;
import java.util.*;


public class MemberManagement implements LibraryMemberManagement{
    List<Member> Members = new ArrayList<Member>();
    //HashMap<Member, Integer> Members = new HashMap<Member, Integer>();

    public void addMember(User o, String user){
        try{
            Member newMember = new Member(o, user);  //Member에서 방어적 복사 구현
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

    public MemberManagement(MemberManagement mm){
        this.Members = new ArrayList<>(mm.Members);
    }

    public MemberManagement(){}

    public void deleteMember(Member o, int loanCount){
        try{
            if(!Members.contains(o))
                throw new NoMemberException();

            if(loanCount>0) throw new UserCurrentlyHaveLoanException();

            Members.remove(o);
        } catch(NoMemberException e){
            System.out.println(e);
        } catch(UserCurrentlyHaveLoanException e){
            System.out.println("Cannot delete user: "+ e);
        }
    }

    public void editMember(Member o, User mod){
        try{
            if(!Members.contains(o))
                throw new NoMemberException();
            //int val=-1;
            
            o.editUser(mod);  //editUser 메서드에서 방어적 복사 구현
        } catch(NoMemberException e){
            System.out.println(e);
        }
    }

    public Member getMember(User o){
        try{
            int idx = Members.indexOf(o);
            if(idx==-1){
                throw new NoMemberException();
            }
            Member ret = new Member(Members.get(idx));  //방어적 복사

            return ret;
        } catch(NoMemberException e){
            System.out.println(e);
            return null;
        }
    }

}