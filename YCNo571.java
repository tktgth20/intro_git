import java.util.*;

public class YCNo571 {
    static final int TYPE1_HEIGHT = 1;
    static final int TYPE2_WEIGHT = 2;
    static final int NAME_NUM =0;
    static final int HEIGHT =1;
    static final int WEIGHT =2;
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{

            int[][] array = new int[3][3];
            for(int i =0; i<3; i++){
                array[i][NAME_NUM] = i;
                array[i][HEIGHT] = scanInputData(scan,TYPE1_HEIGHT);
                array[i][WEIGHT] = scanInputData(scan,TYPE2_WEIGHT);
            }
            int[] work = new int[3];
            for(int i=0;i<2;i++){
                for(int j=i+1;j<3;j++){
                    if(array[i][HEIGHT]<array[j][HEIGHT]){
                        work = array[i];
                        array[i] = array[j];
                        array[j] = work;
                    }else if(array[i][HEIGHT]==array[j][HEIGHT]){
                        if(array[i][WEIGHT]>array[j][WEIGHT]){
                            work = array[i];
                            array[i] = array[j];
                            array[j] = work;
                        }
                    }
                }              
            }
            for(int i=0;i<3;i++){
                String result;
                if(array[i][NAME_NUM]==0){
                    result ="A";
                }else if(array[i][NAME_NUM]==1){
                    result ="B";
                }else{
                    result = "C";
                }
                System.out.println(result);
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
            case TYPE1_HEIGHT:
                if(number >= 150 && number <= 200){
                    return true;
                }
                break;
            case TYPE2_WEIGHT:
                if(number >= 50 && number <= 100){
                    return true;
                }
                break;
            default: return false;
        }
        return false;
    }

}