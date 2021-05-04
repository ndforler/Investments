import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
        int money, yearly,years;
        double interest;
        boolean run = true;
        while(run){
            System.out.print("How much money did you invest: ");
            money = scanner.nextInt();
            System.out.print("What is the interest on your money(Whole value): ");
            interest = scanner.nextDouble();
            interest /= 100;
            System.out.print("How much do you invest each year: ");
            yearly = scanner.nextInt();
            System.out.print("How many years are you investing: ");
            years = scanner.nextInt();
            for (int x = 0; x < years; x++){
                System.out.printf("Year %2d: %s -> total interest: %s -> interest: %s %n",(x + 1), format.format(investment(money, interest, yearly, x)), format.format(getInterest(investment(money, interest, yearly, x), money, yearly, x)), format.format(getInterest(investment(money, interest, yearly, x), money, yearly, x) - getInterest(investment(money, interest, yearly, x-1), money, yearly, (x-1))));
            }
            System.out.printf("You made %s and spend %s\n",format.format(getInterest(investment(money, interest, yearly, years-1), money, yearly, years-1)), format.format(money+(yearly*years-1)));
            System.out.print("would you like to run again true/false: ");
            run = scanner.nextBoolean();
        }
    }
    public static double investment(int money, double interest, int yearly, int years){
        return ((interest+1)*((Math.pow(1+interest,years)-1)/interest)*yearly)+(money*Math.pow(1+interest, years+1));
    }

    public static double getInterest(double total, int money, int yearly, int years){
        double hold = money + (years * yearly);
        return total - hold;
    }
}
