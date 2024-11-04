import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Arena {

    //можно сделать филды: вместимость арены, название арены, проверку кто хочет войти в арену?, а можно сделать арену для людей и для живтоных и совместку например?

    private boolean isArenaOpened;
    private boolean isHeroWin;
    int indexWinner;
    int indexPlayer;
    HeroSelecter selecter = new HeroSelecter();
    UnitsPrison UnitsPrison = new UnitsPrison();

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

//    public void switchToArena(List<Unit> list){
//        if(list.get(selecter.getIndexHero()).getExperianceHero() == 50){
//            fight();
//        }
//    }

    public void getResultFight(List<Unit> list) throws InterruptedException {
        if(indexWinner == selecter.getIndexHero()){
            list.get(selecter.getIndexHero()).levelUp();
            System.out.printf("%s поздравляем вас с победой на Арене! Уровень героя повысился и стал равен - %d! " +
                    "\nИдет переход на новую Арену...\n\n", list.get(selecter.getIndexHero()).getName(), list.get(selecter.getIndexHero()).getLevel());
        } else {
            list.get(selecter.getIndexHero()).levelUp();
            System.out.printf("В этот раз победу одержал %s его уровень повысился и стал равен - %d, испытай удачу в следующий раз! \n",
                    list.get(indexWinner).getName(), list.get(indexWinner).getLevel());
        }
    }

    public void start(List<List<Unit>> listOfList, List<Item> items) throws InterruptedException {

        selecter.select(listOfList.get(0));

        for (int i = 0; i < listOfList.size(); i++) {
            if (open(listOfList.get(i)) != true) {
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

            getInfoAboutPlayers(listOfList.get(i), items);

            fight(listOfList.get(i));

            getResultFight(listOfList.get(i));
        }

    }

    public Item chooseRandomItem(List<Item> items){
        int indexItem = random.nextInt(items.size());
        Item item = items.get(indexItem);
        return item;
    }

    public boolean open(List<Unit> members){
        return members.size() >= 3;
    }

    public void getInfoAboutPlayers(List<Unit> members, List<Item> items) throws InterruptedException {
        for (Unit unit : members) {
            unit.infoAboutUnit();
            unit.getAndApplyItem(chooseRandomItem(items));
            System.out.printf("Получен новый предмет - %s!\n", unit.getItem().getName());
            unit.infoChangeAboutUnit();
            System.out.println();
            Thread.sleep(1000);
        }
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

            if(attackerIndex == defenderIndex) {
                continue;
            } else if (!attacker.isAlive()) {
                members.get(defenderIndex).experianceUp();
                System.out.println(attacker.getName() + " выбывает из битвы!\n");
                members.remove(attacker);
                continue;
            } else if (!defender.isAlive()){
                System.out.println(defender.getName() + " выбывает из битвы!\n");
                members.remove(defender);
                continue;
            }

            indexWinner = attackerIndex;

            attacker.attackUnit(defender);
            Thread.sleep(1000);
        }

        System.out.println("Победителем становится: " + members.get(indexWinner).getName() + " !!!\n");

    }

}
