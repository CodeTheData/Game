import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Arena arena = new Arena();

        Unit player1 = new Unit("Artur", 115, 7, 1);
        Unit player2 = new Unit("Deonis", 125, 9, 1);
        Unit player3 = new Unit("Gerakle", 110, 11, 1);

        List<Unit> members = new ArrayList<>();
        members.add(player1);
        members.add(player2);
        members.add(player3);

        Item item1 = new Item("Перчатки легендарного бойца", 10, 3);
        Item item2 = new Item("Ботинки ниндзя", 3, 5);
        Item item3 = new Item("Кольцо силы", 15, 2);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        try {
            arena.start(arena, members, items);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}