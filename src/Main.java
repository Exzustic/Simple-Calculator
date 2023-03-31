import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder answer = null;
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            while(br.ready()) {
                try {
                    String[] str = br.readLine().split(" ");
                    answer = new StringBuilder(str[0] + " " + str[1] + " " + str[2] + " = ");
                    double a = Double.parseDouble(str[0]);
                    double b = Double.parseDouble(str[2]);
                    switch (str[1]) {
                        case "+" -> answer.append(a + b);
                        case "-" -> answer.append(a - b);
                        case "*" -> answer.append(a * b);
                        case "/" -> {
                            if (str[2].equals("0")) {
                                answer.append("Error! Division by zero");
                            } else
                                answer.append(a / b);
                        }
                        default -> answer.append("Operation Error!");
                    }
                } catch (NumberFormatException e) {
                    assert answer != null;
                    answer.append("Error! Not number");
                }
                try (FileWriter wr = new FileWriter("output.txt", true)) {
                    wr.write(answer+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}