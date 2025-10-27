package Library.Member;

import Library.User.*;

public class Member{
    private String username;
    private User user;

    Member(User user, String username){
        this.user = user;
        this.username = username;
    }

    void editUser(User o){
        user = o;
        return;
    }

    @Override
    public boolean equals(Object o){
        if(this.user.equals(o)) return true;
        return false;
    }
}


