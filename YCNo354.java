import java.util.*;

public class YCNo354 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);

        try{
            int num = scanInputData(scan);
            System.out.println(num);
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
        }while(inputNum == 0);
        return inputNum;
    }

}