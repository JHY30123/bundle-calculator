import com.codetest.BundleCalculator;
import com.codetest.BundleInfo;
import com.codetest.ResultInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BundleCalculatorTest {
    @Test
    public void costAndPlanOfVID11Bundle() {
        BundleInfo bundleInfo = new BundleInfo();
        BundleCalculator bundleCalculator = new BundleCalculator();
        bundleInfo.setPostFormat("VID");
        bundleInfo.setPostAmount(11);

        String detail1 = "2* $570.0";
        String detail2 = "1* $900.0";
        String[] details = new String[4];
        details[1] = detail1;
        details[2] =detail2;
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMinTotalPrice(2040.0);
        resultInfo.setPostAmount(11);
        resultInfo.setPostFormat("VID");
        resultInfo.setBundleSelectionDetail(details);

        assertEquals(resultInfo, bundleCalculator.minPriceCalculator(bundleInfo));
    }

    @Test
    public void costAndPlanOfIMG23Bundle() {
        BundleInfo bundleInfo = new BundleInfo();
        BundleCalculator bundleCalculator = new BundleCalculator();
        bundleInfo.setPostFormat("IMG");
        bundleInfo.setPostAmount(23);

        String detail1 = "1* $450.0";
        String detail2 = "2* $800.0";
        String[] details = new String[3];
        details[1] = detail1;
        details[2] = detail2;
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMinTotalPrice(2050.0);
        resultInfo.setPostAmount(23);
        resultInfo.setPostFormat("IMG");
        resultInfo.setBundleSelectionDetail(details);

        assertEquals(resultInfo, bundleCalculator.minPriceCalculator(bundleInfo));
    }

    @Test
    public void costAndPlanOfFlac9Bundle() {
        BundleInfo bundleInfo = new BundleInfo();
        BundleCalculator bundleCalculator = new BundleCalculator();
        bundleInfo.setPostFormat("Flac");
        bundleInfo.setPostAmount(9);

        String detail1 = "1* $1147.5";
        String[] details = new String[4];
        details[3] = detail1;
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setMinTotalPrice(1147.5);
        resultInfo.setPostAmount(9);
        resultInfo.setPostFormat("Flac");
        resultInfo.setBundleSelectionDetail(details);

        assertEquals(resultInfo, bundleCalculator.minPriceCalculator(bundleInfo));
    }
}
