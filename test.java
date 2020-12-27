import java.util.*;

class A implements Cloneable {
    private int a1;

    public A(int a) {
        a1 = a;
    }

    public void print() {

        System.out.println(a1);

    }

    public A clone() throws CloneNotSupportedException {
        return (A) super.clone();
    }
}

class B extends A {

    private List<Integer> b1 = new ArrayList<Integer>();

    public B(int b, int a1) {
        super(a1);
        b1.add(b);
    }

    public void add(int x) {
        b1.add(x);
    }
    @Override
    public B clone() throws CloneNotSupportedException {
        return (B) super.clone();


    }

    public void print() {

        for (int b : b1) System.out.println(b);
    }
}

public class test {

    public static void main(String[] args) throws CloneNotSupportedException {

        B b1 = new B(1, 1);

        B b2 = (B) b1.clone();

        b2.add(10);

        b1.print();
        b2.print();
    }
}
