//import java.util.Scanner;
import java.util.*;
class YCNo994 {
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        ArrayList<CreateSide> list = new ArrayList<CreateSide>();
        try{
            int vertrix = scanInputData(scan,"vertrix",0);
            int coin = scanInputData(scan,"coin",0);
            for(int i =0;i<vertrix-1;i++){
                scan.nextLine();
                int sideA = scanInputData(scan,"side",vertrix);
                int sideB = scanInputData(scan,"side",vertrix);
                if(sideA == sideB){
                    throw new Exception();
                }
                list.add(new CreateSide(sideA,sideB));
            }
            ArrayList<Integer> firstVertrix= new ArrayList<>();
            firstVertrix.add(1);
            int cnt = calcSupplyCapacity(coin,list,firstVertrix,0);
            int result =0;
            if(cnt < coin ){
                result = -1;
            }else{
                result = coin-1;
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
    private static int scanInputData(Scanner scan,String name,int vertrix){
        int inputNum =0;
        do{
            if(scan.hasNextInt()){
                inputNum = scan.nextInt();
            }else{
                scan.next();
            }
        }while(! isAllowedRange(inputNum,name,vertrix));
        return inputNum;
    }
    /**
     * 有効値チェック
     * @param number 整数入力
     * @return true 引数が有効値 false 引数が無効値
     */
    private static boolean isAllowedRange (int number,String name,int vertrix){
        switch(name){
        case "vertrix":
            if(number >= 2  && number <= Math.pow(10,5)){
                return true;
            }
        case "coin":
            if(number >= 1  && number <= Math.pow(10,5)){
                return true;
            }
        case "side":
            if(number >= 1  && number <= vertrix){
                return true;
            }
        default: return false;
        }
    }
    /**
     * 
     * @param 整数
     * @return 
     */
    private static int calcSupplyCapacity(int coin,ArrayList<CreateSide> list,ArrayList<Integer> vertrixList,int count){
        int cnt = count;
        ArrayList<Integer> nextVertrixList = new ArrayList<>();
        for(int element :vertrixList){
            for(int j =list.size()-1; j>=0 && list.size()>0;j--){
                if(list.get(j).getStart()== element ){
                    cnt++;
                    nextVertrixList.add(list.get(j).getEnd());
                    list.remove(j);
                }else if(list.get(j).getEnd()== element ){
                    cnt++;
                    nextVertrixList.add(list.get(j).getStart());
                    list.remove(j);
                }
            }
            if(cnt >= coin){
                break;
            }
        }
        if(cnt < coin && list.size()>0){
            return calcSupplyCapacity(coin,list,nextVertrixList,cnt);
        }
       return cnt;
    }

}

class CreateSide{
    private int start =0;
    private int end =0;
    public CreateSide(int start,int end){
        this.start = start;
        this.end = end;
    }
    public int getStart(){
        return start;
    }
    public int getEnd(){
        return end;
    }
}