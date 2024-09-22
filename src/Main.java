import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Unit player1 = new Unit("Artur", 100, 5);
        Unit player2 = new Unit("Deonis", 110, 3);
        Unit player3 = new Unit("Gerakle", 90, 7);

        Arena arena = new Arena();
        List<Unit> members = new ArrayList<>();
        members.add(player1);
        members.add(player2);
        members.add(player3);

        if(arena.open(members) == true)
            System.out.println("Арена встречает бойцов! Да начнется битва!!!\n");
        else
            System.out.println("Не хватает участников для начала битвы!\n");

        for(Unit u : members){
            u.info();
        }

        arena.fight(members);
    }
}