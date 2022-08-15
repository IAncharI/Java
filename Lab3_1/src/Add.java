import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Add {
    public static void add () {
        Data data = new Data();

        int dataDay = 0; int dataMonth = 0; int dataYear = 0;int error = 0;
        String FileContent = "";

        while (true) {
            try {
                Scanner sc = new Scanner( System.in );

                System.out.print( "Введіть місяць - " );
                data.Month = sc.nextInt();
                if (data.getMonth() > 12 || data.getMonth() < 1) {break;}

                System.out.print( "Введіть день - " );
                data.Day = sc.nextInt();
                if (data.getMonth() > 31 || data.getMonth() < 1) {break;}

                System.out.print( "Введіть рік - " );
                data.Year = sc.nextInt();
                if (data.getMonth() > 2023 || data.getMonth() < 1) {break;}

                System.out.print( "Введіть температуру - " );
                data.Temperature = sc.nextInt();

                System.out.print( "Введіть тиск - " );
                data.Pressure = sc.nextInt();

            }catch (NumberFormatException e) {error+=1;System.out.println( "Введіть номер місяця" );}
            if (error == 0){
                FileContent = "Month:" + data.getMonth() +
                             " Year:" + data.getYear() +
                             " Day:" + data.getDay() +
                             " Temperature:" + data.getTemperature() +
                             " Pressure:" + data.getPressure() + "\n";

                try{
                FileReader fr = new FileReader( "Data.txt" );
                Scanner sc = new Scanner( fr );

                String text = "";
                while (sc.hasNextLine()) {
                    text += sc.nextLine() + "\n";
                }

                for (String s : text.split( "\n" )){
                    for (String w : s.split( " " )){
                        if (w.contains( "Day:" )){
                            dataDay = Integer.parseInt( w.substring( 4 ));
                        }
                        if (w.contains( "Month:" )){
                            dataMonth = Integer.parseInt( w.substring( 6 ));
                        }
                        if (w.contains( "Year:" )){
                            dataYear = Integer.parseInt( w.substring( 5 ));
                        }
                        if (dataDay == data.getDay() && dataMonth == data.getMonth() && dataYear == data.getYear()){
                            System.out.println( "Дані вже існують" );
                            error = 1;
                            break;
                        }
                    }
                }
                }catch (FileNotFoundException e) {throw new RuntimeException( e );}
            }
            if (error == 0){try {FileWriter fr = new FileWriter( "Data.txt", true );
                fr.write( FileContent );fr.close();}
            catch (Exception e) {throw new RuntimeException( e );}
            }
            return;
        }
    }
}