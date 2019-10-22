public class teacher
{
	public static void main (String[] args){
        TicketWindow tw=new TicketWindow();
        new Thread(tw,"张老师").start();
		new Thread(tw,"李老师").start();
		new Thread(tw,"王老师").start();
	}
}

class TicketWindow implements Runnable
{   
	private int tickets=1;
	public void run(){
			while(true){
			if(tickets<=80){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
                System.out.println(th_name+"正在发第"+tickets+++"份学习笔记");
			}
			}		
}
        
}