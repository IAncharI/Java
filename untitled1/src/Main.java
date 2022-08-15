import java.util.Scanner;

public class Main {//Lab 3_1
    /*14. Описати клас для бази даних з інформацією про метеорологічні спостереження протягом
    місяця у форматі: дата, температура, тиск. Визначити дні, температура яких є більшою від середнього
    значення температури. Результат вивести на екран у формі таблиці.*/

    public static void main (String[] args) {
        while (true){
            System.out.print(
            "1 - Вивести\n" +
            "2 - Додати\n" +
            "3 - Вивести середне значення Температури\n"+
            "0 - Вихід\n" +
            "Введіть дію - "
            );
            int action = 0;
            try {Scanner sc = new Scanner(System.in);action = sc.nextInt();}
            catch (NumberFormatException e){System.out.println("Введіть номер дії");break;}

            switch (action) {
                case 1 -> Out.out();
                case 2 -> Add.add();
                case 3 -> Average.average();
                case 0 -> System.exit( 0 );
                default -> System.out.println( "Введений номер дії не вірний" );
            }
        }
    }
}
