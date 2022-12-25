import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/* Поух Давид 7 группа 2 курс задание 8 ИСПОЛЬЗОВАНИЕ РЕГУЛЯРНЫХ ВЫРАЖЕНИЙ
8.	Из заданной строки получить новую строку, выполняя замены по следующему правилу:
символы латинского алфавита следует оставить без изменений;
символ «пробел» следует заменить символом ‘+’.
Слова в исходной строке разделяются некоторым множеством разделителей. Слова в новой строке должны разделяться ровно одним пробелом.

   Тест:
   adsfgi,.   dfkjh d..., sdf fsdd
   результат:
   adsfgi+dfkjh+d+sdf+fsdd
*/

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader in = new FileReader("C:\\Users\\Lenovo\\IdeaProjects\\lab31-8\\src\\input.txt");
        Scanner scan = new Scanner(in);
        String str = scan.nextLine();
        System.out.println("первоначальная строка:\n" + str + "\n");
        String[] tokens = str.split("[^a-zA-Z0-9]+");
        StringBuilder newStr = new StringBuilder(new String());
        System.out.println("итог:\n");
        for (String token : tokens) {
            newStr.append(token + "+");
        }
        StringBuffer newStr2= new StringBuffer(newStr);
        newStr2.deleteCharAt(newStr.length() - 1);
        System.out.println(newStr2);
    }
}