import java.util.Scanner;

public class week3_Assignment_2 {
  public static void main (String[] args){
    System.out.println("0부터 100 사이의 점수를 입력하세요");
    Scanner keyboard = new Scanner (System.in);
    double score = keyboard.nextDouble();

    char grade;
    if(score>=0&&score<=100){
      if(score>=90){
        grade = 'A';
      }
      else if(score>=80){
        grade = 'B';
      }
      else if(score>=70){
        grade = 'C';
      }
      else {
        grade = 'D';
      }
      System.out.println("등급: " + grade);
    } else {
      System.out.println("잘못된 입력입니다.(0~100 범위 초과)");
    }

  }
}


