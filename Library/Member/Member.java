package Library.Member;

import Library.User.*;

public class Member{
    private int id;
    private int username;
    private User user;

    Member(User user, int id, int username){
        this.user = user;
        this.id = id;
        this.username = username;
    }
}


