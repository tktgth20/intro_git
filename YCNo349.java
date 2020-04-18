import java.util.*;

public class YCNo349 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{
            int number = Integer.parseInt(scanInputData(scan,"number"));
            int[] etos = new int[12];
            double MaxEto = number/2 + 1;
            Boolean isNotOverMaxEto = true;
            for(int i=0 ;i<number && isNotOverMaxEto;i++){
                String temp = scanInputData(scan,"eto");
                switch(temp){
                case "ne":etos[0]++;
                    break;
                case "ushi":etos[1]++;
                    break;
                case "tora":etos[2]++;
                    break;
                case "u":etos[3]++;
                    break;
                case "tatsu":etos[4]++;
                    break;
                case "mi":etos[5]++;
                    break;
                case "uma":etos[6]++;
                    break;
                case "hitsuji":etos[7]++;
                    break;
                case "saru":etos[8]++;
                    break;
                case "tori":etos[9]++;
                    break;
                case "inu":etos[10]++;
                    break;
                case "i":etos[11]++;
                    break;
                default:
                    throw new Exception();
                }
                for(int w :etos){
                    if(w > MaxEto){
                        isNotOverMaxEto = false;
                        break;
                    }
                }
            }
            if(isNotOverMaxEto){
                System.out.println("YES");
            }else{
                System.out.println("No");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            scan.close();
        }
    }
    /**
     * 入力
     * @return 有効な入力値
     */
    private static String scanInputData(Scanner scan,String type){
        String inputLine =null;
        do{
            if(scan.hasNextLine()){
                inputLine = scan.nextLine();
            }else{
                scan.next();
            }
        }while(! isAllowedRange(inputLine,type));
        return inputLine;
    }

    /**
     * 有効値チェック
     * @return true 引数が有効値 false 引数が無効値
     */
    private static boolean isAllowedRange(String inputLine,String type){
        String[] etoStrings = {"ne","ushi","tora","u","tatsu","mi","uma","hitsuji","saru","tori","inu","i"};
        switch(type){
        case "number":
            int tempNum = Integer.parseInt(inputLine);
            if(tempNum >= 2  && tempNum <= 50){
                return true;
            }
        case "eto":
            for(String w:etoStrings){
                if(w.equals(inputLine)){
                    return true;
                }
            }
        default:
            return false;
        }
    }
}