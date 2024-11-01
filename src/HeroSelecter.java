import java.util.List;
import java.util.Scanner;

public class HeroSelecter {
    Scanner scanner = new Scanner(System.in);
    private int indexHero;
    private Unit mainPlayer;

    public void select(List<Unit> members){
        System.out.println("Введите номер игрока, которого хотите выбрать: ");
        indexHero = scanner.nextInt();
        mainPlayer = members.get(indexHero);

        System.out.println("Основной герой: " + mainPlayer.getName());

    }

    public int getIndexHero() {
        return indexHero;
    }

    public void setIndexHero(int indexHero) {
        this.indexHero = indexHero;
    }

    public Unit getMainPlayer() {
        return mainPlayer;
    }

    public void setMainPlayer(Unit mainPlayer) {
        this.mainPlayer = mainPlayer;
    }
}
