import java.util.List;

public class Unit {
    private String name;
    private int healthPoints;
    private int damage;
    private Item item;
    private boolean isAlive;

    public void getAndApplyItem(Item item){
        this.item = item;
        this.healthPoints += item.getHealth();
        this.damage += item.getDamage();
    }

    public void info(){
        System.out.printf("Unit %s enter to Arena!\nCurrent HP: %d\nCurrent DM: %d\n",
                this.name, this.healthPoints, this.damage);
    }

    public boolean isAlive(){
        if(healthPoints > 0){
            isAlive = true;
        }
        return isAlive;
    }

    public void attackUnit(Unit unit, List<Unit> members) {
        System.out.printf("%s атаковал %s и наносит %d урона!\n", name, unit.getName(), damage);
        unit.getUnitDamage(damage);
        if(!unit.isAlive()){
            members.remove(unit);
            System.out.printf("%s выбыл из битвы и не может атаковать!\n", unit.getName());
        }
    }

    public void getUnitDamage(int damage){
        this.setHealthPoints(getHealthPoints() - damage);
        if(healthPoints < 0){
            this.healthPoints = 0;
        }

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