package week5.package2;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);

        MemberRepository repository;


        System.out.print("선택: ");
        int menu =input.nextInt();
        input.nextInt();
        if(menu==1) {
            repository = new MemoryMemberRepository();
        } else if (menu==2) {
            repository = new MockMemberRepository();
        }
        else
            repository = new MemoryMemberRepository();
        MemberService memberService = new MemberService(repository);

        memberService.menu();
    }
}
