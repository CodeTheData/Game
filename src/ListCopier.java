import java.util.ArrayList;
import java.util.List;

public class ListCopier {
    List<Unit> listMember;

    public void copyOfOriginalList(List<Unit> mainPlayers){
        listMember = new ArrayList<>(mainPlayers);
    }
}
