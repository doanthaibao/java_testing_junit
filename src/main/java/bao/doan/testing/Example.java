package bao.doan.testing;

public class Example {
  DependClass depend;

  public Example() {
    depend = new DependClass();
  }

  public static int sum(int a, int b) {
    return a + b;
  }

  public int abc() {
    return 10;
  }
  
  public int testSpy() {
    return this.abc() + 5;
  }

  public int test() {
    return depend.getInt() + 5;
  }

  public String testStatic() {
    return StaticClass.getStatic() + " Bao";
  }
}
