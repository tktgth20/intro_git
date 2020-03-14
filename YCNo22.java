import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
public class YCNo22{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try{
            //入力
            int wordCount = scanInputInt(scan);
            int target = scanInputInt(scan);
            if(wordCount<target){
                throw new IllegalArgumentException();
            }
            scan.nextLine();//調整（空読み）
            char[] brackets = scanInputLine(scan,wordCount);
            scan.close();

            //主処理
            int NumforOutput =searchCorrespond (brackets,target);
            
            //出力
            System.out.println(NumforOutput);          

        }catch(NumberFormatException e){
            System.out.println("Format-Error");
        }catch(IllegalArgumentException e){
            System.out.println("Range-Error");
        }finally{
            scan.close();
        }
    }
    /**
     * 整数の入力
     * @param 
     * @return 
     */
    private static int scanInputInt(Scanner scan){
        int Integer =0;
        do{
            if(scan.hasNextInt()){
                Integer = scan.nextInt();
            }else{
                scan.next();
            }
        }while(! isAllowedRange(Integer));
        return Integer;
    }
    /**
     * 括弧の文字列の入力
     * @param 
     * @return 
     */
    private static char[] scanInputLine(Scanner scan,int wordCount){
        char[] inputBrackets = scan.nextLine().toCharArray();
        if(inputBrackets.length != wordCount){
            throw new IllegalArgumentException();
        }
        return inputBrackets;
    }   
    /**
     * 有効範囲内かを判定
     * @param 
     * @return 
     */
    private static boolean isAllowedRange(int number){
        if(number < 1){
            return false;
        }
        if(number > (int)Math.pow(10,4)){
            return false;
        }
        return true;
    }
    /**
     * 対応する括弧を検索
     * @param 
     * @return 
     */
    private static int searchCorrespond (char[] brackets,int target){
        char[] wBrancets = brackets;
        Map<Integer,String> map = new TreeMap<Integer,String>();

        for(int i=0; i<wBrancets.length; i++){
            int orderKey = i+1;
            map.put(orderKey,String.valueOf(wBrancets[i]));
        }
        boolean findFlg = false;
        int wMatch=0;
        while(! findFlg){
            int lastKey = 0;
            for(int key:map.keySet()){
                //比較対象無し
                if(lastKey==0){
                    lastKey = key;
                    continue;
                }
                if(map.get(lastKey).equals("(") && map.get(key).equals(")")){
                    //括弧の対応あり
                    if(lastKey==target){
                        //「"("」がtargetのペア
                        wMatch = key;
                        findFlg = true;
                        break;
                    }else if(key==target){
                        //「")"」がtargetのペア
                        wMatch = lastKey;
                        findFlg = true;
                        break;
                    }else{
                        //target以外のペア
                        map.remove(lastKey);
                        map.remove(key);
                        break;
                    }
                }else{
                    //括弧の対応なし
                    lastKey = key;
                }
            }
        }
        return wMatch;
    }

}