import java.util.Random;

public class Item {
    private int id;
    private String name;
    private int upHp;
    private int upDmg;
    private int price;
    Random random = new Random();

    public boolean isActive(){
        return this.upDmg != 0 || this.upHp != 0;
    }

    public void printItemInfo(){
        System.out.print(this.name + " / ");
    }

    public Item(int id, String name, int buffHp, int buffDmg, int price){
        this.id = id;
        this.name = name;
        this.upHp = buffHp;
        this.upDmg = buffDmg;
        this.price = price;
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

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

}
