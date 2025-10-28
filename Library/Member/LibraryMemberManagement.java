package Library.Member;
import Library.User.*;

public interface LibraryMemberManagement{
    void addMember(User o, String user);
    void editMember(Member o, User mod);
    void deleteMember(Member o, int loanCount);
    Member getMember(User o);
}