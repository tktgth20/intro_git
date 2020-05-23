import java.util.*;

public class YCNo1005 {
    static final int TYPE1_NUMBER = 1; //有効値判定用
    static final int TYPE2_ARRAYS = 2; //有効値判定用
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{
            char[] originalText = scanInputData(scan).toCharArray();
            char[] botText = scanInputData(scan).toCharArray();
            int result=0;
            for(int i=0;i<(originalText.length-botText.length)+1;i++){
                int cnt=0;
                for(int j =0;j<botText.length;j++){
                    if(originalText[i+j]==botText[j]){
                        cnt++;
                    }
                }
                if(cnt==botText.length){
                    result++;
                    i+=(botText.length-1);
                }
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
    private static String scanInputData(Scanner scan){
        String input="";
        do{
            if(scan.hasNextLine()){
                input = scan.nextLine();
            }else{
                scan.next();
            }
        }while(input.isEmpty());
        return input;
    }

}