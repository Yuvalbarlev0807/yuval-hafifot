package jackson_java;

import org.junit.jupiter.api.Test;

import java.io.File;

import static jackson_java.actionsOverJson.*;

public class jsonTests {
    File jsonFile = new File("src/test/java/jackson_java/jsonFile.json");

    @Test
    public void jsonTest() throws Exception {
        String returnedValue = renameField(jsonFile, "variants[0].sku", "yuval");
        String changedValue = changeValue(jsonFile, "features[0]", "yes");
        String deletedFieldJson = deleteField(jsonFile, "features");
        String extractedDate=extracDataFromField(jsonFile, "variants[0].sku");
        System.out.println(returnedValue);
    }
}