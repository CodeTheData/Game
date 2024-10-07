import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    //можно сделать филды: вместимость арены, название арены, проверку кто хочет войти в арену?, а можно сделать арену для людей и для живтоных и совместку например?
    
    private boolean isOpened;
    Random random = new Random();

    public boolean open(List<Unit> members){
        return members.size() >= 3;
    }

    public void getListMembers(List<Unit> members, List<Item> items){
        for (Unit unit : members) {
            unit.infoSpecs();
            unit.getAndApplyItem(unit.chooseRandomItem(items));
            System.out.println("Баффы получены!");
            unit.infoCurrentSpecs();
            System.out.println();
        }
    }

    public void start(Arena arena, List<Unit> members, List<Item> items){
        if (arena.open(members) != true) {
            System.out.println("\nНе хватает участников для начала битвы!\n");
            return;
        } else {
            System.out.println("\nАрена встречает бойцов! Да начнется битва!!!\n");
        }

        getListMembers(members, items);

        System.out.print("В инвентаре арены лежит следующее снаряжение: ");

        for(Item item : items){
            item.printItemInfo();
        }
        System.out.println("\n");

        arena.fight(members);
    }

    public int countIsAliveUnits(List<Unit> members){
        int countAlive = 0;
        for (int i = 0; i < members.size(); i++) {
            if(members.get(i).isAlive()){
                countAlive++;
            }
        }
        return countAlive;
    }

    public void fight(List<Unit> members){

        int countmembers = members.size();
        int indexWinner = 0;

        while(countIsAliveUnits(members) > 1){
            int attackerIndex = random.nextInt(members.size());
            Unit attacker = members.get(attackerIndex);
            int defenderIndex = random.nextInt(members.size());
            Unit defender = members.get(defenderIndex);

            indexWinner = attackerIndex;

            if(attackerIndex == defenderIndex) { //Если выпадет так что на этом моменте не пропустило на следующий if, а игрок был мертвым, то только через итеррацию будет выводится sout!
                continue;
            } else if (!attacker.isAlive()) {
                System.out.println(attacker.getName() + " выбывает из битвы!\n");
                members.remove(attacker);
                countmembers--;
                continue;
            } else if (!defender.isAlive()){
                System.out.println(defender.getName() + " выбывает из битвы!\n");
                members.remove(defender);
                countmembers--;
                continue;
            }
            attacker.attackUnit(defender);
        }
        System.out.println("Победителем становится: " + members.get(indexWinner).getName() + " !!!");
    }
}
