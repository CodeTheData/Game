import java.util.Random;

public class Unit {
    private String name;
    private int id;
    private int level = 1;
    private int experiance;
    private int healthPoints;
    private int damage;
    private Item item;
    private boolean isAlive;
    private boolean isWinner;

    Random random = new Random();

    public void experianceUp(){
    }

    public void levelUp(){
        level++;
    }

    public void getAndApplyItem(Item item){
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

    public Unit(int id, String name, int healthPoints, int damage, int level, int experiance){
        this.id = id;
        this.name = name;
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.level = level;
        this.experiance = experiance;
    }

    public Unit(){

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

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsWinner(){
        return isWinner;
    }

    public int getExperianceHero(){
        return experiance;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
