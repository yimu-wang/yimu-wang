abstract class Animal{
      abstract void shout();
}
class Dog extends Animal{
       void shout (){
	System.out.println("汪汪");
       }
}
public class JDGC{
       public static void main (String[] args){
	Dog dog=new Dog();
	dog.shout();
       }
}