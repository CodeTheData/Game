import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Unit player1 = new Unit("Artur");
        Unit player2 = new Unit("Deonis");
        Unit player3 = new Unit("Gerakle");

        Arena arena = new Arena();
        List<Unit> members = new ArrayList<>();
        members.add(player1);
        members.add(player2);
        members.add(player3);

        System.out.println(arena.open(members));
        for(Unit u : members){
            u.info();
        }
    }
}