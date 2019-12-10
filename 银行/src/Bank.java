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
    	 System.out.print("欢迎进入网上银行系统！");
    	 while(true) {
    		 Scanner in = new Scanner(System.in);
    		 System.out.println("请输入银号卡号：");
    		 String cardId = in.nextLine();
    		 System.out.println("请输入银号密码：");
    		 String cardPwd = in.nextLine();
    		 user = dbutil.getUser(cardId);
    		 //登陆---------
    		 if( dbutil.getUsers().containsKey(cardId)&&user.getCardPwd().equals(cardPwd)) {
    			 System.out.println("登陆成功，欢迎"+user.getUserName()+"先生");
    			 break;
    		 }else {
    			 System.out.println("银行卡号或密码错误！");
    			 continue;
    		 }
    	 }
     }
     public void operate(){
    	 Bank bank=new Bank();
    	 while(true){
    		 System.out.println("请输入您要进行的操作类型，按回车键结束！");
    		 System.out.println("存款：1"+"\t"+"取款：2"+"\t"+"余额：3"+"\t"+"退出：0");
    		 Scanner str=new Scanner(System.in);
    		 String s = str.nextLine();
    		 if("1".equals(s)||"2".equals(s)){
    			 int num=0;
    			 try{
    				 System.out.print("请输入取款金额:");
    				 num = Integer.parseInt(str.nextLine());
    			 }catch(Exception e){
    				 System.out.println("金额输入错误！");
    				 continue;
    			 }
    			 switch(s) {
    			 case "1":
    				 bank.inCome(num);//存款操作
    				 break;
    			 case "2":
    				 bank.takeOut(num);//取款操作
    				 break;
    			 }
    		 }else if("3".equals(s)) {
    			 bank.show();
    		 }else if("0".equals(s)) {
    			 System.out.println("退出系统！");
    			 return;
    		 }else {
    			 System.out.println("请输入0~3之间的数字选择相关操作！");
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