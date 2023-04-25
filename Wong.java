import java.util.ArrayList;

/*----------------------------------------------------------------------------------------------------------------------
    The Wong-Halves Method is a complex(for humans) card counting method.
    Every card number is assigned a value , which is then divided by the number of decks in play.
    The higher the number, the better your chances.
------------------------------------------------------------------------------------------------------------------------
*/
public class Wong {
    public static double evalBet(ArrayList<String> info){
        double trueCount;
        ArrayList<Double> wongValues = new ArrayList<>();
        for (int i = 0 ; i < info.size()-3 ; i++){
            char determiner = info.get(i+3).charAt(0);

            if (determiner == 'J' || determiner == 'Q' || determiner == 'K' || determiner == 'A' || determiner == '1'){
                wongValues.add(-1.0);
            } else if (determiner == '2' || determiner == '7'){
                wongValues.add(0.5);
            } else if (determiner == '3' || determiner == '4' || determiner == '6'){
                wongValues.add(1.0);
            } else if (determiner == '5'){
                wongValues.add(1.5);
            } else if (determiner == '8'){
                wongValues.add(0.0);
            } else if (determiner == '9'){
                wongValues.add(-0.5);
            }
        }
        double runCount = 0;
        for (Double wongValue : wongValues) { runCount += wongValue;}
        double numberOfCards = wongValues.size();
        double divisor = 7 - ((364 - numberOfCards)/52);
        trueCount = runCount / divisor;
        return trueCount;
    }
}
