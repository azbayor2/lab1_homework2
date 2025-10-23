package step5.user;

public class User {
    private String name;
    private String password;
    protected String id;
    protected String username;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // getter
    public String getName() { return name; }

    // setter
    public void setPassword(String pw) {
        if (pw == null || pw.length() < 8) {
            throw new IllegalArgumentException("비밀번호는 8자 이상이어야 합니다.");
        }
        this.password = pw;
    }
}

