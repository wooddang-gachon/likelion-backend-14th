import java.util.Scanner;

/*public class Main {
  public static void main(String[] args) {
  Scanner sc= new Scanner(System.in);
  System.out.println("a와 b를 입력해주세요");
  int a=sc.nextInt();
  int b=sc.nextInt();
  System.out.println(a+b);
  System.out.println(a-b);
  System.out.println(a*b);
  System.out.println(a/b);
  }
}*/


/*public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("점수를 입력하세요.");
    int score = sc.nextInt();

    if (score > 100 || score < 0) {
      System.out.println("0~100 범위로 다시 입력해주세요.");
      System.out.println("점수를 입력하세요.");
      score = sc.nextInt();
    }

    if (score >= 90) {
      System.out.println("A");
    } else if (score >= 80) {
      System.out.println("B");
    } else if (score >= 70) {
      System.out.println("C");
    } else {
      System.out.println("D");
    }

  }
}*/

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("학생 수를 입력하세요: ");
    int n=sc.nextInt();
    int[] score= new int[n];
    int sum=0;
    for(int i=0; i<n; i++){
      System.out.print((i+1)+"학생 점수 입력: ");
      score[i]=sc.nextInt();
      sum+=score[i];
    }
    double avg =sum/n;
    System.out.print("전체 평균: "+avg);
  }
}