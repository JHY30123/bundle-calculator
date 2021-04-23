import com.codetest.Bundle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BundleCalculatorTest {
    @Test
    public void totalCostOfEmptyBundle() {
        Bundle bundle = new Bundle(0, "IMG");
        assertEquals(0.0, bundle.totalPriceCalculator(), 0.0);
    }

    @Test
    public void totalCostOfSingleFitsSinglePackage() {
        Bundle bundle = new Bundle(1, "IMG");
        assertEquals(450.0, bundle.totalPriceCalculator(), 0.0);
    }

    @Test
    public void totalCostOfItemDoesNotFitSinglePackageButGreaterThanTheSmallestBundle() {
        Bundle bundle = new Bundle(6, "IMG");
        assertEquals(800.0, bundle.totalPriceCalculator(), 0.0);
    }

    @Test
    public void totalCostOfContentFitsSinglePackage() {
        Bundle bundle = new Bundle(10, "IMG");
        assertEquals(800.0, bundle.totalPriceCalculator(), 0.0);
    }

    @Test
    public void totalCostOfContentFitsMultiplePackage() {
        Bundle bundle = new Bundle(15, "IMG");
        assertEquals(1250.0, bundle.totalPriceCalculator(), 0.0);
    }

    @Test
    public void totalCostOfVIDInSingleFittingSituation() {
        Bundle bundle = new Bundle(13, "VID");
        assertEquals(2370.0, bundle.totalPriceCalculator(), 0.0);
    }

    @Test
    public void totalCostOfVIDInMultipleFittingSituation() {
        Bundle bundle = new Bundle(18, "VID");
        assertEquals(3060.0, bundle.totalPriceCalculator(), 0.0);
    }

    @Test
    public void totalCostOfFlacInMaximumBundleSituation() {
        Bundle bundle = new Bundle(9, "Flac");
        assertEquals(1147.5, bundle.totalPriceCalculator(), 0.0);
    }

    @Test
    public void totalCostOfFlacInMaximumBundleSituation2() {
        Bundle bundle = new Bundle(11, "VID");
        assertEquals(2040.0, bundle.totalPriceCalculator(), 0.0);
    }


}
