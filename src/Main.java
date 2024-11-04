import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Arena arena = new Arena();

        List<Unit> easyMembers = new ArrayList<>();

        Unit player1 = new Unit(1, "Боец", 120, 15, 1, 0);
        Unit player2 = new Unit(2, "Враг1", 15, 9, 1, 25);
        Unit player3 = new Unit(3, "Враг2", 15, 11, 1, 25);

        easyMembers.add(player1);
        easyMembers.add(player2);
        easyMembers.add(player3);

        List<Unit> mediumMembers = new ArrayList<>();

        Unit player11 = new Unit(11,"Враг11", 170, 15, 1, 50);
        Unit player22 = new Unit(22,"Враг22", 180, 17, 1, 50);

        mediumMembers.add(player11);
        mediumMembers.add(player22);

        List<Unit> hardMembers = new ArrayList<>();

        Unit player111 = new Unit(111, "Враг111", 250, 22, 1, 100);
        Unit player222 = new Unit(222, "Враг222", 260, 20, 1, 100);

        hardMembers.add(player111);
        hardMembers.add(player222);

        UnitsPrison unitPrison = new UnitsPrison();

        unitPrison.listOfLists.add(easyMembers);
        unitPrison.listOfLists.add(mediumMembers);
        unitPrison.listOfLists.add(hardMembers);

        Item item1 = new Item(1,"Трезубец",5, 500);
        Item item2 = new Item(2, "Крылатые ботинки", 2, 2, 500);
        Item item3 = new Item(3, 6,"Световая повязка", 700);
        Item item4 = new Item(4, "Дубина", 6, 700);
        Item item5 = new Item(5, "Боевой топор", 3, 8, 1000);
        Item item6 = new Item(6, "Молния", 10, 1000);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        //20:32
        try {
            arena.start(unitPrison.listOfLists, items);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}