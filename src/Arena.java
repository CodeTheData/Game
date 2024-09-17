import java.util.ArrayList;
import java.util.List;

public class Arena {
    private List<Unit> members = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private boolean isOpened = false;

    public boolean open(List<Unit> members){
        if(members.size() < 3){ //вопрос Юре, если хочу сделать переменную минимального значения участников
                                //то глобальная или локальная переменная внутри метода нужна?
            System.out.println("Не хватает людей для начала битвы!");
            isOpened = false;
        } else {
            System.out.println("Арена встречает бойцов! Да начнется битва!!!");
            isOpened = true;
        }
        return isOpened;
    }




}
