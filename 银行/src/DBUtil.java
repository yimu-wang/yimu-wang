import java.util.HashMap;

public class DBUtil {
     private static DBUtil instance = null;
     private HashMap<String, User> users = new HashMap<String,User>();
     
     private DBUtil(){
    	 //------高兴-------
    	 User user1=new User();
    	 user1.setUseName("高兴");
    	 user1.setCardid("111111");
    	 user1.setCardPwd("123456");
    	 user1.setAmount(6666);
    	 user1.setCall("15038500000");
    	 users.put(user1.getCardId(), user1);
    	//------黄金-------
    	 User user2=new User();
    	 user2.setUseName("黄金");
    	 user2.setCardid("222222");
    	 user2.setCardPwd("123456");
    	 user2.setAmount(5555);
    	 user2.setCall("15038500001");
    	 users.put(user2.getCardId(), user2);
    	//------富贵-------
    	 User user3=new User();
    	 user3.setUseName("富贵");
    	 user3.setCardid("333333");
    	 user3.setCardPwd("123456");
    	 user3.setAmount(4444);
    	 user3.setCall("15038500003");
    	 users.put(user2.getCardId(), user2);
     }
     //懒汉式单例模式
     public static DBUtil getInstance(){
    	 if(instance == null){
    		 synchronized (DBUtil.class){
    			 if(instance == null){
    				 instance = new DBUtil();
    			 }
    		 }
    	 }
		return instance;
     }
     public User getUser(String cardId){
    	 User user = (User) users.get(cardId);
    	 return user;
     }
     public HashMap<String,User> getUsers(){
    	 return users;
     }
}