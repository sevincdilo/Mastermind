package de.mobilcom.mastermind.frontend;

import de.mobilcom.mastermind.model.GameState;

import de.mobilcom.mastermind.service.MastermindService;

import java.util.Arrays;
import java.util.Scanner;

public class Terminal {



        public void start(GameState state) {

            MastermindService service = new MastermindService();


            System.out.println("Lets start the Game");
            System.out.println("You can choose between 0 - " + (state.getColors() -1) + " colors");
            System.out.println(Arrays.toString(state.getComputerCombination()));
            boolean won = false;
            for(int i=0; i< state.getTryCount(); i++) {
                displayBoard(state);
                if (!state.getAttempts().isEmpty() && (state.getFields() == state.getAttempts().get(i-1).getRightPositionAndColorCount() )){

                    System.out.println("You win the Game");
                    won=true;
                    break;
                }

                readCombination(state, service);
            }
            if(!won)
                System.out.println("You lose the Game");
            }



        private void displayBoard(GameState state){


           for(int i=0; i< state.getAttempts().size(); i++) {
               StringBuilder sb = new StringBuilder();

               sb.append("Try Number: ").append(i+1).append("  Chosen colors: ");
               for (int combiCount = 0; combiCount < state.getFields();combiCount++) {
                sb.append(state.getAttempts().get(i).getPlayerCombination()[combiCount]);

               }
               System.out.println(String.format("Max Tries: %s, %s,  Right: %s, Right Color: %s", state.getTryCount(), sb,  state.getAttempts().get(i).getRightPositionAndColorCount(), state.getAttempts().get(i).getRightColorCount()));

           }


        }
        private  void readCombination(GameState state, MastermindService service){
           int[] playerCombination = new int[state.getFields()] ;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Your Try");

            for(int i=0; i< state.getFields();i++){
                int z = 1+i;
                System.out.println("\n Choose your " + z + " number : " );
                playerCombination[i]= scanner.nextInt();

            }

            service.guess(state,playerCombination);



        }



    }



