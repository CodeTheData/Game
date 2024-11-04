import java.util.List;
import java.util.Scanner;

public class HeroSelecter {
    Scanner scanner = new Scanner(System.in);
    private int indexHero;

    public void select(List<Unit> members){
        System.out.println("Введите номер игрока, которого хотите выбрать: ");
        indexHero = scanner.nextInt();
        System.out.println("Основной герой: " + members.get(indexHero).getName());
    }

    public int getIndexHero() {
        return indexHero;
    }

    public void setIndexHero(int indexHero) {
        this.indexHero = indexHero;
    }


}
