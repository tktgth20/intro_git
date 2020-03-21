import java.util.Scanner;
public class YCNo51 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{
            int totalWorkVolume = scanInputData(scan);
            int workingDays = scanInputData(scan);
            scan.close();
            System.out.println(calcLastDayWork(totalWorkVolume, workingDays));
        }catch(Exception e){
            scan.close();
        }
    }
    /**
     * 入力
     * @param scan
     * @return 有効な入力値
     */
    private static int scanInputData(Scanner scan){
        int inputNum =0;
        do{
            if(scan.hasNextInt()){
                inputNum = scan.nextInt();
            }else{
                scan.next();
            }
        }while(! isAllowedRange(inputNum));
        return inputNum;
    }
    /**
     * 有効値チェック
     * @param number 整数入力
     * @return true 引数が有効値 false 引数が無効値
     */
    private static boolean isAllowedRange(int number){
        if(number < 1  || number > Math.pow(10,5)){
            return false;
        }
        return true;
    }
    /**
     * 最終日の作業量の計算
     * @param totalWorkVolume 総作業量
     * @param workingDays 総作業日数
     * @return 最終日の作業量
     */
    private static int calcLastDayWork(int totalWorkVolume, int workingDays){
        int remainVolume = totalWorkVolume;
        for(int remainDays = workingDays; remainDays >1 ;remainDays-- ){
            double tempD = remainVolume / Math.pow(remainDays,2);
            int tempWork = (int)tempD;
            remainVolume -= tempWork;
        }
        return remainVolume;
    }
}