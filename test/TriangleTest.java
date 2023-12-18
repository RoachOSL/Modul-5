import dev.Roach.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void triangleCorrectResult() {
        Triangle testObject = new Triangle(3, 5);
        Assertions.assertEquals(7, testObject.calculateArea());
    }

    @Test
    public void triangleNegativeValues() {
        Triangle testObject = new Triangle(-3, -4);
        Assertions.assertEquals(0, testObject.calculateArea());
    }

    @Test
    public void triangleZeroCheck() {
        Triangle testObject = new Triangle(0, 0);
        Assertions.assertEquals(0, testObject.calculateArea());
    }


}
