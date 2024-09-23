import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private List<Unit> members = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private boolean isOpened = false;

    public boolean open(List<Unit> members){
        if(members.size() >= 3){
            isOpened = true;
        }
        return isOpened;
    }

    public void printWinner(){
        for(Unit unit : members){
            if(unit.getHealthPoints() != 0){
                System.out.printf("%s одержал победу!\n", unit.getName());
            }
        }

    }

    public void fight(List<Unit> members){
        Random random = new Random();
        int countmembers = members.size();

        while(countmembers != 1){
            int attackerIndex = random.nextInt(members.size());
            Unit attacker = members.get(attackerIndex);

            if(attacker.getHealthPoints() == 0 && members.size() > 1){
                members.remove(attacker);
                countmembers--;
                System.out.printf("%s выбыл из битвы и не может атаковать!\n", attacker.getName());
            }

//            int defenderIndex = random.nextInt(members.size());
//            Unit defender = members.get(defenderIndex);
            int defenderIndex;
            do{
                defenderIndex = random.nextInt(members.size());
            } while(defenderIndex == attackerIndex || !members.get(defenderIndex).isAlive());
            Unit defender = members.get(defenderIndex);

            if(defender.getHealthPoints() == 0 && members.size() > 1){
//                attacker.getAndApplyItem(defender.getItem());
//                defender.setItem(null);
                members.remove(defender);
                countmembers--;
                System.out.printf("%s выбыл из битвы и не может защищаться!\n", defender.getName());
            }
            attacker.attackUnit(defender);
        }
        printWinner();
    }
    
}
