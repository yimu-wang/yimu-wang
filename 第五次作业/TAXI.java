public class TAXI
{
	public static void main (String[] args){
        TicketWindow tw=new TicketWindow();
        new Thread(tw,"���⳵ 1").start();
		new Thread(tw,"���⳵ 2").start();
		new Thread(tw,"���⳵ 3").start();
		new Thread(tw,"���⳵ 4").start();
		new Thread(tw,"���⳵ 5").start();
	}
}

class TicketWindow implements Runnable
{   
	private int tickets=1,a,b,c,d;
	public void run(){
			while(true){
			if(tickets<=100){
				
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				
				d=tickets;
				a=tickets+1;
				b=tickets+2;
				c=tickets+3;
				tickets=tickets+4;

                System.out.println(th_name+"���ڽ��͵�"+d+" "+a+" "+b+" "+c+" 4���˿�");
                
			}
			}		
}
        
}