package week5.package2;

import week5.role.Lion;
import week5.role.OperatorLion;
import week5.role.StudentLion;

import java.util.*;

public class MockMemberRepository implements MemberRepository {

    Scanner input = new Scanner(System.in);
    public List<Lion> lions = new ArrayList<>();
    public Map<String, List<Lion>> map = new HashMap<>();


    public void createOperationLion () {
        String name, major, part, role;
        int generation;

        System.out.print("이름: ");
        name =input.nextLine();
        if(hasLion(name)) {
            System.out.println("이름이 중복됩니다!");
            return;
        }
        System.out.print("전공: ");
        major = input.nextLine();
        System.out.print("기수: ");
        generation = input.nextInt();
        input.nextLine();
        System.out.print("파트(백엔드/프론트엔드/기획/디자인): ");
        part = input.nextLine();
        System.out.print("직책(대표/부대포/파트장/멘토): ");
        role = input.nextLine();


        if(name.isBlank()) {
            System.out.println("이름이 이상해!");
        }
        else {
            Lion lion = new OperatorLion(name, major, generation, part, role);
            lions.add(lion);
            mapHandler(lion);
        }
    }
    public void createStudentLion () {

        String name, major, part;
        int generation, schoolNumber;

        System.out.print("이름: ");
        name = input.nextLine();
        if(hasLion(name)) {
            System.out.println("이름이 중복됩니다!");
            return;
        }
        System.out.print("전공: ");
        major = input.nextLine();
        System.out.print("기수: ");
        generation = input.nextInt();
        input.nextLine();
        System.out.print("파트(백엔드/프론트엔드/기획/디자인): ");
        part = input.nextLine();
        System.out.print("학번: ");
        schoolNumber = input.nextInt();
        input.nextLine();

        if(name.isBlank()) {
            System.out.println("이름이 이상해!");
        }
        else {
            Lion lion = new StudentLion(name, major, generation, part, schoolNumber);
            lions.add(lion);
            mapHandler(lion);
        }
    }
    public void mapHandler (Lion lion) {
        String part = lion.getPart();
        List<Lion> lions = map.get(part);

        System.out.println(part+"직업 확인!");
        if(!map.containsKey(part)) {
            System.out.println("신규생성");
            map.put(part,new ArrayList<Lion>());
            map.get(part).add(lion);
        }
        else {
            System.out.println("추가");
            map.get(part).add(lion);
        }
    }

    public boolean hasLion(String name) {
        for(Lion lion: lions) {
            if(name.equals(lion.getName()))
                return true;
        }
        return false;
    }
    public void showLions() {
        int i=1;
        for(Lion lion: lions) {
            System.out.printf("%d. [%s] %s - %d기 %n",i, lion.getWho(),lion.getName(),lion.getGeneration());
            i++;
        }
    }
    public void showLions(List<Lion> lions) {
        int i=1;
        for(Lion lion: lions) {
            System.out.printf("%d. [%s] %s - %d기 %n",i, lion.getWho(),lion.getName(),lion.getGeneration());
            i++;
        }
    }
    public void searchLionByName () {
        System.out.print("검색할 이름: ");
        String name = input.nextLine();
        searchByName(name);
    }
    public void searchByName(String name) {
        for(Lion lion:lions) {
            if (name.equals(lion.getName())) {
                lion.showInfo();
                return;
            }
        }
    }
    public void searchByPart() {
        showParts();
        System.out.print("조회할 파트: ");
        String part = input.nextLine();

        System.out.println("["+part+"파트 멤버]");
        List<Lion> lions = map.get(part);
        showLions(lions);
    }
    public void showParts() {
        System.out.print("[ ");
        for ( String key : map.keySet()) {
            System.out.print(key+" ");
        }
        System.out.println("]");


    }
}
