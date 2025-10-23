package main;
import user.User;

public class Main {
    public static void main(String[] args) {
        User u = new User("Alice", "mypassword");
        System.out.println("사용자 이름: " + u.getName());

        // 직접 접근 불가 (private 접근 제한)
        // System.out.println(u.password);

        // setter를 통한 변경
        u.setPassword("securePass123");
    }
}