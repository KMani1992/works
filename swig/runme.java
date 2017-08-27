
public class runme {

  static {
    try {
	//System.loadLibrary("example");
        System.load("/home/mani/jni_test/swig/libexample.so");
    } catch (UnsatisfiedLinkError e) {
      System.err.println("Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n" + e);
      System.exit(1);
    }
  }

  public static void main(String argv[]) {
    // Call our gcd() function
    
    int x = 42;
    int y = 105;
    int g = example.gcd(x,y);
    System.out.println("The gcd of " + x + " and " + y + " is " + g);
    
    // Manipulate the Foo global variable
    
    // Output its current value
    System.out.println("Foo = " + example.getFoo());
    
    // Change its value
    example.setFoo(4.1415926);
    
    // See if the change took effect
    System.out.println("Foo = " + example.getFoo());

Vector v = new Vector();

v.setX(3001);

v.setY(7);

int xx = v.getX();
int yy = v.getY();

example.setVec(v);
example.printVal();

System.out.println("struct = " + xx);

  }
}
