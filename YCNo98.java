import java.util.*;

public class YCNo98 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{
            double x = Math.abs(scanInputData(scan));
            double y = Math.abs(scanInputData(scan));

            //入力座標の斜辺*2を求める
            double hypotenuse =  Math.sqrt(Math.pow(x,2)+Math.pow(y,2))*2;
            //円の直径を求める。
            int diameter =0;
            if(hypotenuse-(int)hypotenuse > 0){
                diameter = (int)Math.ceil(hypotenuse);
            }else{
                diameter = (int)(hypotenuse+1);
            }
            System.out.println(diameter);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            scan.close();
        }
    }
    /**
     * 入力
     * @return 有効な入力値
     */
    private static double scanInputData(Scanner scan){
        double inputNum =0;
        do{
            if(scan.hasNextInt()){
                inputNum = scan.nextInt();
            }else{
                scan.next();
            }
        }while(! isAllowedRange((int)inputNum));
        return inputNum;
    }

    /**
     * 有効値チェック
     * @param number 整数入力
     * @return true 引数が有効値 false 引数が無効値
     */
    private static boolean isAllowedRange(int number){
            if(number >= -10000  && number <= 10000){
                return true;
            }
            return false;
    }
}