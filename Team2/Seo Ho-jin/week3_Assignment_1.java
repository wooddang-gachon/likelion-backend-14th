import java.util.Scanner;

public class week3_Assignment_1 {
  // 기본 계산 프로그램(기초)
  public static void main (String[] args) {
    System.out.print("두 정수를 입력하세요 ");
    Scanner keyboard = new Scanner (System.in);
    int n1 = keyboard.nextInt();
    int n2 = keyboard.nextInt();

    int result1= n1 + n2;
    int result2 = n1-n2;
    int result3 = n1*n2;

    System.out.println("덧셈 결과: " + result1);
    System.out.println("뺄셈 결과: " + result2 );
    System.out.println("곱셈 결과: " + result3 );
    if(n2!=0){
      int result4 = n1/n2;
      System.out.println("나눗셈 결과: " + result4);
    } else{
      System.out.println("0으로 나눌 수 없음");
    }

  }
}
