public class Item {
    private int damage;
    private int health;
    private String name;

    public Item(String name, int damage, int health){
        this.name = name;
        this.damage = damage;
        this.health = health;
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public String getName() {
        return name;
    }


}
