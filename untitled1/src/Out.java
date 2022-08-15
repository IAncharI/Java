import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Out {
    public static void out () {
        String File = "Data.txt";
        try{
            FileReader fr = new FileReader( File );
            Scanner sc = new Scanner( fr );
            String Content = "";

            System.out.print("\n");
            while (sc.hasNextLine()) {Content += sc.nextLine() + "\n";}
            String[] Content1 = Content.split("\n");
            Arrays.stream( Content1 ).sorted().forEach(System.out::println);
            System.out.print("\n");
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не знайдено");
        }
    }
}