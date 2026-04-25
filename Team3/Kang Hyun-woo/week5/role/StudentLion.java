package week5.role;

import week5.policy.OperatorLionPolicy;


public class StudentLion extends Lion {
    public StudentLion(String name, String major, int generation, String part, int schoolNumber) {
        super(new OperatorLionPolicy(),"학생사자", name, major, part, generation);
        this.schoolNumber = schoolNumber;
    }


    int schoolNumber;




    public void showInfo() {

        System.out.printf("이름: %s | 전공: %s | 기수: %d | 파트: %s | 학번: %d %n",getName(), getMajor(), getGeneration(), getPart(), schoolNumber);
        seePolicy();
    }

}
