package Test;

public class Test {
    public static void main(String[] args) {
        A b = new B();
        b.test();
        System.out.println(b.hashCode());
    }
}
abstract class A{

    protected  abstract void test();

}

class B extends A {
    @Override
    protected  void test() {
        System.out.println("A");
    }

}

class C extends B {
    @Override
    public void test() {
        System.out.println("B");
    }
}
interface AA{
    int a=1;

    void test();
    static void test2(){
        System.out.println("b");
    }
}