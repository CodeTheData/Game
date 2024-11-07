import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnitsPrison {
    List<Unit> easyMembers;
    List<Unit> mediumMembers;
    List<Unit> hardMembers;

    public Unit createUnit(int id, String name, int healthPoints, int damage, int experiance){
        return new Unit(id, name, healthPoints, damage, 1,  0);
    }

    public UnitsPrison(){
        easyMembers = new ArrayList<>();
        mediumMembers = new ArrayList<>();
        hardMembers = new ArrayList<>();
        initializeUnit();
    }

    public void initializeUnit(){
        easyMembers.add(createUnit(1, "Боец", 120, 15,  0));
        easyMembers.add(createUnit(2, "Враг1", 15, 9,  25));
        easyMembers.add(createUnit(3, "Враг2", 15, 11,  25));

        mediumMembers.add(createUnit(4,"Враг11", 170, 15,  50));
        mediumMembers.add(createUnit(5,"Враг22", 180, 17,  50));
        mediumMembers.add(createUnit(6,"Враг33", 175, 18,  50));

        hardMembers.add(createUnit(7, "Враг111", 250, 22,  100));
        hardMembers.add(createUnit(8, "Враг222", 260, 20,  100));
    }

    public List<Unit> getEasyMembers() {
        return easyMembers;
    }

    public List<List<Unit>> getAllMembers(){
        List<List<Unit>> allMembers = new ArrayList<>();
        allMembers.add(easyMembers);
        allMembers.add(mediumMembers);
        allMembers.add(hardMembers);
        return allMembers;
    }
}
