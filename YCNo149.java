import java.util.*;

public class YCNo149 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{
            int bagAwt = scanInputData(scan,"bag");
            int bagAbk = scanInputData(scan,"bag");
            int bagBwt = scanInputData(scan,"bag");
            int bagBbk = scanInputData(scan,"bag");
            int numAtoB = scanInputData(scan,"AtoB");
            int numBtoA = scanInputData(scan,"BtoA");
            int whiteAtoB =0;
            if(numAtoB <= bagAbk){
                whiteAtoB = 0;
            }else{
                whiteAtoB = (numAtoB-bagAbk);
            }
            int addedbagBwt = bagBwt+whiteAtoB;
            int whiteBtoA =0;
            if(numBtoA <= addedbagBwt){
                whiteBtoA = numBtoA;
            }else{
                whiteBtoA = addedbagBwt;
            }
            int MaxWhite = bagAwt - whiteAtoB + whiteBtoA;
            System.out.println(MaxWhite);

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
    private static int scanInputData(Scanner scan,String type){
        int inputNum =0;
        do{
            if(scan.hasNextInt()){
                inputNum = scan.nextInt();
            }else{
                scan.next();
            }
        }while(! isAllowedRange(inputNum,type));
        return inputNum;
    }

    /**
     * 有効値チェック
     * @param number 整数入力
     * @return true 引数が有効値 false 引数が無効値
     */
    private static boolean isAllowedRange(int number,String type){
        switch(type){
        case "bag":
            if(number >= 0  && number <= 100000){
                return true;
            }
        case "AtoB":
            if(number >= 0  && number <= 200000){
                return true;
            } 
        case "BtoA":
            if(number >= 0  && number <= 400000){
                return true;
            } 
        default:
            return false;
        }
    }
}