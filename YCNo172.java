import java.util.*;

public class YCNo172 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{
            double x = Math.abs(scanInputData(scan,"position"));
            double y = Math.abs(scanInputData(scan,"position"));
            double r = scanInputData(scan,"r");
            double add =  (r/Math.sqrt(2))*2;
            double manhattanDistance = x+y+add;
            int result =0;
            if(manhattanDistance-(int)manhattanDistance > 0){
                result = (int)Math.ceil(manhattanDistance);
            }else{
                result = (int)(manhattanDistance+1);
            }
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
    private static double scanInputData(Scanner scan,String type){
        double inputNum =0;
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
    private static boolean isAllowedRange(int number,String type){
        switch(type){
        case "position":
            if(number >= -100  && number <= 100){
                return true;
            }
        case "r":
            if(number >= 1  && number <= 100){
                return true;
            } 
        default:
            return false;
        }
    }
}