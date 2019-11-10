
class Storage {
	private int[] cells=new int[1000];
	
	private int inPos,outPos,count=0;
	private int count1;

	public synchronized void put(int num){
		try{
			while(count1==cells.length){
				this.wait();
			}
		cells[inPos]=num;
		count++;
		System.out.println("用户["+cells[inPos]+"]登录，当前在线人数"+count);
		inPos++;
		if(inPos==cells.length)
			inPos=0;
		count1++;
		this.notify();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public synchronized void get(){
		try{
			while(count1==0){
				this.wait();
			}
		int data=cells[outPos];
                                count--;
		System.out.println("用户["+data+"]注销，当前在线人数"+count);
                                 cells[outPos]=0;
		outPos++;
		if(outPos==cells.length)
			outPos=0;
		count1--;
		this.notify();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
