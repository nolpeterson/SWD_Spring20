import java.util.HashMap;

/**
 * Form - an Object that contains fields of a Hashmap.
 */
public class Form {
    /**
     * The Fields.
     */
    private HashMap<String, String> fields;
    /**
     * The Output str.
     */
    private String outputStr;

    /**
     * Instantiates a new Form.
     * @param fields stores Key, Value pairs of the Fields Hashmap.
     */
    public Form(HashMap<String, String> fields){
        this.fields = fields;
    }

    /**
     * ToString output.
     * @return output String using overridden toString to display all Key, Value pairs of the Fields Hashmap.
     */
    @Override
    public String toString() {
        outputStr = "\n-Form Info-";
        for(String item: fields.keySet()){
            outputStr += "\nKey: " + item + "\nValue: " + fields.get(item);
        }
        return outputStr;
    }
}
