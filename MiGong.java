public class MiGong{
	public static void main(String []args){

		int arr[][] = new int[8][7];
		//�� 1��ʾ�����ߣ�0��ʾ������
		//����һ�к����һ����1 
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
		System.out.println("\n=========��·�������========");

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

	//˼·������
	//1.findway��������ר�����Թ���·��
	//2.����һأ��ͷ���true�����򷵻�false
	//3.arr�Ƕ�ά���飬��ʾ�Թ�
	//4.i��j ��ʾ�����λ�ã���ʼ��Ϊarr[1][1]
	//5.��Ϊ�����ǵݹ���·�������ȹ涨 arr����ĸ���ֵ�ĺ���
	//  0  ��ʾ����·�ߣ�1��ʾ�ϰ���  2 ��ʾ������ͨ  3 ��ʾ�Ѿ��߹�
	//6.��arr[6][5] = 2 ��ʱ���˵���ҵ�ͨ·�����Խ���������ͼ�����
	//7.��ȷ��������·�Ĳ���  �� -> �� -> �� -> ��

	public boolean findway(int[][] arr,int i,int j){
		//˵���Ѿ��ҵ���·
		if(arr[6][5] == 2){
			return true;
		}
		else{

			//�ٶ���ǰλ��Ϊ 0 ��ʾ������
			if(arr[i][j] == 0){
				//�ٶ���ǰλ�ÿ�����ͨ
				arr[i][j] = 2;	
				//ʹ����·���ԣ���ȷ����λ���Ƿ���Ŀ�����ͨ
				//�� -> �� -> �� -> ��
				//���ǿ���һ��λ���Ƿ�Ϊ�棬�Ƿ������ͨ
				if(findway(arr,i+1,j)){
					//��
					return true;
				}
				else if(findway(arr,i,j+1)){
					//��
					return true;
				}
				else if(findway(arr,i-1,j)){
					//��
					return true;
				}
				else if(findway(arr,i,j-1)){
					//��
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

