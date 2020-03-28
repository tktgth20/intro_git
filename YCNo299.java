import java.util.Scanner;
public class YCNo299 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{
            long edition = scanInputData(scan);
            System.out.println(calcTotalPages(edition));
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
    private static long scanInputData(Scanner scan){
        long inputNum =0;
        do{
            if(scan.hasNextLong()){
                inputNum = scan.nextLong();
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
    private static boolean isAllowedRange(long number){
        if(number < 1  || number > Math.pow(10,10)){
            return false;
        }
        return true;
    }
    /**
     * 最大マッチング
     * @param 整数
     * @return 最大マッチング
     */
    private static long calcTotalPages(long number){
        final int firstEdTotalPages = 368 - 52;//初版総ページ数
        return firstEdTotalPages + ((number-1)*52);
    }
}