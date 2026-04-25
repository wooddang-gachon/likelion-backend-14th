package week5.package3;

import java.util.Scanner;

public class AppConfig {

    Scanner input = new Scanner(System.in);
    MemberRepository repository;
    MemberService memberService;

    AppConfig() {
        init();
        this.memberService = new MemberService(repository); // DI가 아닌 강결합이긴 함, 근데 인터페이스 만들어서 추가해도 괜찮을듯?
    }
    public MemberService memberService() {
        return memberService;
    }
    private void init() {
        System.out.print("Repository 선택 1:Memory / 2:Mock / 3:File ");
        int i =input.nextInt();
        input.nextLine();
        if (i == 1)
            this.repository = new MemoryMemberRepository();
        else if (i==2)
            this.repository = new MockMemberRepository();
        else if (i==3)
            this.repository = new FileMemberRepository();
    }

}
