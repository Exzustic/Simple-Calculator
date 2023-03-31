import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String answer;
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            String[] str = br.readLine().split(" ");
            double a = Double.parseDouble(str[0]);
            double b = Double.parseDouble(str[2]);
            switch (str[1]) {
                case "+" -> answer =  Double.toString(a + b);
                case "-" -> answer =  Double.toString(a - b);
                case "*" -> answer =  Double.toString(a * b);
                case "/" -> {
                    if (str[2].equals("0")) {
                        answer = "Error! Division by zero";
                    } else
                        answer = Double.toString(a / b);
                }
                default -> answer = "Operation Error!";
            }
        } catch (NumberFormatException e){
            answer = "Error! Not number";
        } catch (ArithmeticException | IOException e) {
            throw new RuntimeException(e);
        }
        try(FileWriter wr = new FileWriter("input.txt",true)){
            wr.write(" = "+answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}