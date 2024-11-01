import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Arena arena = new Arena();

        List<Unit> easyMembers = new ArrayList<>();

        Unit player1 = new Unit("Кратос", 150, 15, 1);
        Unit player2 = new Unit("Посейдон", 100, 9, 1);
        Unit player3 = new Unit("Гермес", 100, 11, 1);

        easyMembers.add(player1);
        easyMembers.add(player2);
        easyMembers.add(player3);

        List<Unit> mediumMembers = new ArrayList<>();

        Unit player11 = new Unit("Гелиос", 170, 15, 1);
        Unit player22 = new Unit("Геркулес", 180, 17, 1);

        mediumMembers.add(player11);
        mediumMembers.add(player22);

        List<Unit> hardMembers = new ArrayList<>();

        Unit player111 = new Unit("Аид", 250, 22, 1);
        Unit player222 = new Unit("Зевс", 260, 20, 1);

        hardMembers.add(player111);
        hardMembers.add(player222);

        Item item1 = new Item("Трезубец",5);
        Item item2 = new Item("Крылатые ботинки", 2, 2);
        Item item3 = new Item(6,"Световая повязка");
        Item item4 = new Item("Дубина", 6);
        Item item5 = new Item("Боевой топор", 3, 8);
        Item item6 = new Item("Молния", 10);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        try {
            arena.start(arena, easyMembers, items);
            arena.getResultFight(easyMembers, mediumMembers, items);
            arena.getResultFight(mediumMembers, hardMembers, items);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}