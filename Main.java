import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


        System.out.println("Введите строковый пример:");
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        char action;
        String[] data;
        int mlt;


        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';

        } else{
            throw new Exception("Некорректный знак действия");
        }



        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }




        if (data[0].length()>10 || data[1].length()>10) {
            throw new Exception("Количество символов должно быть меньше 10");
        }




        if (action == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            if (multiplier>10) { throw new Exception("Число должно быть меньше 10");
            }

            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result+=data[0];
            }
            printInQuotes(result);
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if(index == -1){
                printInQuotes(data[0]);
            }else{
                String result = data[0].substring(0, index);
                result+=data[0].substring(index+data[1].length());
                printInQuotes(result);
            }
        }else{
            int newLen = data[0].length()/Integer.parseInt(data[1]);
            if (Integer.parseInt(data[1])>10){throw new Exception("Число должно быть меньше 10");

            }

            String result = data[0].substring(0,newLen);
            printInQuotes(result);
        }


    }
    static void printInQuotes(String text){

        if (text.length()>40){
            String subStr = text.substring(0, 40);
            System.out.println(subStr+"...");
        }
        else if(text.length()<40){
            System.out.println("\"" + text + "\"");
        }

    }
}
