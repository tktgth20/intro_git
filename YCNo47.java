import java.util.Scanner;
import java.lang.Math;
public class YCNo47{
    public static void main(String[] args){
        //入力
        final long inputNum = scanInputData();
        //計算
        int out_clapCnt = calcClapCount(inputNum);
        //出力
        System.out.println(out_clapCnt);
    }

    /**
     * 入力処理
     * @return 検査済み入力値
     */
    private static long scanInputData(){
        Scanner scan =new Scanner(System.in);
        long w_inputNum =0;
        do{
            if(scan.hasNextLong()){
                w_inputNum = scan.nextLong();
            }else{
                scan.next();
            }
        }while(! isAllowedRange(w_inputNum));
        scan.close();
        return w_inputNum;
    }
    /**
     * 入力値の有効範囲チェック
     * @param number 未検査入力値
     * @return 真偽
     */
    private static boolean isAllowedRange(long number){
        if(number < 1){
            return false;
        }
        if(number > (long)Math.pow(10,8)){
            return false;
        }
        return true;
    }
    /**
     * 手を叩く最小回数計算
     * @param numberIWant ビスケットの目標個数
     * @return clapCnt 手を叩く回数
     */
    private static int calcClapCount(long numberIWant){
        final int CONST2 =2; //ビスケットが増える倍数：2倍
        int clapCnt = 0;     //手を叩く回数
        long w_totalNum = 1L;//ビスケットの数

        while(numberIWant > w_totalNum){
            w_totalNum *= CONST2;
            clapCnt++;
        }
        return clapCnt;
    }
}