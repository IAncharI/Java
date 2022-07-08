import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        14. Описати клас для бази даних з інформацією про метеорологічні спостереження протягом
        місяця у форматі: дата, температура, тиск. Визначити дні, температура яких є більшою від середнього
        значення температури. Результат вивести на екран у формі таблиці
        */

        File file = new File("C:\\Users\\gfors\\IdeaProjects\\Lab3_1a\\src\\FileM_O.txt");

        FileWriter writer = new FileWriter(file,true);
        Scanner scanner   = new Scanner(System.in);
        Scanner scfile    = new Scanner(file);

        int choice;

        while (true) {

            System.out.println("1. Вивести дані з файлу");
            System.out.println("2. Додати запис до файлу");
            System.out.println("0. Вихід");
            System.out.print("Введіть номер пункту - ");

            try {choice = scanner.nextInt();}
            catch (NumberFormatException e) {
                System.out.println("Введено невірне значення");
                choice = 0;}

            System.out.print("\n");
            switch (choice) {
                case 1:
                    int count = 0;
                    float is = 0;
                    System.out.println("Дані з файлу:");
                    while (scfile.hasNextLine()) {
                        String str = scfile.nextLine();
                        System.out.println(str);
                        String str2 = str.split(", Температура: ")[1].split("°, Тиск: ")[0];
                        is += Integer.parseInt(str2);
                        count++;
                    }
                    float ias = is/count;
                    System.out.print("\nСереднье значення : "+ias+"\n");
                    System.out.println("Вище середнього значення температури: ");

                    Scanner sc = new Scanner(file);
                    while (sc.hasNextLine()){
                        String str = sc.nextLine();
                        if (Integer.parseInt(str.split(", Температура: ")[1].split("°, Тиск: ")[0]) > ias) {
                            System.out.println(str);
                        }
                    }
                    sc.close();
                    System.out.print("\n");
                    break;
                case 2:
                    int dateD= 0, dateM = 0, dateY = 0, temperature = 0, pressure = 0;
                    try {
                        System.out.println("Введіть день");
                        dateD = scanner.nextInt();
                        if (dateD < 1 || dateD > 31 ) {
                            System.out.println("Введено невірне значення днів (1 - 31)");
                            break;
                        }

                        System.out.println("Введіть місяць");
                        dateM = scanner.nextInt();
                        if (dateM < 1 || dateM > 13 ){
                            System.out.println("Введено невірне значення місяця (1 - 12)");
                            break;
                        }

                        System.out.println("Введіть рік");
                        dateY = scanner.nextInt();
                        if (dateY < 1 || dateY > 3000){
                            System.out.println("Введено невірне значення Років (1 - 3000)");
                            break;
                        }

                        System.out.println("Введіть температуру");
                        temperature = scanner.nextInt();
                        if( temperature < -100 || temperature > 100 ){
                            System.out.println("Введено невірне значення Температури (-100  100)");
                            break;
                        }

                        System.out.println("Введіть тиск");
                        pressure = scanner.nextInt();
                        if( pressure < 1 || pressure > 1000) {
                            System.out.println("Введено невірне значення Тиску (1 - 1000)");
                            break;
                        }

                    }catch (NumberFormatException e) {
                        System.out.println("Введено невірне значення");
                    }
                    writer.write("Data: "+dateD+":"+dateM+":"+dateY+", Температура: "+temperature+"°, Тиск: "+pressure+"\n");
                    writer.close();
                    break;
                case 0:
                    return;
                default:
                break;
            }
        }
    }
}