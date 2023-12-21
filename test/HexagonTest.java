import dev.Roach.Hexagon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HexagonTest {

    @Test
    public void hexagonCorrectResult() {
        Hexagon testObject = new Hexagon(5);
        Assertions.assertEquals(64, testObject.calculateArea());
    }

    @Test
    public void hexagonNegativeValues() {
        Hexagon testObject = new Hexagon(-1);
        Assertions.assertEquals(0, testObject.calculateArea());
    }

    @Test
    public void hexagonZeroCheck() {
        Hexagon testObject = new Hexagon(0);
        Assertions.assertEquals(0, testObject.calculateArea());
    }

}
