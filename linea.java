public class linea
{
	public static void main (String[] args){
        Thread x1=new Xiancheng("线程一");
        Thread x2=new Xiancheng("线程二");
		x1.start();
		x2.start();  
	}
}

class Xiancheng extends Thread
{   
	public Xiancheng(String name){
			super(name);
		}
	public void run(){
		
				Thread th=Thread.currentThread();
				String th_name=th.getName();
                System.out.println("这个线程的名字是："+th_name);
				
}       
}