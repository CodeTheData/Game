import org.w3c.dom.ls.LSOutput;

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

    public int countIsAlive(List<Unit> members){
        int countAlive = 0;
        for (int i = 0; i < members.size(); i++) {
            if(members.get(i).isAlive()){
                countAlive++;
            }
        }
        return countAlive;
    }

    public void fight(List<Unit> members){
        Random random = new Random();
        int countmembers = members.size();

//        while(countmembers > 1){
//            int attackerIndex = random.nextInt(members.size());
//            Unit attacker = members.get(attackerIndex);
//
//            if(attacker.getHealthPoints() == 0){
//                members.remove(attacker);
//                countmembers--;
//                System.out.printf("%s выбывает из битвы и не может атаковать!\n", attacker.getName());
//                System.out.println();
//                System.out.println(members);
//            }
//
//            int defenderIndex;
//            defenderIndex = random.nextInt(members.size());
//            Unit defender = members.get(defenderIndex);
////            do{
////
////            } while(defenderIndex == attackerIndex || !members.get(defenderIndex).isAlive());
////            Unit defender = members.get(defenderIndex);
//
//            if(defender.getHealthPoints() == 0){
////                attacker.getAndApplyItem(defender.getItem());
////                defender.setItem(null);
//                members.remove(defender);
//                countmembers--;
//                System.out.printf("%s выбывает из битвы и не может защищаться!\n", defender.getName());
//                System.out.println();
//            }
//
////            if(countmembers > 1){
//                attacker.attackUnit(defender);
////            }
//
//
//        }
        while(countIsAlive(members) > 1){
            int attackerIndex = random.nextInt(members.size());
            Unit attacker = members.get(attackerIndex);
            int defenderIndex = random.nextInt(members.size());
            Unit defender = members.get(defenderIndex);

            if(attackerIndex == defenderIndex) {
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

//            if(attacker.getHealthPoints() < 0 || attacker.getHealthPoints() == 0){
//                members.remove(attacker);
//                countmembers--;
//            }
//
//            if(defender.getHealthPoints() < 0 || defender.getHealthPoints() == 0){
//                members.remove(defender);
//                countmembers--;
//                System.out.println(defender.getName() + " выбывает из битвы!");
//            }
            attacker.attackUnit(defender);
        }

        for(Unit u : members){
            if(u.isAlive()){
                System.out.println("Победителем становиться - " + u.getName() + "!!!");
            }
        }
    }
    
}
