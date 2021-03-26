package c3_4;

public class uselinearlist {
	private int no;// 배열의 현재원소
	private int size;// 배열크기
	private int increment;// 배열 확장단위
	private static int[] itemlist;// 원소저장배열

	public uselinearlist() {// 생성자
		no = -1;// 마지막원소 위치 변수
		size = 1;// 배열크기
		increment = 10;// 배열 꽉찬경우 10씩 크기늘리기위한 변수
		itemlist = new int[size];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		uselinearlist list1=new uselinearlist();
		list1.insert(12);
		list1.insert(24);
		list1.insert(36);
		
		list1.printlist(itemlist);
		System.out.println();
		list1.delete(24);
		list1.printlist(itemlist);
	}

	public boolean isempty() {// 공백검사
		return no == -1;
	}

	public void insert(int x) {// 원소 삽입 메소드
		int pos = 0;// 삽입위치 index
		if (no == size - 1) {// 만약 리스트가 꽉차있는경우
			size += increment;
			int[] temp = new int[size];// 기존보다 10더큰 배열 생성
			for (int i = 0; i <= no; i++)
				temp[i] = itemlist[i];
			itemlist = temp;// 크기가 10늘어난배열 생성완료
		}

		if (isempty() == true)// 공백인경우 배열 index늘리고 x그냥 넣는다
		{
			no++;//
			itemlist[no] = x;
		} else// 꽉차지도 텅비지도 않은경우
		{
			for (int i = 0; i <= no; i++) {
				if (x > itemlist[i])// x가 itemlist[i]원소보다 큰경우
				{
					pos++;// 삽입위치 ++
				}
			}
			for (int i = no + 1; i > pos; i--)// 삽입위치 pos를 찾았으면 배열 현재위치 +1자리부터 pos위치까지의 배열 원소를 하나씩 오른쪽으로 옮겨준다
			{
				itemlist[i] = itemlist[i - 1];
			}
			itemlist[pos] = x;// 다 옮겼으면 pos위치에 x를 넣는다
			no++;
		}
	}

	public void delete(int x) {//원소 삭제 메소드
		if(isempty()) {//리스트 비어 있으면 비었다고 출력한다
			System.out.println("there is no value in the list");
		}
		else{//뭔가 들어있으면 x랑 같은값을찾아 삭제위치를 찾는다
			int delloc=-1;
		for(int i=0;i<=no;i++)
		{
			if(x==itemlist[i])
			{
				 delloc=i;
			}
		}
		
		if(delloc==-1)//삭제할 x가 없으면 삭제할게 없다고 출력한다
		{
		System.out.println("there is no "+x);
		}
		else//반복문돌며 삭제위치부터 앞에 원소 덮어쓰기하면서 삭제한후 배열 현제원소위치를 -1한다
		{
			for(int i=delloc;i<=no;i++)
			{
				itemlist[i]=itemlist[i+1];
			}
			no--;
		}
	}
	}
	
	public void printlist(int []a) {
		for(int i=0;i<=no;i++)
		{
			System.out.print(a[i]+",");
		}
	}
}
