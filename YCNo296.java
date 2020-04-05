import java.util.Scanner;
public class YCNo296 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{
            int numOfWakeUp = scanInputData(scan,"numOfWakeUp");
            int hour = scanInputData(scan,"hour");
            int minute = scanInputData(scan, "minute");
            int interval = scanInputData(scan, "interval");
            int[] wakeUpTime = calcRealWakeUpTime(numOfWakeUp, hour, minute, interval);
            System.out.println(wakeUpTime[0]);
            System.out.println(wakeUpTime[1]);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            scan.close();
        }
    }
    /**
     * 入力
     * @param scan
     * @return 有効な入力値
     */
    private static int scanInputData(Scanner scan, String name){
        int inputNum =0;
        do{
            if(scan.hasNextInt()){
                inputNum = scan.nextInt();
            }else{
                scan.next();
            }
        }while(! isAllowedRange(inputNum,name));
        return inputNum;
    }
    /**
     * 有効値チェック
     * @return true 引数が有効値 false 引数が無効値
     */
    private static boolean isAllowedRange (int number,String name){
        switch(name){
        case "numOfWakeUp":
            if(number >= 1  && number <= Math.pow(10,6)){
                return true;
            }
        case "hour":
            if(number >= 0  && number <= 23){
                return true;
            }
        case "minute":
            if(number >= 0  && number <= 59){
                return true;
            }
        case "interval":
            if(number >= 1 && number <= (24*60)){
                return true;
            }
        default: return false;
        }
    }
    /**
     * 最大マッチング
     * @param 整数
     * @return 最大マッチング
     */
    private static int[] calcRealWakeUpTime(int numOfWakeUp,int hour,int minute,int interval){
        long temp = interval * (numOfWakeUp -1);
        int tempHours =0;
        if(temp > 0){
            tempHours = (int)(temp/60);
        }
        int tempMinute = (int)(temp - tempHours);
        int addedMinute = (minute + tempMinute);
        int[] wakeUpTime = {0,0};
        int tempAdvance = 0;
        if(addedMinute > 0){
            tempAdvance = addedMinute/60;
            wakeUpTime[1] = addedMinute-tempAdvance;
        }
        int addedHours = hour + tempHours + tempAdvance;
        if(addedHours > 0){
            wakeUpTime[0] = addedHours%24;
        }
        return wakeUpTime;
    }

}