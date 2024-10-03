import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    //можно сделать филды: вместимость арены, название арены, проверку кто хочет войти в арену?, а можно сделать арену для людей и для живтоных и совместку например?

    private List<Unit> members = new ArrayList<>();
    private boolean isOpened;
    Random random = new Random();

    public boolean open(List<Unit> members){
        return members.size() >= 3;
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

    public void printWinner(List<Unit> members){
        for(Unit u : members){
            if(u.isAlive()){
                System.out.println("Победителем становиться - " + u.getName() + "!!!");
            }
        }
    }

    public void fight(List<Unit> members){

        int countmembers = members.size();

        while(countIsAliveUnits(members) > 1){
            int attackerIndex = random.nextInt(members.size());
            Unit attacker = members.get(attackerIndex);
            int defenderIndex = random.nextInt(members.size());
            Unit defender = members.get(defenderIndex);

//            int indexItem = random.nextInt(items.size());
//
//            attacker.getAndApplyItem(items.get(indexItem));
//            defender.getAndApplyItem(items.get(indexItem));

            if(attackerIndex == defenderIndex) { //Если выпадет так что на этом моменте не пропустило на следующий if, а игрок был мертвым, то только через итеррацию будет выводится sout!
                continue;
            } else if (!attacker.isAlive()) {
                members.remove(attacker);
                countmembers--;
                System.out.println(attacker.getName() + " выбывает из битвы!\n");
                continue;
            } else if (!defender.isAlive()){
                members.remove(defender);
                countmembers--;
                System.out.println(defender.getName() + " выбывает из битвы!\n");
                continue;
            }
            attacker.attackUnit(defender);
        }
        printWinner(members);
    }
    
}
