interface Animal{
        void shout ();
}
class Cat implements Animal{
        public void shout(){
	System.out.println("喵喵......");
        }
        void sleep(){
	System.out.println("maoshuijiao......");
        }
}
class Dog implements Animal{
       public void shout(){
	System.out.println("汪汪......");
        }
}
public class GCMS{
       public static void main(String[] args) {
	Dog dog=new Dog();
	animalShout(dog);
        }
        public static void animalShout(Animal animal){
	Cat cat=(Cat)animal;
	cat.sleep();
	cat.shout();
        }
}