//import com.codetest.entities.InputFields;
//import com.codetest.InputProcess;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class InputAndOutputTest {
//
//
//    public InputProcess inputProcess = new InputProcess();
//
//    @Test
//    public void testInputConvert() {
//        InputFields inputFields = new InputFields();
//        inputFields.setPostFormat("IMG");
//        inputFields.setPostAmount(12);
//
//        InputProcess inputProcess = new InputProcess();
//        assertEquals(inputFields, InputProcess.inputConvert("12 IMG"));
//    }
//
//    @Test
//    public void testGetInput() throws IOException {
//        List<String> input = new ArrayList<>();
//        String test1 = "13 IMG";
//        String test2 = "14 Flac";
//        String test3 = "10 VID";
//        input.add(test1);
//        input.add(test2);
//        input.add(test3);
//
//        InputStream inputExpect = new ByteArrayInputStream("13 IMG\n14 Flac\n10 VID\n\n ".getBytes());
//        System.setIn(inputExpect);
//        List<String> actualResult = inputProcess.getInput();
//        assertEquals(input, actualResult);
//    }
//}
