package ObjectData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonObject {
    //face splitul dupa ',' si v a retuna lista pentru a completa mai multe valuri intr un field

    public List<String> getValueList (String value)
    {
    String[] valueSplit = value.split(",");
    return Arrays.stream(valueSplit).collect(Collectors.toList());
    }
}
