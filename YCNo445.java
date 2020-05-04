import java.util.*;
import java.util.function.*;

public class YCNo445 {
    static final int TYPE1_A = 1; //有効値判定用
    static final int TYPE2_B = 2; //有効値判定用
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{
            int a = scanInputData(scan,TYPE1_A);
            int b = scanInputData(scan,TYPE2_B);

            //型パラメータ<引数,引数,戻り値>
            BiFunction<Integer,Integer,Integer> func = (x,y)->{
                int work = 50*x+(int)Math.floor((50*x)/(0.8+(0.2*y)));
                return work;
            };
            //関数の実行
            int result = func.apply(a,b);

            System.out.println(result);
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
    private static int scanInputData(Scanner scan,int type){
        int inputNum =0;
        do{
            if(scan.hasNextInt()){
                inputNum = scan.nextInt();
            }else{
                scan.next();
            }
        }while(! isAllowedRange((int)inputNum,type));
        return inputNum;
    }

    /**
     * 有効値チェック
     * @param number 整数入力
     * @return true 引数が有効値 false 引数が無効値
     */
    private static boolean isAllowedRange(int number,int type){
        switch(type){
        case TYPE1_A:
            if(number >= 1  && number <= 6){
                return true;
            }
        case TYPE2_B:
            if(number >= 1  && number <= 1000){
                return true;
            } 
        default:
            return false;
        }
    }
}