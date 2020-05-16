import java.util.*;

public class YCNo1032 {
    static final int TYPE1_NUMBER = 1; //有効値判定用
    static final int TYPE2_ARRAYS = 2; //有効値判定用
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);

        try{
            int length = scanInputData(scan,TYPE1_NUMBER);
            int number = scanInputData(scan,TYPE1_NUMBER);
            int[] arrays = new int[number];
            for(int i =0; i<length; i++){
                int temp =  scanInputData(scan,TYPE2_ARRAYS);
                for(int j =0;j<number;j++){
                    if(temp == j+1){
                        arrays[j]++;
                    }
                }
            }
            for(int i =0; i<number;i++){
                System.out.println((i+1)+" "+arrays[i]);
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
     * @return true 引数が有効値 false 引数が無効値
     */
    private static boolean isAllowedRange(int number,int type){
        switch(type){
            case TYPE1_NUMBER:
                if(number >= 1 && number <= 2*100000){
                    return true;
                }
                break;
            case TYPE2_ARRAYS:
                if(number >= 1 && number <= 2*100000){
                    return true;
                }
                break;
            default: return false;
        }
        return false;
    }

}