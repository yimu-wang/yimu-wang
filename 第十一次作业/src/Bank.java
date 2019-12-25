import java.util.Scanner;

public class Bank {
	
     int account;
     private static User user;
     
     public static void main(String[] args) throws Exception{
    	 Bank bank=new Bank();
    	 System.out.println("��ӭ������������ϵͳ��");
    	 while(true) {
    		System.out.println("���������Ĳ�����1-��¼��2-ע�ᣬ0-�˳�");
    	    Scanner is=new Scanner(System.in);
    	    int num=is.nextInt();
    	    switch(num) {
    	    case 1:
    	    	bank.login();
    	    	bank.operate();
    	    case 2:
    	    	bank.register();
    	    	System.out.println("�Ƿ񱣴�ע����Ϣ��������yes��no");
    	    	Scanner ins=new Scanner(System.in);
    	        String str=ins.nextLine();
    	        if(str.equals("yes")) {
    	        	bank.save();
    	        	System.out.println("����ɹ���");
    	        }else {
    	        	System.out.println("�������Ϣ��������������");
    	        	continue;
    	        }
    	        break;
    	    case 0:
    	    	return;
    	    default:
    	    	System.out.println("������0~2֮�������ѡ����ز�����");
    	    	break;
    	    } 
    	 }
    	 
     }
     
     public void login() throws Exception{
    	 DBUtil dbutil = DBUtil.getInstance();
    	 System.out.println("��ӭ��¼��������ϵͳ��");
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
     public void operate() throws Exception{
    	 Bank bank=new Bank();
    	 DBUtil dbutil=DBUtil.getInstance();
    	 while(true){
    		 System.out.println("��������Ҫ���еĲ������ͣ����س���������");
    		 System.out.println("��1"+"\t"+"ȡ�2"+"\t"+"��3"+"\t"+"�˳���0");
    		 Scanner number=new Scanner(System.in);
    		 int num1 = number.nextInt();
    		 if(num1==1||num1==2){
    			 int num=0;
    			 try{
    				 System.out.print("������ȡ����:");
    				 num = number.nextInt();         // Integer.parseInt(str.nextLine());
    			 }catch(Exception e){
    				 System.out.println("����������");
    				 continue;
    			 }
    			 switch(num1) {
    			 case 1:
    				 bank.inCome(num);//������
    				 break;
    			 case 2:
    				 bank.takeOut(num);//ȡ�����
    				 break;
    			 }
    		 }else if(num1==3) {
    			 bank.show();
    		 }else if(num1==0) {
    			 System.out.println("�˳�ϵͳ��");
    			 dbutil.update();
    			 System.exit(0);
    			 //break;
    		 }else {
    			 System.out.println("������0~3֮�������ѡ����ز�����");
    		 }
    	 }
     }
     /*
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
     */
     public void register() throws Exception {
    	 User u=new User();
    	 Scanner scanner=new Scanner(System.in);
    	 System.out.println("���뿨�ţ�");
    	 u.setCardId(scanner.nextLine());
    	 System.out.println("�����û�����");
    	 u.setUseName(scanner.nextLine());
    	 System.out.println("�������룺");
    	 u.setCardPwd(scanner.nextLine());
    	 System.out.println("�����ֻ��ţ�");
    	 u.setCall(scanner.nextLine());
    	 System.out.println("�������");
    	 u.setAmount(scanner.nextInt());
    	 DBUtil dbutil = DBUtil.getInstance();
    	 dbutil.addUser(u);
     }
     public void save() throws Exception {
    	 DBUtil dbutil=DBUtil.getInstance();
    	 dbutil.update();
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