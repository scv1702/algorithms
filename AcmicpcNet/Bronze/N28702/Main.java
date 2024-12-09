package AcmicpcNet.Bronze.N28702;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static boolean isNumeric(String s) {
        return Character.isDigit(s.charAt(0));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();
        String D = ""; // Fizz, Buzz, FizzBuzz, i

        if (A.startsWith("Fizz")) { // A가 3의 배수인 경우
            int numD = 0;
            if (isNumeric(B)) {
                numD = Integer.parseInt(B) + 2;
            } else if (isNumeric(C)) {
                numD = Integer.parseInt(C) + 1;
            }
            if (numD % 5 == 0) {
                D = "FizzBuzz";
            } else {
                D = "Fizz";
            }
        } else if (A.equals("Buzz")) { // A가 3의 배수가 아니고, 5의 배수인 경우
            // D는 3의 배수와 5의 배수 둘다 아님
            if (isNumeric(B)) {
                D = String.valueOf(Integer.parseInt(B) + 2);
            } else if (isNumeric(C)) {
                D = String.valueOf(Integer.parseInt(C) + 1);
            }
        } else { // A가 3의 배수도 아니고, 5의 배수도 아닌 경우
            int numD = Integer.parseInt(A) + 3;
            if (numD % 5 == 0) {
                D = "Buzz";
            } else {
                D = String.valueOf(numD);
            }
        }

        bw.write(D);
        bw.flush();
        bw.close();
    }
}
