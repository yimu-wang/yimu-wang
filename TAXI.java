public class TAXI
{
	public static void main (String[] args){
        TicketWindow tw=new TicketWindow();
        new Thread(tw,"出租车 1").start();
		new Thread(tw,"出租车 2").start();
		new Thread(tw,"出租车 3").start();
		new Thread(tw,"出租车 4").start();
		new Thread(tw,"出租车 5").start();
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

                System.out.println(th_name+"正在接送第"+d+" "+a+" "+b+" "+c+" 4个乘客");
                
			}
			}		
}
        
}