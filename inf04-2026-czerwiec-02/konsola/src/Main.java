import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Notatka waznaNotatka = new Notatka("tenis", "Gra z Ewą w poniedziałek", true);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytuł notatki:");
        String tytul = scanner.nextLine();
        Notatka zwyklaNotatka = new Notatka(tytul);

        waznaNotatka.wyswietl();
        zwyklaNotatka.wyswietl();
    }
}
