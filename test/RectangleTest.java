import dev.Roach.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RectangleTest {


    @Test
    public void rectangleCorrectResult() {
        Rectangle testObject = new Rectangle(3, 4);
        Assertions.assertEquals(12, testObject.calculateArea());
    }

    @Test
    public void rectangleNegativeValues() {
        Rectangle testObject = new Rectangle(-3, -4);
        Assertions.assertEquals(0, testObject.calculateArea());
    }

    @Test
    public void rectangleZeroCheck() {
        Rectangle testObject = new Rectangle(0, 0);
        Assertions.assertEquals(0, testObject.calculateArea());
    }


}
