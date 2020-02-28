import java.util.Scanner;
class YCNo799{
    public static void main(String[] args){
        String str;

        //入力
        System.out.print("入力（1:sumple1,2:sumple2,3:sumple-3,9:free）=>");
        Scanner scan = new Scanner(System.in);
        int w_input = Integer.parseInt(scan.nextLine());
        if(w_input == 1){
            str = "1 3 2 4";
        }else if(w_input == 2){
            str = "1 5 6 10";
        }else if(w_input == 3){
            str = "1 100 1 100";
        }else{
            System.out.println("入力してください");
            str = scan.nextLine();
        }
        scan.close();

        //処理
        String split_str[] = str.split(" ");
        int num[]=new int[split_str.length];
        int i=0;

        for(String w_str:split_str){
            num[i]= Integer.parseInt(w_str);
            i++;
        }
        int red_box[] = Box.createBox(num[0],num[1]);
        int black_box[] = Box.createBox(num[2],num[3]);
        int count=0;
        for(int w_red_num:red_box){
            for(int w_black_num: black_box){
                if(w_red_num == w_black_num){
                    count++;
                }
            }
        }
        int ans= (red_box.length * black_box.length )-count;
        System.out.println(ans);
        return;
    }
}

class Box{
    public Box(){};
    public static int[] createBox(int small_num,int big_num){
        int w_array[] = new int[(big_num-small_num)+1]; 
        for(int i=0;i<w_array.length;i++){
            w_array[i] = small_num+i;
        }
        return w_array;
    }
}