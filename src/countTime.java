public class countTime {
    public static int countTime(String time) {
        int sum = 1;
        String[] parts = time.split(":");
        String hour = parts[0];
        String minute = parts[1];
        if (hour.equals("??")) {
            sum *= 24;
        }else if (hour.charAt(0) == '?'){
            if (hour.charAt(1) > '3'){
                sum *= 2;
            }else{
                sum *= 3;
            }
        }else if (hour.charAt(1) == '?'){
            if (hour.charAt(0) == '2'){
                sum *= 4;
            }else {
                sum *= 10;
            }
        }
        if (minute.equals("??")){
            sum *= 60;
        }else if (minute.charAt(0) == '?'){
            sum *= 6;
        }else if (minute.charAt(1) == '?'){
            sum *= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        String time = "??:??";
        System.out.println(countTime(time));
    }

}
