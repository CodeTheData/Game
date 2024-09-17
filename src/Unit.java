public class Unit {
    private String name;
    private int healthPoints;
    private int damage;
    private Item item;
    private boolean isAlive = false;

    public void info(){
        System.out.printf("Unit %s enter to Arena!\nCurrent HP: %d\nCurrent AA: %d\n", this.name, this.healthPoints,  this.damage);
    }

    public boolean checkIsAlive(){
        if(healthPoints < 0){
            System.out.printf("%s вышел из боя!", getName());
            isAlive = false;
        } else {
            System.out.printf("%s готов сражаться!", getName());
            isAlive = true;
        }
        return isAlive;
    }

    public void takeDamage(Unit enemy) {
        System.out.printf("%s атакует %s и наносит %d урона!\n", name, enemy.getName(), damage);
        enemy.loseHealth(damage);
    }

    public void loseHealth(int amount){
        this.healthPoints -= amount;
        if(this.healthPoints < 0){
            this.healthPoints = 0;
        }
        System.out.printf("%s получает %d урона. Осталось НР: %d\n", name, amount, healthPoints);
    }

    public Unit(String name){
        this.name = name;
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
