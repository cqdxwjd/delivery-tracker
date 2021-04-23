import com.yunli.common.json.JSONObject;

import java.util.HashMap;

public class TestJson {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("wangjingdong", "123");
        map.put("lilei", "456");
        System.out.println(JSONObject.valueToString(map));
    }
}
