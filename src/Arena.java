import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Arena {

    //можно сделать филды: вместимость арены, название арены, проверку кто хочет войти в арену?, а можно сделать арену для людей и для живтоных и совместку например?
    
    private boolean isOpened;
    private boolean isWin;
    int indexWinner = 0;
    int indexPlayer = 0;
    int checkIndex = 0;

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public void start(Arena arena, List<Unit> members, List<Item> items) throws InterruptedException {

        pickMainPlayer(members);

        if (arena.open(members) != true) {
            System.out.println("\nНе хватает участников для начала битвы!\n");
            return;
        } else {
            System.out.println("\nАрена встречает бойцов! Да начнется битва!!!\n");
        }

        System.out.print("В инвентаре арены лежит следующее снаряжение: ");

        for(Item item : items){
            item.printItemInfo();
        }
        System.out.println("\n");

        getListMembers(members, items);

        arena.fight(members);

//        isWinGameArena(members);
    }

    public void isWinGameArena(List<Unit> members){
        if(indexPlayer == indexWinner){
            System.out.printf("%s поздравляем вас с победой на Арене легкой сложности! Ваш личный уровень повысился и стал - %d! " +
                    "\nИдет переход на новую Арену...", members.get(indexPlayer), members.get(indexPlayer).getLevel());
        } else {
            System.out.printf("В этот раз победу одержал %s, возвращайся в следующий раз и докажи, что ты достоин победы!", members.get(indexWinner).getName());
        }

    }

    public boolean open(List<Unit> members){
        return members.size() >= 3;
    }

    public void getListMembers(List<Unit> members, List<Item> items) throws InterruptedException {
        for (Unit unit : members) {
            Thread.sleep(2500);
            unit.infoSpecs();
            Thread.sleep(2500);
            unit.getAndApplyItem(unit.chooseRandomItem(items));
            System.out.printf("Получен новый предмет - %s!\n", unit.getItem().getName());
            Thread.sleep(2500);
            unit.infoCurrentSpecs();
            System.out.println();
        }
    }

    public void pickMainPlayer(List<Unit> members){
        System.out.println("Введите номер игрока, которого хотите выбрать: ");
        int indexPlayer = scanner.nextInt();
        Unit mainPlayer = null;

        //тут по хорошему сделать исключение nullPointerException или проверку выхода за рамки листа(так думаю)
        switch (indexPlayer){
            case 0:
                mainPlayer = members.get(indexPlayer);
                break;
            case 1:
                mainPlayer = members.get(indexPlayer);
                break;
            case 2:
                mainPlayer = members.get(indexPlayer);
                break;
            default:
                System.out.println("Такого индекса не существует! Попробуйте заново ");
//                try {
//
//                } catch (){
//
//                }
        }
        System.out.println(mainPlayer.getName());
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

    public void fight(List<Unit> members) throws InterruptedException {

        while(countIsAliveUnits(members) > 1){
            int attackerIndex = random.nextInt(members.size());
            Unit attacker = members.get(attackerIndex);
            int defenderIndex = random.nextInt(members.size());
            Unit defender = members.get(defenderIndex);

            indexWinner = attackerIndex;

            if(attackerIndex == defenderIndex) { //Если выпадет так что на этом моменте не пропустило на следующий if, а игрок был мертвым, то только через итеррацию будет выводится sout!
                continue;
            } else if (!attacker.isAlive()) {
                Thread.sleep(2500);
                System.out.println(attacker.getName() + " выбывает из битвы!\n");
                members.remove(attacker);
                continue;
            } else if (!defender.isAlive()){
                Thread.sleep(2500);
                System.out.println(defender.getName() + " выбывает из битвы!\n");
                members.remove(defender);
                continue;
            }
            Thread.sleep(2500);
            attacker.attackUnit(defender);
        }

        Thread.sleep(2500);
        System.out.println("Победителем становится: " + members.get(indexWinner).getName() + " !!!\n");

    }

}
