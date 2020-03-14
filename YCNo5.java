import java.util.Scanner;
import java.util.Arrays;
public class YCNo5{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try{
            int boxWidth = scanInputInt(scan);
            int numOfBlock = scanInputInt(scan);
            int[] blocksWidth = scanInputArrays(scan,boxWidth,numOfBlock);
            int NumforOutput = calcMaxNumOfBlk(blocksWidth,boxWidth);
            System.out.println(NumforOutput);

        }catch(NumberFormatException e){
            System.out.println("Format-Error");
        }catch(IllegalArgumentException e){
            System.out.println("Range-Error");
        }finally{
            scan.close();
        }
    }
    private static int scanInputInt(Scanner scan){
        int Integer =0;
        do{
            if(scan.hasNextInt()){
                Integer = scan.nextInt();
                System.out.println(Integer);
            }else{
                scan.next();
            }
        }while(! isAllowedRange(Integer));
        return Integer;
    }

    private static int[] scanInputArrays(Scanner scan,int boxWidth,int numOfBlock){
        scan.nextLine();//調整のため空読み
        String[] splits = scan.nextLine().split(" ");
        int[] inputNums = new int[numOfBlock];
        if(splits.length!=numOfBlock){
            throw new IllegalArgumentException();
        }
        for(int i=0;i<splits.length; i++){
            int temp = Integer.parseInt(splits[i]);
            if(boxWidth > temp){
                inputNums[i]=temp;
            }else{
                throw new IllegalArgumentException();
            }
        }
        return inputNums;
    }   

    private static boolean isAllowedRange(int number){
        if(number < 1){
            return false;
        }
        if(number > (int)Math.pow(10,4)){
            return false;
        }
        return true;
    }

    private static int calcMaxNumOfBlk(int[] numbers,int boxWidth){
        Arrays.sort(numbers);
        int count=0;
        int sum=0;
        for(int tempNum:numbers){
            sum += tempNum;
            if(boxWidth<sum){
                break;
            }
            count++;
        }
        return count;
    }

}