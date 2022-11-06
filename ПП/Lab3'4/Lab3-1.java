import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/*Поух Давид 2 курс 7 группа задача 36
        36.	В данной действительной квадратной матрице порядка n найти min элемент.
        Получить квадратную  матрицу  порядка n+1 путем  добавления к исходной какой-либо строки и столбца,
        на пересечении которых расположен элемент с найденным значением.
*/
public class Task1Var8 {
    private static Integer size;

    public static void create_matr(ArrayList<ArrayList<Integer>> matr){
        Random number = new Random();
        for(int i = 0; i < size; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < size; j++) {
                temp.add(number.nextInt() % 100);
            }
            matr.add(temp);
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> matr){
        System.out.println("Matrix:");
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                System.out.print(matr.get(i).get(j) + " ");
            }
            System.out.print('\n');
        }
    }

    public static ArrayList<ArrayList<Integer>> change_matr(ArrayList<ArrayList<Integer>> matr) {

        int min = matr.get(0).get(0), minI = 0, minJ = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (min > matr.get(i).get(j)) {
                    min = matr.get(i).get(j);
                    minI = i;
                    minJ = j;
                }
            }
        }

        ArrayList<Integer> matrLine = new ArrayList<Integer>();
        ArrayList<Integer> matrColumn = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == minI) {
                    matrLine.add(matr.get(i).get(j));
                }
                if (j == minJ) {
                    matrColumn.add(matr.get(i).get(j));
                }
            }
        }

        matrLine.add(0);

        ArrayList<ArrayList<Integer>> newMatr = new ArrayList<ArrayList<Integer>>();
        int newNumb = size++;
        for (int i = 0; i < newNumb; i++) {
            ArrayList<Integer> newMatrLine = new ArrayList<Integer>();
            for (int j = 0; j < newNumb; j++) {
                newMatrLine.add(matr.get(i).get(j));
            }
            newMatrLine.add(matrColumn.get(i));
            newMatr.add(newMatrLine);

        }
        newMatr.add(matrLine);
        return  newMatr;
    }

    public static void main(String[] args) {
        System.out.println("Enter matrix size: ");
        Scanner sc = new Scanner(System.in);
        String numbS = sc.next();
        size = parseInt(numbS);
        if(size > 0) {
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
            create_matr(matrix);
            print(matrix);
            matrix = change_matr(matrix);
            print(matrix);
        }
        else
            System.out.println("Wrong matrix size!");
    }
}
