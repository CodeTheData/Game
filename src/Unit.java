import java.util.List;
import java.util.Random;

public class Unit {
    private String name;
    private int healthPoints;
    private int damage;
    private Item item;
    private boolean isAlive;

    Random random = new Random();

    public void getAndApplyItem(Item item){
        this.item = item;

        if(item.isActive()){
            this.healthPoints += item.getUpHp();
            this.damage += item.getUpDmg();
        } else {
            setItem(null);
        }
    }

    public void info(){
        System.out.printf("Unit %s enter to Arena!\nCurrent HP: %d\nCurrent DM: %d\n",
                this.name, this.healthPoints, this.damage);
    }

    public boolean isAlive(){
        return getHealthPoints() > 0;
    }

    public void attackUnit(Unit unit) {
        System.out.printf("%s атаковал %s и наносит %d урона!\n", name, unit.getName(), damage);
        unit.getUnitDamage(damage);
    }

    public void getUnitDamage(int damage){
        this.healthPoints -= damage;
        if(this.healthPoints < 0){
            this.healthPoints = 0;
        }
        System.out.printf("%s получает %d урона. Осталось НР: %d\n\n", name, damage, healthPoints);
    }

    public Unit(String name, int healthPoints, int damage){
        this.name = name;
        this.healthPoints = healthPoints;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


}
