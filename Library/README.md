# 도서관 시스템
 


## 목차
    1. [개요](#1-개요)
    2. [책 클래스 및 도서관 책 클래스](#2-책-클래스-및-도서관-책-클래스)
    3. [사용자 클래스](#3-사용자-클래스)
    4. [책 관리 클래스](#4-책-관리-클래스)
    5. [대출 관리 클래스](#5-대출-관리-클래스)
    6. [사용자 관리 클래스](#6-사용자-관리-클래스)
    7. [사용자 정의 예외 클래스](#7-사용자-정의-예외-클래스)
    8. [도서관 클래스](#8-도서관-클래스)
    9. 객체 지향성


## 1. 개요

 본 프로젝트는 객체지향프로그래밍 과목의 두번째 과제인 **'도서관 시스템'** 프로그램입니다.
 도서관 시스템은 크게 4가지로 구성되어 있습니다:

    - 사용자 관리 모듈
    - 책 관리 모듈
    - 책 대여 관리 모듈
    - 위 3개의 모듈을 포함한 도서관

## 2. 책 클래스 및 도서관 책 클래스

 책은 도서관의 핵심 객체 중 하나입니다. **Book** 클래스는 '시중'의 책을 객체화 한 것이고, **LibraryBook** 클래스는 *'도서관' 책*을 객체화 한 것이고 (합성), **Book** 객체와 더불어 **BookCategory** 클래스 (enum) 을 가지고 있습니다.

 이렇게 구별한 이유는 도서관 책은 시중의 책으로부터 파생된 것이기 때문입니다. 본 프로그램에서 책의 재고를 추가할 때는 Book 클래스를 사용하며, 책 폐기, 책 대여 등과 같은 작업을 할 때에는 LibraryBook 을 통해서 합니다.

 다른 책임을 구별하기 위해 **책의 제목, 저자, 출판사**가 같은지의 여부를 확인합니다. 이는 LibraryBook 도 마찬가지 입니다.


## 3. 사용자 클래스

 사용자 또한 도서관의 핵심 객체 중 하나입니다. 오로지 가입을 한 사용자만이 책을 대여할 권한을 가지기 때문입니다. User 클래스는 단순히 **'사람'**을 객체화 한 것입니다. 즉 User는 도서관의 회원일수도 아닐수도 있습니다.

 회원 가입을 통해 생성된 사용자인 **Member** 만이 책을 대여할 권한을 가집니다. **Member**는 **User** 객체와 더불어 사용자 아이디의 정보도 가지고 있습니다 (합성 방식을 이용합니다).

 같은 '사람'의 기준은 모호하지만, 프로그램에서는 **'이름', '전화번호', '주소', '생년월일'**이 같으면 동일한 사용자라고 판단하게끔 구현했습니다. 이는 추후 설명할 중복 회원 가입을 막기 위함입니다.

## 4. 책 관리 클래스

 책 관리 클래스는 도서관의 책 재고를 관리하는 클래스입니다. 책 관리 모듈을 다른 개발자가 다르게 정의할 수 있기 때문에 필수 메서드는 **BookManagementInterface** 인터페이스에 선언을 하였고, 개발자는 이를 자체 정의한 클래스에서 구현하도록 했습니다. 이는 다형성을 충족하기 위함입니다.

 **BookManagementInterface**에서는 다음의 메서드를 제공합니다:

    - 책 입고 (void AddBook(LibraryBook book, int count))
        - 새로 들어오는 책을 도서관에 추가
        - book을 count 개수만큼 도서관에 추가

    - 책 폐기 (void DeleteBook(LibraryBook book, int Count, int loanedBookCount))
        - 도서관 책을 폐기
        - book을 Count 개수만큼 폐기
        - loanedBookCount는 폐기하는 책의 대출 개수를 인자로 넘김

    - 책 재고 검색(LibraryBook getBook(String title, String author, String publisher))
        - 제목, 저자, 출판사를 통해 도서관 책을 검색하고 도서관 책을 반환

    - 책 개수 검색(int getBookCount(LibraryBook lb))
        - LibraryBook 의 개수 검색

 이 때 도서관 책은 외부에서 함부로 수정되면 안되기 때문에 반환되는 LibraryBook은 **방어적 복사**를 이용하여 원본이 아닌 복사본을 반환하도록 구현하였습니다.

 **BookManageMentInterface**를 본 프로그램에서 구현한 클래스인 **BookManagement** 클래스가 있습니다. **BookManagement**에서는 HashMap으로 통해 책과 보유량을 저장합니다.


## 5. 대출 관리 클래스

 대출 관리 클래스는 도서관의 대출을 관리하는 클래스입니다. 대출 관리 클래스도 개발자가 다르게 구현할 수 있기 때문에 필수 메서드는 **LibraryLoanManagement** 인터페이스에 선언하였고, 개발자는 이를 자체적으로 정의한 클래스에서 구현하도록 했습니다 **(다형성)**.

 대출 관리 시스템은 대출 정책이 필요로 합니다. 대출 정책을 통해 인당 최대 대여 개수와 같은 정책을 설정할 수 있습니다. 이는 LibraryLoanPolicy 인터페이스로 정의되었고, 개발자는 각자의 필요에 맞게 대출 정책 클래스를 구현하면 됩니다. 이 역시 **다형성**을 위함입니다. 현재 LibraryLoanPolicy는 다음의 메서드를 제공합니다:

    - 정책 설정(void setPolicy(int MAX_LOAN_COUNT))
        - 인당 최대 대여 횟수를 MAX_LOAN_COUNT로 설정합니다.

    - 최대 대여 횟수 반환하기(int getPolicy())
        - 현재 설정된 최대 대출 횟수 정책을 반환합니다.


 **LibraryLoanManagement**는 다음을 제공합니다:

    - 책 대출(LoanBook(Member m, LibraryBook b, int totalBookCount))
        - 사용자 m이 b를 대출
        - totalBookCount는 대여된 책을 포함한 도서관에서 보유한 책의 개수

    - 책 반납(ReturnBook(Member m, LibraryBook b))
        - 사용자 m이 b를 반납

    - 책 대출 현황 확인(getLoanStatus(LibraryBook lb))
        - 인자로 넘긴 도서관 책 lb의 대출된 개수를 반환

    - 사용자의 현재 대출한 책의 개수 확인(getUserLoanCount(Member m))
        - m이 현재 대출한 책의 개수를 반환

    - 책 대출 정책 변경(changeMaxLoanPolicy(int MAX_LOAN_BOOK))
        - 대출 관리 시스템의 대출 정책을 변경합니다.

 본 프로그램은 **LibraryLoanManagement**를 **LoanManagement** 에서 구현하였습니다.

 ``` JAVA
    private HashMap<Member, ArrayList<LibraryBook>> loans = new HashMap<>();
    private HashMap<LibraryBook, Integer> loan_status = new HashMap<>();
    private LibraryLoanPolicy lp;
 ```


 위의 클래스 변수는 대출 현황을 저장하기 위한 것입니다. 각각은 다음을 저장합니다:

    - private HashMap<Member, ArrayList<LibraryBook>> loans
        - HashMap의 키 값인 Member를 이용하여 사용자별로 대출한 책의 목록을 저장합니다.

    - private HashMap<LibraryBook, Integer> loan_status
        - 도서관 책 각각의 대출 개수를 저장합니다.
    
    - private LibraryLoanPolicy lp
        - 대출 정책을 저장합니다.

 대출 정책은 LoanManagement의 생성자 호출 시, 인자로 넘깁니다.


## 6. 사용자 관리 클래스
 
 사용자 관리 클래스는 도서관의 사용자를 관리하는 클래스입니다. 이 역시 다형성을 충족시키기 위해 **LibraryMemberManagement** 인터페이스를 정의하였습니다. 이는 다음의 메서드를 제공합니다:

    - 사용자 추가 (addMember(User o, String user))
        - User o를 user의 아이디로 추가

    - 사용자 수정 (editMember(Member o, User mod))
        - Member o의 정보를 mod로 수정(이때 생년월일을 바꾸는 시도 시 예외 발생)

    - 사용자 삭제 (deleteMember(Member o, int loanCount))
        - Member o를 삭제, 이때 loanCount가 0이 아니면 예외 발생

    - 사용자 반환 (Member getMember(User o))
        - User o 를 통해 도서관 사용자 반환 (이때 반환하는 것은 저장된 것의 복사본임 (방어적 복사))

 본 프로그램에서는 **LibraryMemberManagement** 인터페이스를 **MemberManagement**에서 구현하였습니다.

 ```JAVA
 List<Member> Members = new ArrayList<Member>();
 ```

 MemberManagement의 Members 변수는 도서관의 사용자를 저장하는 클래스 변수입니다.


 ## 7. 사용자 정의 예외 클래스

 Library의 각 모듈의 메서드를 실행하는 과정에서 **예외**가 발생할 수 있습니다. 예를 들어 없는 사용자로 책을 대여하는 행위라거나, 이미 존재하는 사용자의 중복 가입의 등 사용자의 실수로 인한 오류가 발생할 수 있습니다. 이를 위해 [Exception](./Exception/) 폴더 안에 발생할 수 있는 예외를 throwable 오브젝트인 **Exception**을 상속하여 정의하였습니다. 본 프로그램에서는 다음의 예외가 정의되어 있습니다:

 ```JAVA
 DifferentUserInfoException //수정이 안되는 사용자의 정보를 수정할 때
 FewerBookException //폐기하는 책이 현재 재고량보다 적을 때
 LoanCountExcessException //책이 전부 대여되었을 때
 LoanedBookException //이미 사용자가 같은 책을 대여했을 때
 LoanPolicyViolationException //대출 정책을 위반했을 때
 MemberAlreadyExistsException //이미 존재하는 회원일 때
 NoLibraryBookException //도서관에 없는 책일 때
 NoMemberException //사용자가 존재하지 않을 때
 NotLoanedBookException //반납하는 책이 사용자에 의해 대여한 책이 아닐 때
 UserCreationShortArgsException //사람을 생성할 때 필수 인자가 없을 때
 UserCurrentlyHaveLoanException //사용자를 삭제할 때 대여한 책이 있을 떄
 ```

 개발자는 기능을 구현할 때 새로운 예외를 만들어서 처리할 수 있습니다.

## 8. 도서관 클래스

 도서관 클래스는 도서관을 객체화 한 것으로 핵심 기능인 사용자 관리, 책 관리, 대출 관리 클래스를 이용하여 구현한 클래스입니다.

 생성자는 다음과 같습니다:
 
 ```JAVA
 private BookManagementInterface BMI;
 private LibraryLoanManagement LLM;
 private LibraryMemberManagement LMM;

 public Library(BookManagementInterface BMI, LibraryLoanManagement LLM, LibraryMemberManagement LMM){
        this.BMI = BMI;
        this.LLM = LLM;
        this.LMM = LMM;
    }
 ```

 생성자로 **BookManagement, LoanManagement, MemberManagement** 를 넘기면 각각 BMI, LLM, LMM의 변수에 저장합니다. 도서관은 다음

    - 사용자 추가
    - 사용자 정보 수정
    - 사용자 삭제
    - 책 입고
    - 책 폐기
    - 책 대출
    - 책 반납
    - 대여 정책 변경

기능을 제공하며, 각각 **BookManagement, LoanManagement, MemberManagement** 의 메서드 호출을 통해 기능을 수행합니다.
 





