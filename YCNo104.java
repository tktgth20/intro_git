import java.util.Scanner;
public class YCNo104 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{
            String inputLine = null;
            inputLine = scan.findInLine("[LR]+");
            scan.close();
            if(inputLine != null){           
                //31文字以上は無効値
                if(inputLine.length() >= 31){
                    throw new Exception();
                }
                //出力
                System.out.println(currentLocation(inputLine));
            }else{
                //出力:分岐なし
                System.out.println(currentLocation(inputLine));
            }
        }catch(Exception e){
            e.printStackTrace();
            scan.close();
        }
    }

    /**
     * 現在地の国道の番号を算出
     * @param word 入力値（進んだ分岐の記録）
     * @return 現在地の国道の番号
     */
    private static int currentLocation(String word){
        int currentLocation=1;

        //分岐なし
        if(word==null){
            return currentLocation;
        }

        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == 'R'){
                currentLocation = (currentLocation * 2)  + 1;
            }else{
                currentLocation = (currentLocation * 2);
            }
        }
        return currentLocation;
    }
}