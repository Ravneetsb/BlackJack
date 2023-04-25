import java.util.ArrayList;

public class PlayStyle {
    private static int sum;
    private static int money;
    private static String dCard;
    private static int bet;
    public static String evaluate(ArrayList<String> myCards, String dealerCard, int cardSum, int moneyInPlay, int betInfo){
        sum = cardSum;
        money = moneyInPlay;
        dCard = dealerCard;
        bet = betInfo;
        String play;
        if (myCards.size() == 2){
            if (myCards.contains("A")){
                play = acePlay(myCards);
            } else if (myCards.get(0).equals(myCards.get(1))){
                play = pairPlay(myCards);
            } else{
                play = basicPlay(myCards);
            }
        } else play = basicPlay(myCards);
        return play;
    }
    private static String basicPlay(ArrayList<String> myCards){ // can double.
        String play;

        if (sum <= 8){
            play = "hit";
        } else if (sum == 9){
            if (dCard.equals("3") || dCard.equals("4") || dCard.equals("5") || dCard.equals("6")){
                if (money - (2*bet) >= 0){
                    if (myCards.size() == 2){
                        play = "double";
                    } else {
                        play = "hit";}
                } else {
                    play = "hit";}
            } else{
                play = "hit";
            }
        } else if (sum == 10){
            if (dCard.equals("1") || dCard.equals("A")){
                play = "hit";
            } else {
                if (money - (2*bet) >= 0){
                    if (myCards.size() == 2){
                        play  = "double";
                    } else{
                        play = "hit";
                    }
                } else{
                    play = "hit";
                }
            }
        } else if (sum == 11){
            if (money - (2*bet) >= 0){
                if (myCards.size() == 2){
                    play = "double";
                } else{
                    play = "hit";
                }
            } else{
                play = "hit";
            }
        } else if (sum == 12){
            if (dCard.equals("4") || dCard.equals("5") || dCard.equals("6")){
                play = "stand";
            } else{
                play = "hit";
            }
        } else if (sum == 13 || sum == 14 || sum == 15 || sum == 16){
            if (dCard.equals("2") || dCard.equals("3") || dCard.equals("4") || dCard.equals("5") || dCard.equals("6")){
                play = "stand";
            } else{
                play = "hit";
            }
        } else {
            play = "stand";
        }
        return play;
    }
    private static String pairPlay(ArrayList<String> myCards){
        String play;
        if (sum == 20){
            play = "stand";
        }
        else if (sum == 18){
            if (dCard.equals("7") || dCard.equals("10") || dCard.equals("A")){
                play = "split";
            }
            else play = "stand";
        }
        else if (sum == 16){
            if (money-(2*bet) > 0){
                play = "split";
            }
            else play = basicPlay(myCards);
        }
        else if (sum == 14){
            if (dCard.equals("8") || dCard.equals("9") || dCard.equals("1") || dCard.equals("A")){
                play = basicPlay(myCards);
            }
            else {
                if (money - (2*bet) > 0){
                    play = "split";
                }
                else play = basicPlay(myCards);
            }
        }
        else if (sum == 12){
            if (dCard.equals("2") || dCard.equals("3") || dCard.equals("4") || dCard.equals("5") || dCard.equals("6")){
                if (money-(2*bet) > 0){
                    play = "split";
                }
                else play = basicPlay(myCards);
            }
            else play = basicPlay(myCards);
        }
        else if (sum == 10){
            play = basicPlay(myCards);
        }
        else if (sum == 8){
            if (dCard.equals("5") || dCard.equals("6")){
                if (money-(2*bet) > 0){
                    play = "split";
                }
                else play = basicPlay(myCards);
            }
            else play = basicPlay(myCards);
        }
        else if (sum == 6 || sum == 4){
            if (dCard.equals("8") || dCard.equals("9") || dCard.equals("1") || dCard.equals("A")){
                if (money-(2*bet) > 0){
                    play = "split";
                }
                else play = basicPlay(myCards);
            }
            else play = basicPlay(myCards);
        }
        else play = basicPlay(myCards);

        return play;
    }
    private static String acePlay(ArrayList<String> myCards){
        String play;
        if (myCards.get(0).equals(myCards.get(1))){
            if (money - (2*bet) >= 0){
                play = "split";
            }
            else play = basicPlay(myCards);
        }
        else if (sum ==13 || sum == 14){
            if (dCard.equals("5") || dCard.equals("6")){
                if (money - (2*bet) >= 0){
                    play = "double";
                }
                else play = "hit";
            }
            else play = "hit";
        }
        else if (sum == 15 || sum == 16){
            if (dCard.equals("4") || dCard.equals("5") || dCard.equals("6")){
                if (money - (2*bet) >= 0){
                    play = "double";
                }
                else play = "hit";
            }
            else play = "hit";
        }
        else if (sum == 17){
            if (dCard.equals("3") || dCard.equals("4") || dCard.equals("5") || dCard.equals("6")){
                if (money - (2*bet) >= 0) {
                    play = "double";
                }
                else play = "hit";
            }
            else play = "hit";
        }
        else if (sum == 18){
            if (dCard.equals("2") || dCard.equals("3") || dCard.equals("4") || dCard.equals("5") || dCard.equals("6")){
                if (money - (2*bet) >= 0){
                    play = "double";
                }
                else play = "stand";
            }
            else if (dCard.equals("7") || dCard.equals("8")){
                play = "stand";
            }
            else play = "hit";
        }
        else if (sum == 19){
            if (dCard.equals("6")){
                if (money - (2*bet) >= 0){
                    play = "double";
                }
                else play = "stand";
            }
            else play = "stand";
        }
        else play = "stand";
        return play;
    }
}
