/*
Вычислить приближённое значение суммы бесконечного ряда.
Вычисления заканчивать, когда очередное слагаемое окажется
по модулю меньше заданного числа ε. Вид этого числа
определяется следующим условием:
ε=10^(-k), где k - натуральное число. Сравнить полученный
результат со значением, вычисленным через стандартные функции.
Вывести на консоль оба результата.
Ряд: arcsin(x)=x+1*x^3/(2*3)+(1*3*x^5)/(2*4*5)+(1*3*5*x7)/(2*4*6*7)..,x ∈ (-1,+1)
*/
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import java.io.*;
import java.text.*;

public class PouhLab1Var8 {
    public  static double myPow(double x, int y) {
        double result = 1;
        if(y > 0){
            for(int i = 1; i<=y; i++){
                result *= x;
            }
        }
        else if(y<0){
            for(int i=0; i<=(-y); i++) {
                x /= 10;
            }
            result=x;
        }
        else {
            result=1;
        }
        return result;
    }

    public static double myFunction(double x, double e){
        double result = x;
        double p = x;
        double k=2;
        while(Math.abs(p)>e)
        {
            p=(p * (k - 1) * (k - 1) * x * x) / (k * (k + 1));
            result += p;
            k += 2;
        }
        return result;
    }

    public static void main(String[] args) {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        try {
            System.out.println("Введите x ∈ (-1,+1): ");
            String line=br.readLine();
            double ourNumber = Double.parseDouble(line);

            System.out.println("Введите натуральное число k: ");
            String secondLine=br.readLine();
            int ourDegree = Integer.parseInt(secondLine);

            ourDegree = -ourDegree;
            double e = myPow(10, ourDegree);

            System.out.println("Результат через стандартные функции: ");
            double result = Math.asin(ourNumber);
            NumberFormat formatter=NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(3);
            System.out.println(formatter.format(result));

            System.out.println("Мой результат: ");
            double myResult = myFunction(ourNumber, e);
            System.out.println(formatter.format(myResult));
        }
        catch (NumberFormatException e) {
            System.out.println("Не число");
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения с клавиатуры");
        }
    }
}