import java.util.ArrayList;

public class Player {
    static int sum;
    static ArrayList<String> myCards;
    static String dealerCard;
    static int moneyInPlay;
    static int bet;
    public static String playEval(ArrayList<String> info, int money, int betInfo){
        String play;
        moneyInPlay = money;
        sum= 0;
        bet = betInfo;

        findMyCards(info);
        dealerCard = String.valueOf(info.get(2).charAt(0));

        System.out.println(myCards);

        for (String card : myCards){
            if (!card.equals("A")){
                sum += Integer.parseInt(card);
            }
        }
        if (myCards.contains("A")){
            if (sum <= 10){
                sum+= 11;
            } else{
                sum += 1;
            }
        }
        play = PlayStyle.evaluate(myCards, dealerCard, sum, moneyInPlay, bet);
        return play;
    }
    private static void findMyCards(ArrayList<String> info){
        myCards = new ArrayList<>();
        for (int i = 0; i < info.size()-4 ; i++){
            char determiner = info.get(i+4).charAt(0);

            if (determiner == 'J' || determiner == 'Q' || determiner == 'K' || determiner == '1'){
                myCards.add("10");
            } else if (determiner == 'A'){
                myCards.add("A");
            } else{
                myCards.add(String.valueOf(determiner));
            }
        }
    }
}
