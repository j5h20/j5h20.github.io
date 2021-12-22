public class MiGong{
	public static void main(String []args){

		int arr[][] = new int[8][7];
		//用 1表示不能走，0表示可以走
		//将第一行和最后一行置1 
		for(int i = 0 ; i < 7;i++)
		{
			arr[0][i] = 1;
			arr[7][i] = 1;
		}
	for(int i = 0 ; i < 8;i++)
		{
			arr[i][0] = 1;
			arr[i][6] = 1;
		}
		arr[3][1] = 1;
		arr[3][2] = 1;
		arr[2][2] = 1;





		for(int i = 0 ;i < arr.length ; i++)
		{
			for(int j = 0 ; j < arr[i].length ;j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		H h = new H();
		h.findway(arr,1,1);
		System.out.println("\n=========找路情况如下========");

			for(int i = 0 ;i < arr.length ; i++)
		{
			for(int j = 0 ; j < arr[i].length ;j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}



	}
}

class H{

	//思路分析：
	//1.findway方法就是专门找迷宫的路径
	//2.如果找回，就返回true，否则返回false
	//3.arr是二维数组，表示迷宫
	//4.i，j 表示老鼠的位置，初始化为arr[1][1]
	//5.因为我们是递归找路，所以先规定 arr数组的各个值的含义
	//  0  表示可以路走，1表示障碍物  2 表示可以走通  3 表示已经走过
	//6.当arr[6][5] = 2 的时候就说明找到通路，可以结束，否则就继续找
	//7.先确定老鼠找路的策略  下 -> 右 -> 上 -> 左

	public boolean findway(int[][] arr,int i,int j){
		//说明已经找到了路
		if(arr[6][5] == 2){
			return true;
		}
		else{

			//假定当前位置为 0 表示可以走
			if(arr[i][j] == 0){
				//假定当前位置可以走通
				arr[i][j] = 2;	
				//使用找路策略，来确定该位置是否真的可以走通
				//下 -> 右 -> 上 -> 左
				//就是看下一个位置是否为真，是否可以走通
				if(findway(arr,i+1,j)){
					//下
					return true;
				}
				else if(findway(arr,i,j+1)){
					//右
					return true;
				}
				else if(findway(arr,i-1,j)){
					//上
					return true;
				}
				else if(findway(arr,i,j-1)){
					//左
					return true;
				}
				else{
					arr[i][j]  = 3;
					return false;
				}

			}
			else{
				return false;
			}

		}

	}

}

