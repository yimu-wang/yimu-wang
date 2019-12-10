import java.util.Scanner;

public class Bank {
	
     int account;
     private static User user;
     
     public static void main(String[] args){
    	 Bank bank=new Bank();
    	 bank.login();
    	 bank.operate();
     }
     
     public void login(){
    	 DBUtil dbutil = DBUtil.getInstance();
    	 System.out.print("��ӭ������������ϵͳ��");
    	 while(true) {
    		 Scanner in = new Scanner(System.in);
    		 System.out.println("���������ſ��ţ�");
    		 String cardId = in.nextLine();
    		 System.out.println("�������������룺");
    		 String cardPwd = in.nextLine();
    		 user = dbutil.getUser(cardId);
    		 //��½---------
    		 if( dbutil.getUsers().containsKey(cardId)&&user.getCardPwd().equals(cardPwd)) {
    			 System.out.println("��½�ɹ�����ӭ"+user.getUserName()+"����");
    			 break;
    		 }else {
    			 System.out.println("���п��Ż��������");
    			 continue;
    		 }
    	 }
     }
     public void operate(){
    	 Bank bank=new Bank();
    	 while(true){
    		 System.out.println("��������Ҫ���еĲ������ͣ����س���������");
    		 System.out.println("��1"+"\t"+"ȡ�2"+"\t"+"��3"+"\t"+"�˳���0");
    		 Scanner str=new Scanner(System.in);
    		 String s = str.nextLine();
    		 if("1".equals(s)||"2".equals(s)){
    			 int num=0;
    			 try{
    				 System.out.print("������ȡ����:");
    				 num = Integer.parseInt(str.nextLine());
    			 }catch(Exception e){
    				 System.out.println("����������");
    				 continue;
    			 }
    			 switch(s) {
    			 case "1":
    				 bank.inCome(num);//������
    				 break;
    			 case "2":
    				 bank.takeOut(num);//ȡ�����
    				 break;
    			 }
    		 }else if("3".equals(s)) {
    			 bank.show();
    		 }else if("0".equals(s)) {
    			 System.out.println("�˳�ϵͳ��");
    			 return;
    		 }else {
    			 System.out.println("������0~3֮�������ѡ����ز�����");
    		 }
    	 }
     }
     public void inCome(int num) {
    	 account=user.getAccount()+num;
    	 user.setAmount(account);
		//System.out.println(account);
     }
     public void takeOut(int num) {
    	 account=user.getAccount()-num;
    	 user.setAmount(account);
    	 //System.out.println(account);
     }
     public void show() {
    	 account=user.getAccount();
    	 user.setAmount(account);
    	 System.out.println(account);
     }
}