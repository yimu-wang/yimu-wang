package ��9����ҵ;

public class Example {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1������----------");
		add();
		System.out.println("2��ɾ��-----------");
		remove();
		System.out.println("3���޸�-----------");
		alter();
	}
	public static void add() {
		StringBuffer sb=new StringBuffer();  //����һ���ַ���������
		StringBuffer bt=new StringBuffer(); 
		sb.append("һľ");                 //�������
		bt.append("123456");               //���ѧ��
		System.out.println("append��ӽ����"+sb+bt);
		sb.insert(2,"����");                  //��ָ��λ������ַ�
		bt.insert(5, "789");
		System.out.println("insert��ӵĽ����"+sb+bt);
	}
	public static void remove() {
		StringBuffer sb=new StringBuffer("һľ����");
		StringBuffer bt=new StringBuffer("123456789"); 
		System.out.println("��������ӣ�"+sb+bt);
		bt.delete(1, 5);           //ָ��λ��ɾ��
		System.out.println("ɾ��ָ��λ�õĽ����"+sb+bt);
		sb.deleteCharAt(2);    
		System.out.println("ָ��λ��ɾ����Ľ����"+sb+bt);
		bt.delete(0, sb.length());
		System.out.println("��ջ������Ľ����"+sb+bt);
	}
	public static void alter() {
		StringBuffer sb =new StringBuffer("ľ��");
		StringBuffer bt=new StringBuffer("177456789");
		System.out.println("��ʼ��"+sb+bt);
		sb.setCharAt(1, 'ʱ');
		System.out.println("�޸�ָ��λ���ַ������"+sb+bt);
		bt.replace(1, 3, "23");
		System.out.println("�滻ָ��λ���ַ����Ľ����"+sb+bt);
		System.out.println("�ַ�����ת�����"+sb+bt.reverse());
	}

}
