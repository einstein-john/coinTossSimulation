import java.text.DecimalFormat;
import java.util.Random;

public class coin {
    //TODO declare variables
    static int heads = 0;
    static int tails = 0;
    static int noOfExp = 0;
    static  int total = 1_000_000_00;
    static double toss;
    static int []head = new int[total];
    static int [] tail = new int[total];

    static double createRandomDecimal(int upperLimit, int lowerLimit) {
        double randomNO;
        Random rad = new Random();
        DecimalFormat df = new DecimalFormat("#.##");

        //create a random decimal number between 0--1
        randomNO = rad.nextDouble(lowerLimit, upperLimit);
        //set the value to 2_dp
        randomNO = Double.parseDouble(df.format(randomNO));
        //System.out.println(randomNO);
        return randomNO;
    }
    public static void coinToss(){


        //TODO repeat the experiment 10 times
        while (noOfExp < total) {


            //TODO check HEADS OR TAILS
            for (int i = 0; i < 10; i++) {
                toss = createRandomDecimal(1,0);
                if (toss <= 0.5) {
                    heads++;
                } else {
                    tails++;
                }
            }

            //TODO add the result of each experiment to an array
            head[noOfExp] = heads;
            tail[noOfExp] = tails;

            //System.out.println("EXPERIMENT "+ (noOfExp+ 1 ) +".");
            //System.out.println("Number of heads: " + head[noOfExp] + ".");
           // System.out.println("Number of tails: " + tail[noOfExp] + ".\n\n");


            heads = tails = 0;
            noOfExp++;
        }
    }
    public void calculateCumulativeAverage(int[] H, int[] t){
        int totalHeads = 0;float avgHeads;
        int totalTails = 0; float avgTails;

        for(int eachEXP = 0; eachEXP < noOfExp; eachEXP++){
            totalHeads = H[eachEXP] + totalHeads;
            totalTails = t[eachEXP] + totalTails;
        }
       // System.out.println(totalHeads);
       // System.out.println(totalTails);
        avgTails = totalTails/(noOfExp * 10F);
        avgHeads = totalHeads/(noOfExp * 10F);
        String Output = "The cumulative average of heads is: "+ avgHeads + "\nThe cumulative average of tails is: "+ avgTails;
        System.out.println(Output);
    }
    public coin(){
        System.out.println("Running");
        coinToss();
        System.out.println("Done");
        calculateCumulativeAverage(head,tail);
    }



}
