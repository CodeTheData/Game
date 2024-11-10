import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Arena arena = new Arena();
        HeroSelecter selecter = new HeroSelecter();
        UnitsPrison unitsPrison = new UnitsPrison();
        ItemsTrader itemsTrader = new ItemsTrader();



        //20:32
        try {
            arena.start(unitsPrison.getAllMembers(), itemsTrader.getItems());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}