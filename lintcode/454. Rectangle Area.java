public class Rectangle {
    /*
     * Define two public attributes width and height of type int.
     */
    public int width, height;

    /*
     * Define a constructor which expects two parameters width and height here.
     */
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /*
     * Define a public method `getArea` which can calculate the area of the
     * rectangle and return.
     */
    public int getArea() {
        return this.width * this.height;
    }
}