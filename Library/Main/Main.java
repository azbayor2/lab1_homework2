package Library.Main;
import Library.Book.*;
import Library.Library.*;
import Library.Loan.*;
import Library.User.*;
import Library.Member.*;
import Library.Member.MemberManagement;


public class Main {
    public static void main(String [] args){
        Library lb = new Library(new BookManagement(), new LoanManagement(new LoanPolicy(2)), new MemberManagement());

        //3명의 user 생성
        User A = new UserBuilder().name("한정연").birthdate("20020826")
                    .phonenumber("123456879").address("Addr1").build();

        User B = new UserBuilder().name("강현서").birthdate("20030826")
                    .phonenumber("123456897").address("Addr2").build();

        User C = new UserBuilder().name("권건우").birthdate("20020820")
                    .phonenumber("789132456").address("Addr3").build();

        //중복되는 User 생성
        User A_2 = new UserBuilder().name("한정연").birthdate("20020826")
                    .phonenumber("123456879").address("Addr1").build();


        //도서관에 사용자 추가하기
        System.out.println("사용자 A, B, C 추가");
        lb.addUser(A, "azbayor2");
        lb.addUser(B, "hyunsoo");
        lb.addUser(C, "kwonCar");
        System.out.println();

        //중복 사용자 추가 시도
        System.out.print("예외1. 중복사용자 추가 시도: ");
        lb.addUser(A_2, "azbayor3");  //Exception 발생 1
        System.out.println();


        //책 생성
        Book b1 = new Book("Harry Potter", "JK R", "pb1");
        Book b2 = new Book("Lord of the Ring", "JRR", "pb2");
        Book b3 = new Book("Percy Jackson", "R R", "pb3");

        //책 추가
        System.out.println("Harry Potter, Lord of the Ring, Percy Jackson 입고");
        lb.addBook(b1, 2, BookCategory.Fiction);
        lb.addBook(b2, 5, BookCategory.Fantasy);
        lb.addBook(b3, 3, BookCategory.Travel);
        System.out.println();


        //없는 책 검색하기
        System.out.print("예외2. 없는 책 검색하기: ");
        LibraryBook searchedBook = lb.searchBook("Twilight", "S M", "pb4"); //Exception 발생 2
        System.out.println();
        LibraryBook searchedBook2 = null;
        LibraryBook searchedBook3 = null;

        //있는 책 검색하기
        System.out.println("있는 책 검색하기");
        searchedBook = lb.searchBook("Harry Potter", "JK R", "pb1");
        searchedBook2 = lb.searchBook("Lord of the Ring", "JRR", "pb2");
        searchedBook3 = lb.searchBook("Percy Jackson", "R R", "pb3");
        System.out.println();

        User D = new UserBuilder().name("강한결").address("addr5")
            .birthdate("20040505").phonenumber("789456123").build();

        //없는 사용자 검색하기
        System.out.print("예외3. 없는 사용자 검색하기: ");
        Member mem = lb.findUser(D); //예외 발생 3
        System.out.println();

        //있는 사용자 검색하기
        System.out.println("사용자 A 검색하기");
        mem = lb.findUser(A);
        //if(mem==null) System.out.println("mem is null");
        System.out.println();

        //User A로 검색한 책 대여하기
        System.out.println("User A가 Harry Potter 대여하기");
        lb.LoanBook(mem, searchedBook);
        System.out.println();

        //이미 대여한 책 대여하기
        System.out.print("예외4. User A 가 이미 대여한 책 대여하기");
        lb.LoanBook(mem, searchedBook); //예외 발생 4
        System.out.println();

        //User B로 검색한 책 대여하기
        System.out.println("User B가 Harry Potter 대여하기");
        lb.LoanBook(lb.findUser(B), searchedBook);
        System.out.println();

        //User C 로 검색한 책 대여하기 (한도 초과)
        System.out.print("예외5. User C가 전부 소진된 책 대여하기: ");
        lb.LoanBook(lb.findUser(C), searchedBook); //예외 발생 5 
        System.out.println();

        //User A 빌리지 않은 책 반납하기
        System.out.print("예외6. User A가 빌리지 않은 책 반납하기");
        lb.ReturnBook(lb.findUser(A), searchedBook2); //예외 발생 6
        System.out.println();

        //User A 빌린 책 반납하기
        System.out.println("User A 가 Harry Potter 반납하기");
        lb.ReturnBook(lb.findUser(A), searchedBook);
        System.out.println();

        //다시 User C로 같은 책 대여하기
        System.out.println("User C가 A가 반납한 책 대여하기");
        lb.LoanBook(lb.findUser(C), searchedBook);
        System.out.println();

        //lord of the ring 책 6권 지우기 시도
        System.out.print("예외7. 현재 있는 재고보다 더 많은 책을 폐기하기: ");
        lb.removeBook(searchedBook2, 6); //예외 발생 7
        System.out.println();

        //lord of the right 책 4권 지우기 시도
        System.out.println("Lord of the Ring 책 4권 폐기");
        lb.removeBook(searchedBook2, 4);
        System.out.println();

        //B lord of the ring 책 대여하기
        System.out.println("User B가 Lord of the Ring 책 대여하기");
        lb.LoanBook(lb.findUser(B), searchedBook2);
        System.out.println();

        //C lord of the ring 책 대여 시도
        System.out.print("예외8. C가 폐기 후 전부 소진된 책 대여하기: ");
        lb.LoanBook(lb.findUser(C), searchedBook2); //예외 발생 8
        System.out.println();

        //책 추가하기
        System.out.println("책 개수 각각 3개씩 입고");
        lb.addBook(b1, 3, BookCategory.Fiction);
        lb.addBook(b2, 3, BookCategory.Fantasy);
        lb.addBook(b3, 3, BookCategory.Travel);
        System.out.println();

        //A Harry Potter, Lord of the Ring 책 대여하기
        System.out.println("A가 Harry Potter, Lord of the Ring 책 대여하기");
        lb.LoanBook(lb.findUser(A), searchedBook);
        lb.LoanBook(lb.findUser(A), searchedBook2);
        System.out.println();

        //A Percy Jackson 책 대여 시도
        System.out.print("예외9. A가 대여할 수 있는 책 이상으로 대여하기: ");
        lb.LoanBook(lb.findUser(A), searchedBook3); //예외 발생 9
        System.out.println();

        //A 사용자 삭제 시도
        System.out.print("예외10. 대여한 책이 있는 사용자 A 삭제하기: ");
        lb.delUser(lb.findUser(A)); //예외 발생 10
        System.out.println();

        //A 책 반납
        System.out.println("A가 대여한 책 전부 반납하기");
        lb.ReturnBook(lb.findUser(A), searchedBook);
        lb.ReturnBook(lb.findUser(A), searchedBook2);
        System.out.println();

        //A 사용자 삭제
        System.out.println("대여한 책이 없는 사용자 A 삭제하기");
        lb.delUser(lb.findUser(A));
        System.out.println();

        //지운 사용자 검색
        System.out.print("예외11. 지운 사용자 A 검색하기: ");
        Member erased = lb.findUser(A); //예외발생 11
        System.out.println();

        //사용자 B의 생년월일 변경 시도
        System.out.print("예외12. 변경할 수 없는 정보 수정하기: ");
        lb.editUser(lb.findUser(B), new UserBuilder().name("강현서").birthdate("20050101")
                    .phonenumber("123456897").address("Addr2").build()); //예외발생 12
        System.out.println();
    }
}
