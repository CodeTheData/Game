import java.util.Random;

public class Item {
    private int upHp;
    private int upDmg;
    private String name;
    Random random = new Random();

    public boolean isActive(){
        return this.upDmg != 0 || this.upHp != 0;
    }

    public void printItemInfo(){
        System.out.print(this.name + " / ");
    }

    public Item(String name, int buffHp, int buffDmg){
        this.name = name;
        this.upHp = buffHp;
        this.upDmg = buffDmg;
    }

    public Item(String name, int buffDmg){
        this.name = name;
        this.upDmg = buffDmg;
    }

    public Item(int buffHp, String name){
        this.name = name;
        this.upHp = buffHp;
    }

    public int getUpHp() {
        return upHp;
    }

    public void setUpHp(int buffHp){
        this.upHp = buffHp;
    }

    public int getUpDmg() {
        return upDmg;
    }

    public void setUpDmg(int upDmg) {
        this.upDmg = upDmg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
