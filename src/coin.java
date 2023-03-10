import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class coin {
    //TODO declare variables
     private static int heads = 0;
     private  static int tails = 0;
     private static int noOfExp = 0;
     private static  int total = 50;
     private static double toss;
     private static int []head = new int[total];
     private static int [] tail = new int[total];
//an instance of the class record to save the experiment to a text file
    Record r;


    public coin(){    }
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
    public void coinToss() throws IOException {
        //TODO repeat the experiment
        while (noOfExp < total) {

            //TODO check HEADS OR TAILS loop 10 times
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

            System.out.println("EXPERIMENT "+ (noOfExp+ 1 ) +".");
            System.out.println("Number of heads: " + head[noOfExp] + ".");
            System.out.println("Number of tails: " + tail[noOfExp] + ".\n\n");
            String result = "->  "+ (noOfExp+ 1 ) +"---" + "  heads: " + head[noOfExp] + "---" + "  tails: " + tail[noOfExp] + ".";
            r = new Record(result);
            heads = tails = 0;
            noOfExp++;
        }
        calculateCumulativeAverage(head,tail);
    }

    public void calculateCumulativeAverage(int[] H, int[] t) throws IOException {
        int totalHeads = 0;float avgHeads;
        int totalTails = 0; float avgTails;

        for(int eachEXP = 0; eachEXP < noOfExp; eachEXP++){
            totalHeads = H[eachEXP] + totalHeads;
            totalTails = t[eachEXP] + totalTails;
        }
       System.out.println(totalHeads);
        System.out.println(totalTails);

        avgTails = totalTails/(noOfExp * 10F);
        avgHeads = totalHeads/(noOfExp * 10F);

        String Output = "The cumulative average of heads is: "+ avgHeads + "\nThe cumulative average of tails is: "+ avgTails;
        System.out.println(Output);
        r = new Record(Output);
    }
}
