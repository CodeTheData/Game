import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemsTrader {

    Random random = new Random();
    List<Item> items;

    public ItemsTrader(){
        items = new ArrayList<>();
        initializeItem();
    }

    public Item createItem(int id, String name, int upHp, int upDmg, int price){
        return new Item(id, name, upHp, upDmg, price);
    }

    public void initializeItem(){
        items.add(createItem(1,"Трезубец",0, 5, 5));
        items.add(createItem(2, "Крылатые ботинки", 2, 2, 5));
        items.add(createItem(3,"Световая повязка", 6,0, 7));
        items.add(createItem(4, "Дубина", 0, 6, 7));
        items.add(createItem(5, "Боевой топор", 3, 8, 10));
        items.add(createItem(6, "Молния", 0, 10, 10));
    }

    public Item giveRandomItem(){
        int indexItem = random.nextInt(items.size());
        Item item = items.get(indexItem);
        return item;
    }

    public List<Item> getItems() {
        return items;
    }
}
