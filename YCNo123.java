import java.util.*;

public class YCNo123 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        try{
            int card= scanInputData(scan,"card");
            int shuffle = scanInputData(scan,"shuffle");
            scan.nextLine();
            int[] pile = scanInputLine(scan,"pile",card);
            if(pile.length > shuffle){
                throw new Exception();
            }
            Stack<Integer> stack = new Stack<>();
            for(int i =card; i>0;i--){
                stack.push(i);
            }
            int max = stack.size();  
            for (int i =0;i<pile.length;i++){
                int temp = stack.get(max-pile[i]);
                stack.remove(max-pile[i]);
                stack.push(temp);
            }
            System.out.println(stack.peek());

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
    private static int scanInputData(Scanner scan,String type){
        int inputNum =0;
        do{
            if(scan.hasNextInt()){
                inputNum = scan.nextInt();
            }else{
                scan.next();
            }
        }while(! isAllowedRange(inputNum,type,0));
        return inputNum;
    }
    private static int[] scanInputLine(Scanner scan,String type,int card)throws Exception{
        String[] w = scan.nextLine().split(" ");
        int[] inputNum = new int[w.length];
        for(int i = 0; i<w.length;i++){
            inputNum[i]=Integer.parseInt(w[i]);
            if(! isAllowedRange(inputNum[i],type,card) ){
               throw new Exception();
            }
        }
        return inputNum;
    }
    /**
     * 有効値チェック
     * @param number 整数入力
     * @return true 引数が有効値 false 引数が無効値
     */
    private static boolean isAllowedRange(int number,String type,int card){
        switch(type){
        case "card":
            if(number >= 1  && number <= 50){
                return true;
            }
        case "shuffle":
            if(number >= 1  && number <= Math.pow(10,5)){
                return true;
            } 
        case "pile":
            if(number >= 1  && number <= card){
                return true;
            } 
        default:
            return false;
        }
    }
}