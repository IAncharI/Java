import java.util.Scanner;

//Lab2_1
public class Main {
    public static void main(String[] args) {
        /*
        14.
        а) знищує всі слова, які починаються і закінчуються за одну й ту ж літеру; б) підраховує
        кількість різних слів, що входять до заданого тексту.
        */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть строку - ");
        String name = scanner.nextLine();
        String[] words = name.split(" ");

        System.out.print("\nВиправлена строка : ");
        for (String word : words) {
            if (word.length() > 1) {
                if (word.charAt(0) != word.charAt(word.length() - 1)) {
                    System.out.print(word + " ");
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    words[j] = "";
                }
            }
        }
        String line = "";
        for (String word : words) {
            if (!word.equals("")) {
                line += word + " ";
            }
        }
        int count = 0;
        for (String word : words) {
            if (!word.equals("")) {
                count++;
            }
        }
        System.out.println("\n\nКількість різних слів - " + count);
    }
}
