import java.util.*;

public class YCNo401 {
    static final int TYPE1_A = 1; //有効値判定用
    static final int TYPE2_B = 2; //有効値判定用
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);

        try{
            int n = scanInputData(scan);
            int[][] a = new int[n][n];
            int num =1;
            int yoko =0;
            int tate = 0;
            int cnt =0;
            do{
                if(cnt!=0){
                    switch(cnt%4){
                    case 0: 
                        for(int j=0;j<n;j++){
                            if(a[tate][j]==0){
                                a[tate][j]=num;
                                yoko=j;
                                num++;
                            }
                        }
                        break;
                    case 1: 
                        for(int j=0;j<n;j++){
                            if(a[j][yoko]==0){
                                a[j][yoko]=num;
                                tate=j;
                                num++;
                            }
                        }
                        break;
                    case 2: 
                        for(int j=n-1;j>=0;j--){
                            if(a[tate][j]==0){
                                a[tate][j]=num;
                                yoko=j;
                                num++;
                            }
                        }
                        break;
                    case 3: 
                        for(int j=n-1;j>=0;j--){
                            if(a[j][yoko]==0){
                                a[j][yoko]=num;
                                tate=j;
                                num++;
                            }
                        }
                        break;
                    default: throw new Exception();
                    }
                    cnt++;
                }else{
                    for(int j=0;j<n;j++){
                        a[tate][j]=num;
                        yoko=j;
                        num++;
                    }
                    cnt++;
                }
            }while(num<=n*n /*&& cnt<1*/);
            String format = "%03d ";
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.printf(format,a[i][j]);
                }
                System.out.println();
            }
            System.out.println();
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
    private static int scanInputData(Scanner scan){
        int inputNum =0;
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
     * @return true 引数が有効値 false 引数が無効値
     */
    private static boolean isAllowedRange(int number){
        if(number >= 1  && number <= 30){
            return true;
        }
        return false;
    }
}