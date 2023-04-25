/*
    BlackJack Player @author Ravneet Singh Bhatia
    This program utilises cardcounting and basic strategy to play blackjack.
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int money;
    static boolean run;
    static int count = 0;
    static int bet;

    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            run = true;
            Connector connection = new Connector(args[0], args[1]);
            do {
                String dealerInfo = connection.read();
                ArrayList<String> dealerList = new ArrayList<>(Arrays.asList(dealerInfo.split(":")));
                String dealerCmd = dealerList.get(0);

                if (dealerCmd.equals("login")) {
                    connection.write("Ravneetsb:RSB");
                } else if (dealerCmd.equals("bet")) {
                    money = Integer.parseInt(dealerList.get(1));
                    System.out.println("your money: " + money);
                    if (money == 0 ){
                        System.out.println("No Money!");
                        run = false;
                    } else{
                        double betEvaluation = Wong.evalBet(dealerList);
                        if (betEvaluation <= 3){
                            if (money > 0) {
                                connection.write("bet:1");
                                bet = 1;
                            } else run=false;
                        } else if (betEvaluation > 3){
                            if (money > 1){
                                connection.write("bet:2");
                                bet = 2;
                            } else{
                                connection.write("bet:1");
                                bet = 1;
                            }
                        } else{
                            connection.write("bet:1");
                            bet = 1;  // Fresh deck returns NaN since no cards have been played.
                        } System.out.println("Betting : " + bet);
                    }
                } else if (dealerCmd.equals("play")){
                    String play = Player.playEval(dealerList, money, bet);
                    connection.write(play);
                    System.out.println("I played: " + play);
                } else if (dealerCmd.equals("status")){
                    for (String detail: dealerList){
                        System.out.print(detail+" ");
                    }
                    count++;
                    System.out.println("Number of hands played: " + count);
                } else if (dealerList.get(0).equals("done")){
                    connection.socket.close();
                    run = false;
                }
            } while (run);
        } else System.out.println("usage: java Main [IpAddress] [ipPort]");
    }
}