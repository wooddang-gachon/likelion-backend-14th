package week5.package2;

import week5.role.Lion;

import java.util.List;

public interface MemberRepository {

    public void createOperationLion ();
    public void createStudentLion ();
    public boolean hasLion(String name);
    public void showLions();
    public void showLions(List<Lion> lions);
    public void searchLionByName ();
    public void searchByName(String name);
    public void searchByPart();
    public void showParts();
}