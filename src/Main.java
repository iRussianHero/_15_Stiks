import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        Boolean continiune = true;
        do {
            continiune = game.Move(continiune);
        }
        while (continiune == true);
    }


}
class Game{
    Integer stiks;
    Boolean player;

    public Game(){
        this.stiks = 3;
        this.player = true;
    }


    Integer choise (){
        System.out.println("Осталось " + stiks + " палочек.");
        System.out.println("Ход грока " + (this.player?"1":"2") + ", введите число палочек:");
        Integer choise;
        do{
            Scanner in = new Scanner(System.in);
            choise = in.nextInt();
        }
        while (choise<1 || choise>3 || choise > stiks);
        this.player = !player;
        return choise;
    }

    boolean Move(Boolean continiune){
        if (stiks == 1) {
            System.out.println("==1, " + stiks);
            System.out.println("Игрок " + (player?"1":"2") + " проиграл!");
            return false;
        }
        else if (stiks == 0) {
            System.out.println("==0, " + stiks);
            System.out.println("Игрок " + (player ? "2" : "1") + " проиграл!");
            return false;
        }
        else {
            System.out.println(">3," + stiks);
            stiks = stiks - this.choise();
            if (stiks == 0) {
                System.out.println("Игрок " + (player ? "2" : "1") + " проиграл!");
                return false;
            }
        }
        return true;
    }
}