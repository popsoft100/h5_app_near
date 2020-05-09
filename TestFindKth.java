import java.util.ArrayList;
import java.util.List;

public class TestFindKth {

	public static void main(String[] args) {
		
		int [] arr = {13,2,11,3,18,15,1,17,22,98,4,5,7,12,14,26,9,4,6};
        int k = 5;
        int result = findKth(arr,k);
        System.out.println("result = "+result);
	}

	public static int findKth(int[] arr,int k){
		System.out.print("K为: "+k+" 输入数据为:[ ");
		for(int a:arr)System.out.print(a+" ");
		System.out.println(" ] ");
		System.out.println("以下是处理过程： ");
		
		
	        //（缓存数据）已知最大值（用于对比）
	        int cacheMaybeMaxNum=-1;
	        //排序最大值
	        int sortMax=-1;
	        //排序最大值索引
	        int sortMaxIndex = -1;
	        //只存放奇数的数组
	        List<Integer> arrOdd=new ArrayList<>();
	        for (int i = 0; i < arr.length; i++) {
	            //获取奇数
	            if(arr[i]%2==1) {
	                //如果大于已知最大值
	                if (arr[i] >= cacheMaybeMaxNum) {
	                    //添加数据，并纪录最大值
	                    if (arrOdd.size() < k) {
	                    	arrOdd.add(arr[i]);
	                    	cacheMaybeMaxNum = arr[i];
	                    }
	                } else {
	                    //如果小于（对比值）则加到开头
	                    arrOdd.add(0, arr[i]);
	                    if (arrOdd.size() >k) {
	                    	//由于数据数量已经超过K了，要找出最大值
	                    	cacheMaybeMaxNum=-1;
	                    	for(int m=0;m<arrOdd.size();m++) {
	                    		if (arrOdd.get(m)>cacheMaybeMaxNum) {
	                        		cacheMaybeMaxNum = arrOdd.get(m);
	                        		sortMaxIndex = m;
	                        	}
	                    	}
	                    	//移除最大值
	                    	arrOdd.remove(sortMaxIndex);
	                        cacheMaybeMaxNum=-1;
	                        //重新设置最大值
	                        for(int j=0;j<arrOdd.size();j++) {
	                        	if (arrOdd.get(j)>cacheMaybeMaxNum) {
	                        		cacheMaybeMaxNum = arrOdd.get(j);
	                        	}
	                        }
	                    }
	                }
	                System.out.println("NOW = "+arr[i]+" MAX = "+cacheMaybeMaxNum+" CACHE = "+arrOdd);
	            }
	        }
	        if (arrOdd.size()>=k) {
	            return cacheMaybeMaxNum;
	        }else{
	            return 0;
	        }
	}
}
