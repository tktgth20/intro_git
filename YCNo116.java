import java.lang.Math;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class YCNo116{
    public static void main(String[] args){
        try{
            //入力
            List<Integer> list = scanInputData();
            //出力
            System.out.println(calcKadoNumber(list));

        }catch(NumberFormatException e){
            ;
        }

    }
    /**
     * 入力
     * @return 竹の長さリスト
     */
    private static List<Integer> scanInputData(){
        Scanner scan =new Scanner(System.in);
        int bambooNum =0;

        do{
            bambooNum =Integer.parseInt(scan.nextLine());
        }while(! isAllowedRange(bambooNum));
        String strKado[] = scan.nextLine().split(" ");

        scan.close();

        //無効な入力数の場合
        if(strKado.length != bambooNum){
            scanInputData();
        }

        List<Integer> re_list= new ArrayList<Integer>();

        for(String str :strKado){
            int temp = Integer.parseInt(str);
            if(! isAllowedRange(temp)){
                //入力値の有効範囲外
                scanInputData();
            }
            re_list.add(temp);
        }
        return re_list;
    }
    /**
     * 有効範囲ならば真
     * @param number
     * @return 真偽
     */
    private static boolean isAllowedRange(int number){
        if(number < 1){
            return false;
        }
        if(number > (long)Math.pow(10,2)){
            return false;
        }
        return true;
    }
    /**
     * 門松列の数を算出
     * @param in_list 竹の長さリスト
     * @return 門松列の数
     */
    private static int calcKadoNumber(List<Integer> in_list){
        int re_cnt=0;
        //2番目の要素から開始
        for(int i=1; i<in_list.size()-1;i++){
            int leftLength = in_list.get(i-1);
            int centerLength = in_list.get(i);
            int rightLength = in_list.get(i+1);
            int leftCompValue = Integer.compare(centerLength,leftLength);
            int rightCompValue = Integer.compare(centerLength,rightLength);

            if(leftLength==rightLength){
                ;//左の竹と右の竹の長さが等しい
            }else if((leftCompValue > 0 && rightCompValue >0) 
            || (leftCompValue < 0 && rightCompValue <0)){
                //真ん中の竹の長さが最小もしくは最大
                re_cnt++;
            }
        }
        return re_cnt;
    }
}