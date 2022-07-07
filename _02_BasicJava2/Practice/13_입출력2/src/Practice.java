// Practice
// JamesArthurGosling.txt 파일을 읽은 후 원하는 단어 변경하여 새로 저장해보자.

import java.io.*;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) throws IOException {
        String inputFile = "./JamesArthurGosling.txt";
        String outputFile = "./JamesArthurGosling_edit.txt";

        // 찾을 단어 / 변경 단어 입력 받기
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("찾을 단어 : ");
        String word = br1.readLine();
        System.out.print("변경 단어 : ");
        String renameWord = br1.readLine();

        // 파일 읽기, 변경 및 저장
        BufferedReader br2 = new BufferedReader(new FileReader(inputFile));
        PrintWriter pw = new PrintWriter(outputFile);

        while (true) {
            String line = br2.readLine();

            if (line == null) {
                break;
            }

            String newLine = line.replace(word, renameWord);
            pw.println(newLine);

        }

        br2.close();
        pw.close();

    }
}
