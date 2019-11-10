import java.util.Random;
class Output implements Runnable{
	private Storage st;
	Output(Storage st){
		this.st=st;
	}
	public void run(){
		while(true){
                                Random r=new Random();
    		if(r.nextInt(1000)>500) {
    			try{
    				Thread.sleep(2000);
    			}catch(InterruptedException e) {
    				e.printStackTrace();
    			}
    			
    		}
			st.get();
		}
	}
}