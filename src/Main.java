import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        Boolean continiune = true;
        do {
            continiune = game.Move();
        }
        while (continiune == true);
    }


}
class Game{
    Integer stiks;
    Boolean player;

    public Game(){
        this.stiks = 15;
        this.player = true;
    }


    Integer choise (){
        Integer value = 1;
        if (player){
            System.out.println("Осталось " + stiks + " палочек.");
            System.out.println("Ход грока " + (this.player?"1":"2") + ", введите число палочек:");
            Integer choise;
            do{
                Scanner in = new Scanner(System.in);
                choise = in.nextInt();
            }
            while (choise<1 || choise>3 || choise > stiks);
            return choise;
        }else {
            if (stiks>3){
                value = 3;
            }else if (stiks == 3){
                value = 2;
            }
            this.player = !player;
        }
        return value;
    }

    boolean Move(){
        if (stiks == 1) {
            System.out.println("Игрок " + (player?"ИИ":"ВЫ") + " проиграл!");
            return false;
        }
        else {
            stiks = stiks - this.choise();
            if (stiks == 0) {
                System.out.println("Игрок " + (player ? "Вы" : "ИИ") + " проиграл!");
                return false;
            }
        }
        return true;
    }
}