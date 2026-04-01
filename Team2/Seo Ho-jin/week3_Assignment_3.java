import java.util.Scanner;

public class week3_Assignment_3 {
  public static void main (String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("학생 수를 입력하세요: ");
    int student_num = keyboard.nextInt();

    int[] scores = new int[student_num];
    int sum = 0;

    System.out.print("점수를 학생 수만큼 입력하세요: ");
    for(int i=0; i<student_num; i++){
      scores[i] = keyboard.nextInt();
      sum += scores[i];
    }

    double average = (double)sum/student_num;
    System.out.print("평균: " + average);

  }
}

