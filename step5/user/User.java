package user;

public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // getter
    protected String getName() { return name; }

    // setter
    protected void setPassword(String pw) {
        if (pw == null || pw.length() < 8) {
            throw new IllegalArgumentException("비밀번호는 8자 이상이어야 합니다.");
        }
        this.password = pw;
    }
}

