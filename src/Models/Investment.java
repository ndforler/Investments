package Models;

public class Investment {
    double money, interest, yearly;
    int years;

    public Investment(double money, double interest, double yearly, int years){
        setInterest(interest);
        setMoney(money);
        setYearly(yearly);
        setYears(years);
    }

    public double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if(money > 0)
            this.money = money;
        else{
            throw new IllegalArgumentException("You aren't able to have less then 0 dollars");
        }

    }

    public double getInterest() {
        return interest;
    }

    private void setInterest(double interest) {
        if(interest > 0)
            this.interest = interest;
        else{
            throw new IllegalArgumentException("You aren't able to have less then 0 interest");
        }
    }

    public double getYearly() {
        return yearly;
    }

    private void setYearly(double yearly) {
        if(yearly > 0)
            this.yearly = yearly;
        else{
            throw new IllegalArgumentException("You aren't able to have less then 0 dollars each year");
        }
    }

    public int getYears() {
        return years;
    }

    private void setYears(int years) {
        if(years > 0)
            this.years = years;
        else{
            throw new IllegalArgumentException("You aren't able to have less then 0 years");
        }
    }

    public double investment(){
        return ((getInterest()+1)*((Math.pow(1+getInterest(),getYears())-1)/getInterest())*getYearly())+(getMoney()*Math.pow(1+getInterest(), getYears()+1));
    }

    public double getCalculatedInterest(){
        return investment() - (getMoney() + (getYears() * getYearly()));
    }

//    @O
//    public String toString(){
//
//    }
}
