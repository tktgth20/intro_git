import java.util.*;

public class YCNo1041 {
    static final int TYPE1_NUMBER = 1; //有効値判定用
    static final int TYPE2_POSITION = 2; //有効値判定用
    static final int X = 0; //配列x座標格納
    static final int Y = 1; //配列y座標格納
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);

        try{
            int n = scanInputData(scan,TYPE1_NUMBER);
            int[][] position = new int[2][n];
            for(int i =0; i<n; i++){
                position[X][i] = scanInputData(scan,TYPE2_POSITION);
                position[Y][i] = scanInputData(scan,TYPE2_POSITION);
            }
            int maxCnt =0;
            for(int i =0; i<n; i++){
                double[] katamuki =new double[n-i];//傾き
                double[] seppen =new double[n-i];//ｙ切片
                int cnt =0;
                for(int j =i+1; j<n; j++){
                    //2点間の直線の傾き・y切片を計算
                    int loop = j-(i+1);
                    katamuki[loop] = 
                        (double)(position[Y][j]-position[Y][i])/(position[X][j]-position[X][i]);
                    seppen[loop] =
                        (double)(-1*katamuki[loop])*position[X][i]+position[Y][i];
                    
                    //傾き・y切片が一致する直線があるか。
                    for(int k =0;k<loop;k++){
                        if(katamuki[loop]== katamuki[k] && seppen[loop]== seppen[k]){
                            System.out.println(katamuki[loop]);
                            System.out.println(seppen[loop]);
                            cnt++;
                        }
                    }
                    if(cnt > maxCnt){
                        maxCnt = cnt; 
                    }
                }
            }
            System.out.println(maxCnt+2);
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
                if(number >= 2 && number <= 100){
                    return true;
                }
                break;
            case TYPE2_POSITION:
                if(number >= 0 && number <= 100){
                    return true;
                }
                break;
            default: return false;
        }
        return false;
    }

}