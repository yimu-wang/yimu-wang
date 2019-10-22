public class newline
{
	public static void main (String[] args){
		for(int i=1;i<=100;i++){
			 System.out.println("main线程正在打印：main "+i);
		}
        Xiancheng x=new Xiancheng();
		new Thread(x,"新线程").start();
         
	}
}

class Xiancheng implements Runnable
{   	public void run(){		
				for(int i=1;i<=50;i++){
               Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"正在打印：new "+i);
				}
             
}       
}