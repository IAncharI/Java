import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        14. Записати у файл sport.txt, що знаходитиметься на диску D(У мене на диску E) прізвища та результати 3 переможців
        олімпіади з інформатики. Вивести вміст файлу на екран для візуального контролю. Внести в
        кінець файлу прізвище та ім'я голови журі.
        */
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть ім'я журі - ");
        String name = sc.nextLine();

        System.out.print("Введіть прізвище журі - ");
        String surname = sc.nextLine();System.out.print("\n");

        FileWriter fw = new FileWriter("E:\\sport.txt",false);
        fw.write("Прізвище : Андрійович , Кількість балів : 90\n" +
                     "Прізвище : Петрович , Кількість балів : 80\n" +
                     "Прізвище : Сергійович , Кількість балів : 70\n" +
                     "Прізвище журі : "+ surname + " ,Ім'я журі : "+ name);
        fw.close();

        FileReader fr = new FileReader("E:\\sport.txt");
        BufferedReader reader = new BufferedReader(fr);
        while(reader.ready()) {
            System.out.println(reader.readLine());
        }
        fr.close();
    }
}