package jackson_java.logics;
import com.fasterxml.jackson.databind.JsonNode;

public  class JsonPathResult {
    public JsonNode node;       // הצומת עצמו שאליו הגענו
    public JsonNode parent;     // האב של הצומת
    public String fieldName;    // שם השדה (אם האב הוא Object)
    public Integer arrayIndex;  // אינדקס (אם האב הוא Array)

}