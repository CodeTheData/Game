import java.util.List;
import java.util.Random;

public class Unit {
    private String name;
    private int healthPoints;
    private int damage;
    private Item item;
    private boolean isAlive;
    private int level = 1;
    private int experiance; // за убийство врага юнит получает 30 опыта, для получения лвл ап необходимо 90!
    //когда мой герой убивает врага он получает опыт и переход по аренам , где враги сильнее
    public boolean isWinner;

    Random random = new Random();

    public void levelUp(){
        this.level += 1;

    }

    public void getAndApplyItem(Item item){
        this.item = item;

        if(item.isActive()){
            this.healthPoints += item.getUpHp();
            this.damage += item.getUpDmg();
        } else {
            setItem(null);
        }
    }

    public void infoAboutUnit(){
        System.out.printf("Unit %s enter to Arena! Current HP: %d Current DM: %d Current Lvl: %d\n",
                this.name, this.healthPoints, this.damage, this.getLevel());
    }

    public void infoChangeAboutUnit(){
        System.out.printf("Изменения вступили в силу, характеристики героя улучшены!\nCurrent HP: %d Current DM: %d\n",
                this.healthPoints, this.damage);
    }

    public boolean isAlive(){
        return getHealthPoints() > 0;
    }

    public void attackUnit(Unit unit) {
        System.out.printf("%s атакует %s и наносит %d урона\n", name, unit.getName(), damage);
        unit.getUnitDamage(damage);
    }

    public void getUnitDamage(int damage){
        this.healthPoints -= damage;
        if(this.healthPoints < 0){
            this.healthPoints = 0;
        }
        System.out.printf("%s получает %d урона. Осталось НР: %d\n\n", name, damage, healthPoints);
    }

    public Unit(String name, int healthPoints, int damage, int level){
        this.name = name;
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.level = level;
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

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getExperiance(){
        return experiance;
    }

    public void setExperiance(){
        this.experiance = experiance;
    }

}
