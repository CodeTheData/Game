import java.util.List;
import java.util.Scanner;

public class HeroSelecter {
    Scanner scanner = new Scanner(System.in);
    int indexHero;

    public void select(List<Unit> members){
        System.out.println("Введите номер игрока, которого хотите выбрать: ");
        indexHero = scanner.nextInt();
        Unit mainPlayer = members.get(indexHero);

        System.out.println("Основной герой: " + mainPlayer.getName());




        //тут по хорошему сделать исключение nullPointerException или проверку выхода за рамки листа(так думаю)
//        switch (indexHero){
//            case 0:
//                mainPlayer = members.get(indexHero);
//                break;
//            case 1:
//                mainPlayer = members.get(indexHero);
//                break;
//            case 2:
//                mainPlayer = members.get(indexHero);
//                break;
//            default:
//                System.out.println("Такого индекса не существует! Попробуйте заново ");
//        }

    }
}
