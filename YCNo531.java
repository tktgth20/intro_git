import java.util.*;

public class YCNo531 {
    static final int TYPE1_NUMBER = 1; //有効値判定用
    static final int TYPE2_CAPACITY = 2; //有効値判定用
    static final int X = 0; //配列x座標格納
    static final int Y = 1; //配列y座標格納
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);

        try{
            int n = scanInputData(scan,TYPE1_NUMBER);
            int capacity = scanInputData(scan,TYPE2_CAPACITY);
            int result =0;
            if(n <= capacity){
                result = 1;
            }else if(n % 2==0 && (n/2) <= capacity){
                result = 2;
            }else{
                result = -1;
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
                if(number >= 2 && number <= 100000){
                    return true;
                }
                break;
            case TYPE2_CAPACITY:
                if(number >= 2 && number <= 50){
                    return true;
                }
                break;
            default: return false;
        }
        return false;
    }

}