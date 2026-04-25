package week5.package2;

import java.util.Scanner;

public class MemberService {

    private MemberRepository memberRepository;

    Scanner input = new Scanner(System.in);

    MemberService (MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }





    public void menu() {





        while(true) {
            System.out.println("멤버 관리 시스템");

            System.out.println("1. 멤버 등록");
            System.out.println("2. 멤버 조회");
            System.out.println("3. 멤버 검색(이름)");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");

            int tmp = input.nextInt();
            input.nextLine();

            if( tmp == 5)
                break;
            else if (tmp == 1) {
                chooseLion();
            }
            else if (tmp == 2) {
                memberRepository.showLions();
            }
            else if (tmp == 3) {
                memberRepository.searchLionByName();
            }
            else if (tmp == 4) {
                memberRepository.searchByPart();
            }

        }
    }
    public void chooseLion() {
        int tmp;
        System.out.println("역할 선택 (1: 학생사자, 2: 운영사자)");
        tmp = input.nextInt();
        input.nextLine();
        if ( tmp == 1 ) {
            memberRepository.createStudentLion();
        }
        else if ( tmp == 2 ) {
            memberRepository.createOperationLion();
        }
        else {
            System.out.println("이상한거 넣었는데?");
        }
        System.out.println("사자 추가 완료");

    }
}
