package week5.role;


import week5.policy.Policy;

public abstract class Lion {

    private String name, major, part;
    private int generation;
    protected final Policy policy;
    protected final String who;

    protected Lion(Policy policy, String who, String name, String major, String part, int generation ) {
        this.policy = policy;
        this.who = who;
        this.name = name;
        this.major = major;
        this.part = part;
        this.generation = generation;
    }

    // abstract method
    abstract public void showInfo();

//  getter method
    public String getPart() { return part; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public Policy getPolicy() { return policy; }
    public String getWho() { return who; }

//  setter method
    public void setName(String name) { this.name = name; }
    public void setMajor(String major) { this.major = major; }
    public void setPart(String part) {
        this.part = part;
    }
    public void setGeneration(int generation) {
        this.generation = generation;
    }



    public void seePolicy () {
        String tmp;
        if(policy.isPolicyAllowed(getGeneration()))
            tmp = "가능";
        else
            tmp = "불가능";
        System.out.println("과제 제출 여부 "+tmp);
    }

    //    public void checkInformation(String lionName, String lionMajor, int lionGen, int lionSchoolNum, String lionPart) {
//        System.out.println("검증을 진행합니다.");
//        if (lionMajor.isBlank() || lionName.isBlank() || lionGen < 1 ) {
//            System.out.println("[X] 잘못된 아기사자 정보입니다.");
//        }
//        else {
//            System.out.println("객체 상태 정상 확인.");
//
//            this.name = lionName;
//            this.major = lionMajor;
//            this.generation = lionGen;
//            this.schoolNumber = lionSchoolNum;
//            this.part = lionPart;
//        }
//    }
}
