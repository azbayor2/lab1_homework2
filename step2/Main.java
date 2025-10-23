package step2;

import java.util.*;

class Animal {
    void sound() { System.out.println("(동물이 소리를 냅니다)"); }
    void fly() {System.out.println("(동물이 납니다)");};
}

class Dog extends Animal {
    @Override
    void sound() {System.out.println("멍멍!"); }
}

class Cat extends Animal {
    @Override
    void sound() { System.out.println("야옹!"); }
}

class Bird extends Animal {
    @Override
    void sound() { System.out.println("쨱짹"); }
    void fly() { System.out.println("새가 납니다"); }
}

public class Main {
    public static void main(String[] args) {
        // Animal a1 = new Dog();
        // Animal a2 = new Cat();

        // a1.sound();  // 멍멍!
        // a2.sound();  // 야옹!

        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Bird());
        animals.add(new Cat());

        Iterator<Animal> it = animals.iterator();

        // while(it.hasNext()){
        //     Animal cur = it.next();
        //     cur.sound();
        // }

        animals.forEach(c->{c.sound();});
        animals.get(1).fly();

        return;
    }

}