import java.io.*;
import java.util.*;

public class Average {
    public static void average() {
        ArrayList<String> list;
        Scanner sc = new Scanner(System.in);
        try {
            FileReader fr = new FileReader( "Data.txt" );
            BufferedReader br = new BufferedReader( fr );
            String data;
            list = new ArrayList<>();

            while ((data = br.readLine()) != null) {list.add( data +"\n");}
            Collections.sort( list );
        }catch (IOException e) {throw new RuntimeException( e );}

        //System.out.println(list);
        String text ="";
        for (int i = 0; i < list.size(); i++) {
            text += list.get( i );
        }
        System.out.println( text );
        String[] text1 = text.split("\n");

        System.out.print("Введіть місяць - ");
        String month = sc.next();
        System.out.print("Введіть рік - ");
        String year = sc.next();


        int i = 0;String q = "";String w = "";String y = "";int count = 0;int p = 0;
        ArrayList<String> sort = new ArrayList<>();

        for (String s : text1) {
            for (String s1 : s.split(" ")) {
                if (s1.contains( "Month:" )) {
                    q = s1.substring( 6 );
                }
                if (s1.contains( "Year:" )) {
                    w = s1.substring( 5 );
                }
            }
            if (q.equals( month ) & w.equals( year )) {
                sort.add( text1[i] );
                y = s;
                String [] y1 = y.split(" ");
                for (String s2 : y1) {
                    if (s2.contains( "Temperature:" )) {
                        p += Integer.parseInt( s2.substring( 12 ));
                        count += 1;
                    }
                }
            }
            i++;
        }

        System.out.println( "\nСередне значення Температури в (місяць - " +month+" ,рік - "+year+") = "+ p/count +"\n");


        for (String s : text1) {
            for (String s1 : s.split( " " )) {

                if (s1.contains( "Month:" )) {
                    q = s1.substring( 6 );}
                if (s1.contains( "Year:" )) {
                    w = s1.substring( 5 );}
                if (s1.contains( "Temperature:" )) {
                    y = s1.substring( 12 );}
            }

            if (q.equals( month ) & w.equals( year )) {
                if (Integer.parseInt( y ) > p/count) {
                    System.out.println( "Температура що вище середнього - "+y );
                }
            }
        }
        System.out.println("\n");
    }
}
