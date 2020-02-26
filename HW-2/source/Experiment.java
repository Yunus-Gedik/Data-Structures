package source;

public class Experiment{

    /*The variables you want*/
    String setup;
    int day;
    String time;
    boolean completed;
    float accuracy;
    Experiment next_day;
    Experiment next_exp;


    /**
     * @param setup Constructor with null next_day and next_exp
     * @param time
     * @param completed
     * @param day
     * @param accuracy
     */

    Experiment(String setup,String time , boolean completed,int day, float accuracy) {
        next_exp = null;
        next_day = null;
        this.setup = setup;
        this.day = day;
        this.completed = completed;
        this.accuracy = accuracy;
        this.time = time;
    }

    /**
     * @param setup Constructor with all variables
     * @param time
     * @param completed
     * @param day
     * @param accuracy
     * @param next_exp
     * @param next_day
     */

    Experiment(String setup,String time , boolean completed,int day, float accuracy,Experiment next_exp,Experiment next_day) {
        this.next_exp = next_exp;
        this.next_day = next_day;
        this.setup = setup;
        this.day = day;
        this.completed = completed;
        this.accuracy = accuracy;
        this.time = time;
    }

    /**
     * @return Your toString method.
     */

    @Override
    public String toString() {
        return "Experiment{" +
                "setup='" + setup + '\'' +
                ", day=" + day +
                ", time='" + time + '\'' +
                ", accuracy=" + accuracy +
                ", completed=" + completed +
                '}';
    }

}