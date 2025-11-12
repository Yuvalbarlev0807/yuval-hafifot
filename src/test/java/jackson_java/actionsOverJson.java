package jackson_java;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jackson_java.logics.JsonPathResult;

import java.io.File;

import static jackson_java.logics.logics.*;

public class actionsOverJson {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String renameField(File json, String path, String newFieldName) throws Exception {
        JsonNode rootNode = mapper.readTree(json);
        ObjectNode rootObject = (ObjectNode) rootNode;
        JsonPathResult result = getNodeByPathDetailed(rootObject, path);

        if (result.parent.isObject()) {
            ObjectNode parentObj = (ObjectNode) result.parent;
            JsonNode value = parentObj.get(result.fieldName);
            parentObj.remove(result.fieldName);
            parentObj.set(newFieldName, value);

        } else if (result.parent.isArray()) {
            renameArrayField(result,newFieldName);
        }
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
    }

    public static String changeValue(File json, String path, Object newValue) throws Exception {
        JsonNode rootNode = mapper.readTree(json);
        ObjectNode rootObject = (ObjectNode) rootNode;
        JsonPathResult result = getNodeByPathDetailed(rootObject, path);
        JsonNode newValueNode = mapper.valueToTree(newValue);

        if (result.parent.isArray()) {
            ArrayNode arrayNode = (ArrayNode) result.parent;
            arrayNode.set(result.arrayIndex, newValueNode);
        } else if (result.parent.isObject()) {
            ObjectNode objNode = (ObjectNode) result.parent;
            objNode.set(result.fieldName, newValueNode);
        }

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootObject);
    }

    public static String deleteField(File json, String path) throws Exception {
        JsonNode rootNode = mapper.readTree(json);
        ObjectNode rootObject = (ObjectNode) rootNode;
        JsonPathResult result = getNodeByPathDetailed(rootObject, path);

        if (result.parent.isArray()) {
            ArrayNode arrayNode = (ArrayNode) result.parent;
            arrayNode.remove(result.arrayIndex);
        } else if (result.parent.isObject()) {
            ObjectNode objNode = (ObjectNode) result.parent;
            objNode.remove(result.fieldName);
        }
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
    }

    public static String extracDataFromField(File json, String path) throws Exception {
        JsonNode rootNode = mapper.readTree(json);
        ObjectNode rootObject = (ObjectNode) rootNode;
        JsonPathResult result = getNodeByPathDetailed(rootObject, path);
        JsonNode Extractedvalue = null;

        if (result.parent.isObject()) {
            Extractedvalue = extractFromObject(result);

        } else if (result.parent.isArray()) {
            Extractedvalue = extractFromArray(result);
        }
        return (Extractedvalue.toString());
    }


}