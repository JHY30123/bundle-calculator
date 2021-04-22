import com.codetest.Bundle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BundleCalculatorTest {
    @Test
    public void totalCostOfEmptyBundle() {
        Bundle bundle = new Bundle(0, "IMG");
        assertEquals(0.0, bundle.bundleCalculator(), 0.0);
    }

    @Test
    public void totalCostOfContentFitsSinglePackage() {
        Bundle bundle = new Bundle(10, "IMG");
        assertEquals(800.0, bundle.bundleCalculator(), 0.0);
    }

    @Test
    public void totalCostOfContentFitsMultiplePackage() {
        Bundle bundle = new Bundle(15, "IMG");
        assertEquals(1250.0, bundle.bundleCalculator(), 0.0);
    }

    @Test
    public void totalCostOfVIDInSingleFittingSituation() {
        Bundle bundle = new Bundle(13, "VID");
        assertEquals(2370.0, bundle.bundleCalculator(), 0.0);
    }

    @Test
    public void totalCostOfVIDInMultipleFittingSituation() {
        Bundle bundle = new Bundle(18, "VID");
        assertEquals(3060.0, bundle.bundleCalculator(), 0.0);
    }

}
