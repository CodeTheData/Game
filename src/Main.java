import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Arena arena = new Arena();

        Unit player1 = new Unit("Artur", 100, 5);
        Unit player2 = new Unit("Deonis", 80, 6);
        Unit player3 = new Unit("Gerakle", 110, 9);

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


        if (arena.open(members) == true) {
            System.out.println("\nАрена встречает бойцов! Да начнется битва!!!\n");
            for (Unit unit : members) {
                unit.info();
                unit.getAndApplyItem(unit.equipment(items));
                System.out.println("Баффы получены!");
                unit.info();
            }

        } else {
            System.out.println("\nНе хватает участников для начала битвы!\n");
        }
        System.out.print("В инвентаре арены лежит следующее снаряжение: ");
        for(Item item : items){
            item.infoOfItem();
        }

        System.out.println("\n");


        arena.fight(members);

    }
}