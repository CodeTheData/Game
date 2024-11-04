import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnitsPrison {
    Scanner scanner = new Scanner(System.in);

    List <List<Unit>> listOfLists;
    private int indexArena;

    public UnitsPrison(){
        listOfLists = new ArrayList<List<Unit>>();
    }

    public void chooseList(){
        System.out.println("Введите номер арены, в которую хотите войти: ");
        indexArena = scanner.nextInt();
        System.out.printf("Вы вошли в Арену, как будете готовы вступайте в бой.");
    }

    public List<List<Unit>> getListOfLists(){
        return listOfLists;
    }
}
