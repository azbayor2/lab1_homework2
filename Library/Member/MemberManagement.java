package Library.Member;

import Library.User.*;
import java.util.*;

interface LibraryMemberManagement{
    void addMember(User o, String user);
    void editMember(User o, User mod);
    void deleteMember(User o);
}

public class MemberManagement implements LibraryMemberManagement{
    private int memberCount=0;
    HashMap<Member, Integer> Members = new HashMap<Member, Integer>();

    public void addMember(User o, String user){
        Member newMember = new Member(o, user);
        if(Members.containsKey(newMember)){
            throw new Exception();
        }

        Members.put(newMember, memberCount);
        memberCount++;
    }

    public void deleteMember(User o){
        if(!Members.containsKey(o))
            throw new Exception();

        Members.remove(o);
    }

    public void editMember(User o, User mod){
        if(!Members.containsKey(o))
            throw new Exception();
        Member temp=null;
        int val=-1;
        for(Member cur: Members.keySet()){
            if(cur.equals(o)){
                temp = cur;
                val = Members.get(cur);
                break;
            }
        }
        if(temp==null){
            throw new Exception();
        }
        temp.editUser(mod);
        Members.remove(o);
        Members.put(temp, val);
    }
}