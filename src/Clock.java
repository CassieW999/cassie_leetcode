import java.util.Date;

public class Clock {
    private int hour;
    private int minute;
    private int second;
    private Date date;

    public Clock(int hour, int minute, int second) throws IllegalArgumentException{
        if (hour < 0 || minute < 0 || second < 0 || hour >= 24 || minute >= 60 || second >= 60){
            throw new IllegalArgumentException("Invalid inputs.");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Clock(){
        this(0, 0, 0);
    }

    public Clock(Clock other){
        this(other.hour, other.minute, other.second);
    }

    public boolean equals(Clock other){
        if (this.hour == other.hour && this.minute == other.minute && this.second == other.second){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "" + this.hour + ":" + this.minute + ":" + this.second;
    }

    public static void main(String[] args) {
        Clock c1 = new Clock(11, 22, 33);
        Clock c2 = new Clock(c1);

        System.out.println(c1.equals(c2));

        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }

}
