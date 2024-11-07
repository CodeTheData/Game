import java.util.List;
import java.util.Random;

public class Arena {

    private boolean isArenaOpened;
    private boolean isHeroWin;
    int indexWinner;
    int indexPlayer;
    List<Item> items;

    Random random = new Random();
    ItemsTrader itemsTrader = new ItemsTrader();
    HeroSelecter heroSelecter = new HeroSelecter();


    public void getResultFight(List<Unit> list) throws InterruptedException {
        if(list.get(indexWinner).getId() == list.get(heroSelecter.getIndexHero()).getId()){
            list.get(heroSelecter.getIndexHero()).levelUp();
            System.out.printf("%s поздравляем вас с победой на Арене! Уровень героя повысился и стал равен - %d! " +
                    "\nИдет переход на новую Арену...\n\n", list.get(heroSelecter.getIndexHero()).getName(), list.get(heroSelecter.getIndexHero()).getLevel());
        } else {
            list.get(heroSelecter.getIndexHero()).levelUp();
            System.out.printf("В этот раз победу одержал %s его уровень повысился и стал равен - %d, испытай удачу в следующий раз! \n",
                    list.get(indexWinner).getName(), list.get(indexWinner).getLevel());
        }
    }

    public void giveInfoAboutPlayers(List<Unit> members) throws InterruptedException {
        for (Unit unit : members) {
            unit.infoAboutUnit();
            unit.getAndApplyItem(itemsTrader.giveRandomItem());
            System.out.printf("Игрок получил новый предмет - %s!\n", unit.getItem().getName());
            unit.infoChangeAboutUnit();
            System.out.println();
            Thread.sleep(1000);
        }
    }

    public void start(List<List<Unit>> allMembers, List<Item> items) throws InterruptedException {

        heroSelecter.select(allMembers.get(0));

        for (int i = 0; i < allMembers.size(); i++) {
            if (open(allMembers.get(i)) != true) {
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

            giveInfoAboutPlayers(allMembers.get(i));

            fight(allMembers.get(i));

            getResultFight(allMembers.get(i));
        }

    }

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
