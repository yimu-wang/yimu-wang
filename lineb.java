public class lineb
{
	public static void main (String[] args){
        TicketWindow tw=new TicketWindow();
        new Thread(tw,"�߳� 1").start();
		new Thread(tw,"�߳� 2").start();
		
	}
}

class TicketWindow implements Runnable
{   
	private int tickets=1;
	public void run(){
			while(true){
			if(tickets<=100){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
                System.out.println(th_name+"�������ص�%"+tickets+++"���ļ�");
			}
			}		
}
        
}

