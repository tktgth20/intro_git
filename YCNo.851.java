import java.util.*;
import java.lang.Exception;
import java.lang.*;

public class YCNo851{
	public static void main(String[] arguments)
	{
		final String ERR_MSG  = "assert";
		//String args = arguments[1];
		String args = "3\n1\n5\n3\n"; //input-sumple1
		//String args = "3\n3\n3\n4\n";   //input-sumple2
		//String args = "3\n1 5 3";     //input-sumple3
		String output;
		
		TestCase test_a = new TestCase(args); 

		if(test_a.getErr_flg()){
			output = ERR_MSG;
		}else{
			test_a.calc_second();
			output=String.valueOf(test_a.getSecond_val());
		}
		System.out.println(output);
		System.out.println();
		return;
	}
}

class TestCase{
	private static final long C_NUM_CNT  = 3L; // 値の個数
	private static final long C_MAX_VAL  = 10000000000L; // 最大値 100億
	private static final long C_MIN_VAL  = 1L;              // 最小値 1
	private boolean err_flg;
	private long second_val;
	private List<Long> list;

	public TestCase(String args){
		err_flg = false;
		second_val = 0;
		list = new ArrayList<Long>();
		split_args(args);
	};

	public void split_args(String args){
		try{
			//引数分割
			String w_split_args[] =  args.split("\n");
			for(String w_split :w_split_args){
				list.add(Long.parseLong(w_split));
			}
			//入力条件：先頭の値は3
			if(list.get(0) != C_NUM_CNT){
				throw new IllegalArgumentException();
			} 
			list.remove(0);
			//入力formatのチェック：値の数は3
			if(list.size() != C_NUM_CNT){
				throw new IllegalArgumentException();
			}
			//入力条件：値の範囲
			for(long w_number:list){
				if(w_number > C_MAX_VAL){
					throw new IllegalArgumentException();
				}else if(w_number < C_MIN_VAL){
					throw new IllegalArgumentException();
				}
			}
			//入力条件：1番目の値と3番目の値は等しくない。
			if(list.get(0) == list.get(2)){
				throw new IllegalArgumentException();
			}
			return;
		}catch(NumberFormatException e){
			err_flg = true;
			return;
		}catch(IllegalArgumentException e){
			err_flg = true;
			return;
		}
	}
	//2番目の値を算出		
	public void calc_second(){
		//降順ソート
		Collections.sort(list,Collections.reverseOrder());

		//最後のindex
		final int end_index = list.size()-1;
		
		int w_find_count= 0;
		int w_loop = 0;
		for(int i=0; i < end_index; i++){
			//次の値と異なる値の場合
			if(list.get(i) != list.get(i+1)){
				w_find_count ++;
				if(w_find_count == 2){
					w_loop = i;
					break;
				}
			}
		}

		if(w_find_count == 2){
			//リストの数値が3種類以上なら
			//最大値 + 降順で3種類目の数値
			second_val = list.get(0) + list.get(w_loop+1);
		}else if(w_find_count == 1){
			//リストの数値が2種類なら最小値*2
			second_val = list.get(end_index) *2;
		}else{
			err_flg = true;
		}
	} 

	public long getSecond_val(){
		return second_val;
	}
	public boolean getErr_flg(){
		return err_flg;
	}
 
}