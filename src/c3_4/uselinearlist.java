package c3_4;

public class uselinearlist {
	private int no;// �迭�� �������
	private int size;// �迭ũ��
	private int increment;// �迭 Ȯ�����
	private static int[] itemlist;// ��������迭

	public uselinearlist() {// ������
		no = -1;// ���������� ��ġ ����
		size = 1;// �迭ũ��
		increment = 10;// �迭 ������� 10�� ũ��ø������� ����
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

	public boolean isempty() {// ����˻�
		return no == -1;
	}

	public void insert(int x) {// ���� ���� �޼ҵ�
		int pos = 0;// ������ġ index
		if (no == size - 1) {// ���� ����Ʈ�� �����ִ°��
			size += increment;
			int[] temp = new int[size];// �������� 10��ū �迭 ����
			for (int i = 0; i <= no; i++)
				temp[i] = itemlist[i];
			itemlist = temp;// ũ�Ⱑ 10�þ�迭 �����Ϸ�
		}

		if (isempty() == true)// �����ΰ�� �迭 index�ø��� x�׳� �ִ´�
		{
			no++;//
			itemlist[no] = x;
		} else// �������� �ֺ����� �������
		{
			for (int i = 0; i <= no; i++) {
				if (x > itemlist[i])// x�� itemlist[i]���Һ��� ū���
				{
					pos++;// ������ġ ++
				}
			}
			for (int i = no + 1; i > pos; i--)// ������ġ pos�� ã������ �迭 ������ġ +1�ڸ����� pos��ġ������ �迭 ���Ҹ� �ϳ��� ���������� �Ű��ش�
			{
				itemlist[i] = itemlist[i - 1];
			}
			itemlist[pos] = x;// �� �Ű����� pos��ġ�� x�� �ִ´�
			no++;
		}
	}

	public void delete(int x) {//���� ���� �޼ҵ�
		if(isempty()) {//����Ʈ ��� ������ ����ٰ� ����Ѵ�
			System.out.println("there is no value in the list");
		}
		else{//���� ��������� x�� ��������ã�� ������ġ�� ã�´�
			int delloc=-1;
		for(int i=0;i<=no;i++)
		{
			if(x==itemlist[i])
			{
				 delloc=i;
			}
		}
		
		if(delloc==-1)//������ x�� ������ �����Ұ� ���ٰ� ����Ѵ�
		{
		System.out.println("there is no "+x);
		}
		else//�ݺ������� ������ġ���� �տ� ���� ������ϸ鼭 �������� �迭 ����������ġ�� -1�Ѵ�
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
