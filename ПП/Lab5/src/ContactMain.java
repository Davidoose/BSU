/*
Модифицировать условие задачи учитывая свои пожелания
Возможно  авторское условие задачи
Использовать контейнеры:
 Vector, ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap.)

в) Для тестирования класса Контакт, создать консольное приложение позволяющее
создать небольшой массив контактов и напечатать отсортированными по
выбранному полю.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class ContactMain {

    public static class NoSuchComparator extends Throwable{}

    public static void main(String[] args) throws IOException, Contact.ToFewArguments, Contact.ToMuchArguments, ArrayIndexOutOfBoundsException, NoSuchComparator
    {
        FileReader isr2 = new FileReader("input.txt");
        BufferedReader fileIn = new BufferedReader(isr2);
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader sysIn = new BufferedReader(isr);

            System.out.println("Enter a delimiter for the lines in the file: ");
            String delimiters = sysIn.readLine();
            System.out.println("Enter the number of the Contact field to sort (from 1 to 7): ");
            Integer numCompare = Integer.parseInt(sysIn.readLine());

            String inputData = new String();
            ArrayList<Contact> contactsFile = new ArrayList<>();
            TreeSet<Contact> contactsFileTree= new TreeSet<>();
            while (true) {
                inputData = fileIn.readLine();
                if (inputData == null)
                    break;
                Contact current = new Contact(inputData, delimiters);
                contactsFileTree.add(current);
                contactsFile.add(current);
            }

            Comparator<Contact> compare;
            switch (numCompare)
            {
                case 1 -> compare = new Contact.ContactComparatorName();
                case 2 -> compare = new Contact.ContactComparatorMobileNumber();
                case 3 -> compare = new Contact.ContactComparatorWorkNumber();
                case 4 -> compare = new Contact.ContactComparatorHomeNumber();
                case 5 -> compare = new Contact.ContactComparatorEmail();
                case 6 -> compare = new Contact.ContactComparatorVebPage();
                case 7 -> compare = new Contact.ContactComparatorAdress();
                default -> throw new NoSuchComparator();
            }

            contactsFile.sort(compare);

            System.out.println("Sort ArrayList by komparator " + numCompare +":");
            for (Contact cont : contactsFile) {
                System.out.println(cont);
            }

            System.out.println();
            System.out.println("TreeSet comparable" + ":");
            for (Contact contTree: contactsFileTree)
            {
                System.out.println(contTree);
            }

            System.out.println();
            System.out.println("iter by ArrayList[i] (i = 1...size) throw Contacts");
            for (Contact cont : contactsFile) {
                Iterator<String> itFirst = cont.getIterator();
                int i = 1;
                while (itFirst.hasNext()) {
                    System.out.print("[" + i + "]: " + itFirst.next() + " | ");
                    i++;
                }
                System.out.println();
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        catch (Contact.ToMuchArguments e)
        {
            System.out.println("Too many arguments in the Contact constructor");
        }
        catch (Contact.ToFewArguments e)
        {
            System.out.println("Too few arguments in the Contact constructor");
        }
        catch (NoSuchComparator e)
        {
            System.out.println("");
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
        finally
        {
            fileIn.close();
        }
    }
}