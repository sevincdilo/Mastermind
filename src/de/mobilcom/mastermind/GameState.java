package de.mobilcom.mastermind;
import java.util.ArrayList;
public class GameState {
    public static void main(String[] args) {
        int colors =8;
        int fields=4;
        int trycount = 10;
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(1);
        x.add(2);



        for (int zahl : x){
            System.out.println(zahl);
        }

    }
}


//ublic void givenList__shouldReturnARandomElement() {
//    List<Integer> givenList = Arrays.asList(1, 2, 3);
//    Random rand = new Random();
//    int randomElement = givenList.get(rand.nextInt(givenList.size()));
//}
