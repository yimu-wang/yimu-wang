public class teacher
{
	public static void main (String[] args){
        TicketWindow tw=new TicketWindow();
        new Thread(tw,"����ʦ").start();
		new Thread(tw,"����ʦ").start();
		new Thread(tw,"����ʦ").start();
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
                System.out.println(th_name+"���ڷ���"+tickets+++"��ѧϰ�ʼ�");
			}
			}		
}
        
}