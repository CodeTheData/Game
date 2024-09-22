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
        //если в списке остается один победитель, то может без цикла могу
        //просто через мемберс.гет как-нибудь? - опробуй
        for(Unit unit : members){
            if(unit.isAlive() == true){
                System.out.printf("%s одержал победу!\n", unit.getName());
                break;
            }
        }
    }

    public void fight(List<Unit> members){
        Random random = new Random();

        while(members.size() > 1){
            int attackerIndex = random.nextInt(members.size());
            Unit attacker = members.get(attackerIndex);

//            if(!attacker.isAlive()){
//                members.remove(attacker);
//                System.out.printf("%s выбыл из битвы и не может атаковать!\n", attacker.getName());
//            }

//            int defenderIndex = random.nextInt(members.size());
//            Unit defender = members.get(defenderIndex);
            int defenderIndex;
            do{
                defenderIndex = random.nextInt(members.size());
            } while(defenderIndex == attackerIndex || !members.get(defenderIndex).isAlive());
            Unit defender = members.get(defenderIndex);

//            if(!defender.isAlive()){
////                attacker.getAndApplyItem(defender.getItem());
////                defender.setItem(null);
//                members.remove(defender);
//                System.out.printf("%s выбыл из битвы и не может защищаться!\n", defender.getName());
//            }
            attacker.attackUnit(defender, members);
        }
        printWinner();
    }
    
}
