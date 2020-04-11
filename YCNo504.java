import java.util.Scanner;

public class YCNo504 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        int KRank = 1;
        try{
            int participant= (int)scanInputData(scan,"participant");
            long score[] = new long[participant];
            for (int i =0;i<score.length;i++){
                score[i] = scanInputData(scan,"score");
            }
            for(int i =0;i<score.length;i++){
                if(score[i]>score[0]){
                    KRank ++;
                }
                if(i>0){
                    System.out.println(KRank);
                }
            }
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
    private static long scanInputData(Scanner scan,String type){
        long inputNum =0;
        do{
            if(scan.hasNextLong()){
                inputNum = Long.parseLong(scan.nextLine());
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
    private static boolean isAllowedRange(long number,String type){
        switch(type){
        case "participant":
            if(number >= 1  && number <= Math.pow(10,5)){
                return true;
            }
        case "score":
            if(number >= 1  && number <= Math.pow(10,9)){
                return true;
            } 
        default:
            return false;
        }
    }
}