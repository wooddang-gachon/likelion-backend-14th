package week5.role;

import week5.policy.OperatorLionPolicy;

public class OperatorLion extends Lion {
    String role;
    public OperatorLion(String name, String major, int generation, String part ,String role) {
        super(new OperatorLionPolicy(),"운영사자",name,major,part,generation);
        this.role = role;
    }

    public void showInfo() {
        System.out.printf("이름: %s | 전공: %s | 기수: %d | 파트: %s | 직책: %s %n",getName(), getMajor(), getGeneration(), getPart(), role);

        seePolicy();
    }

}
