package interop_java_in_clojure;

import java.awt.Dimension;

public class InteropExample {

  public static void main(String[] args) {
    var myList = new java.util.ArrayList<String>();

    System.out.println("myList: " + myList.size());

    Dimension dimension = new Dimension(10, 20);

    System.out.println("dimension: " + dimension.width + "x" + dimension.height);

  }
}
