// Java 프로그래밍 - 입출력_1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void referInputStream() throws IOException {
//      System.in : 문자 하나를 바이트 단위로 읽는다
        System.out.println("== System.in ==");

        System.out.print("입력 : ");

        //System.in.read() -- 문자 하나를 int로 반환 (읽을게 없으면 -1)
        int a = System.in.read() - '0';
        System.out.println("a = " + a);

        //System.in.available() -- 키보드 버퍼의 나머지 갯수
        //new byte[System.in.available()] 로 버퍼를 비워주어야 한다.
        System.in.read(new byte[System.in.available()]);

//      InputStreamReader : 여러 개의 문자를 지정된 크기의 버퍼 배열만큼 읽어와 저장한다.
        System.out.println("== InputStreamReader ==");

        InputStreamReader reader = new InputStreamReader(System.in);
        char[] c = new char[3];
        System.out.print("입력 : ");
        reader.read(c); // char[] c 배열 안에 문자를 하나씩 읽어 저장한다.
        System.out.println(c);

//      BufferedReader : 지정하지 않고도 한 줄씩 읽어올 수 있다.
        System.out.println("== BufferedReader ==");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("입력 : ");
        String s1 = br.readLine();
        System.out.println("s1 = " + s1);

    }

    public static void main(String[] args) throws IOException {

//      1. 입력
//      1-1. 다른 입력 방식 참고
//        referInputStream();

//      1-2. Scanner
        System.out.println("== Scanner ==");
        Scanner sc = new Scanner(System.in);
        System.out.print("입력1 : ");
        System.out.println(sc.next());
        sc.nextLine();

        System.out.print("입력2 : ");
        System.out.println(sc.nextInt());
        sc.nextLine();

        System.out.print("입력3 : ");
        System.out.println(sc.nextLine());

//      참고) 정수, 문자열 변환
        int num = Integer.parseInt("12345");
        String str = Integer.toString(12345);
        
//      2. 출력
        System.out.println("== 출력 ==");
        System.out.println("Hello");
        System.out.println("World!");

        System.out.print("Hello ");
        System.out.print("World!");
        System.out.println();

        System.out.printf("Hello ");
        System.out.printf("World!");

        String s = "자바";
        int number = 3;

        System.out.println(s + "는 언어 선호도" + number + "위 입니다.");
        System.out.printf("%s는 언어 선호도 %d위 입니다.\n", s, number);

        System.out.printf("%d\n", 10); //10진수
        System.out.printf("%o\n", 10); //8진수
        System.out.printf("%x\n", 10); //16진수

        System.out.printf("%f\n", 5.2f);

        System.out.printf("%c\n", 'A');
        System.out.printf("%s\n", "안녕하세요");

        System.out.printf("%-5d\n", 123);
        System.out.printf("%5d\n", 1234);
        System.out.printf("%5d\n", 12345);

        System.out.printf("%.2f\n", 1.123456f); //반올림 되어 출력


    }
}
