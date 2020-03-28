import java.util.Scanner;
public class YCNo83 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{
            int matchOfNumber = scanInputData(scan);
            System.out.println(calcMaxNumber(matchOfNumber));
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
        if(number < 2  || number > Math.pow(10,5)){
            return false;
        }
        return true;
    }
    /**
     * 最大マッチング
     * @param 整数
     * @return 最大マッチング
     */
    private static char[] calcMaxNumber(int number){
        int resultOfDiv = (number / 2);//商
        int divRemainder = number % 2 ; //余り
        char maxNumberC[] = new char[resultOfDiv] ;
        int cnt = 0;
        while(cnt < maxNumberC.length){
            maxNumberC[cnt] = '1';
            cnt++;
        } 
        if(divRemainder == 1){
            maxNumberC[0] = '7';
        }
        return maxNumberC;
    }
}