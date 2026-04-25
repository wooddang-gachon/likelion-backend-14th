package week5.package3;

public class Main {

    public static void main (String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService service = appConfig.memberService;
        service.menu();
    }
}
