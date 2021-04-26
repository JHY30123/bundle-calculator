import com.codetest.*;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Log
public class Main {
    public static void main(String[] args) throws IOException {
        BundleCalculator bundleCalculator = new BundleCalculator();
        ReturnResultList returnResultList = new ReturnResultList();
        InputProcess inputProcess = new InputProcess();
        System.out.println("Please input posts amount and format, press enter twice to confirm");
        List<String> inputContent = inputProcess.getInput();

        List<BundleInfo> bundleInfos = inputContent.stream().map(InputProcess::inputConvert).collect(Collectors.toList());
        List<ResultInfo> resultInfos = bundleInfos.stream().map(bundleCalculator::minPriceCalculator).collect(Collectors.toList());
        resultInfos.forEach(returnResultList::returnResultInfo);

//        BundleCalculator bundleCalculator = new BundleCalculator();
//
//        BundleInfo bundleInfo = new BundleInfo();
//
//        bundleInfo.setPostAmount(11);
//        bundleInfo.setPostFormat("VID");
//
//        ResultInfo resultInfo =bundleCalculator.minPriceCalculator(bundleInfo);
//        System.out.println(resultInfo);
    }
}
