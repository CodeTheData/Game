import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Item {
    private int upHp;
    private int upDmg;
    private String name;
    private List<Item> items;
    Random random = new Random();

    public Item(String name, int buffHp, int buffDmg){
        this.name = name;
        this.upHp = buffHp;
        this.upDmg = buffDmg;
    }

    public boolean isActive(){
        return this.upDmg != 0 && this.upHp != 0;
    }

    public void infoOfItem(){
        System.out.print(this.name + " / ");
    }

    public int getUpHp() {
        return upHp;
    }

    public void setUpHp(int buffHp){
        this.upDmg = buffHp;
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
