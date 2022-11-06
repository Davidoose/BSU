import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


/*8. Поух Давид 7 группа задача 8 из второго файла по строкам
	Задан текстовый файл input.txt. Требуется определить строки этого файла,
 содержащие максимальную по длине подстроку, состоящую из одинаковых символов латинского алфавита.
  Заглавные и строчные буквы не различаются. Если таких строк несколько, найти первые 10.
  Результат вывести на консоль в форме, удобной для чтения.

asdggg fklkkk;alsdk fffffkas;dlfkjjjj
asdfllllfa;sl fjsdl;fjjj; a;sdlfkjsa;dllll
as;dlfkkkk dasjfldfjfieiei ;ldsfkc,vmnmcmmm
  */

public class Main {
    static int findMaxSubstr(String str) {
        int max = 0;
        int result = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                max++;
            } else {
                if (max > result){
                    result = max;
                    max = 0;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        FileReader in = new FileReader("D:\\Programming\\ПП 3 сем\\лаба 3 карпович\\lab32-8\\src\\input.txt");
        Scanner fileScan = new Scanner(in);
        ArrayList<Integer> maxSubstr = new ArrayList<Integer>();
        int maxSubseq = 0;
        while (fileScan.hasNextLine()) {
            int subseq = findMaxSubstr(fileScan.nextLine());
            maxSubstr.add(subseq);
            if (subseq > maxSubseq)
                maxSubseq = subseq;
        }
        System.out.print("Строки файла содержащие максимальную по длине подстроку: ");
        for (int i = 0; i < maxSubstr.size(); i++) {
            if (maxSubstr.get(i) == maxSubseq)
                System.out.print((i + 1) + " ");
        }
    }
}
