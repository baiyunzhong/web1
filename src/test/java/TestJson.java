import com.jnshu.ssm.pojo.JsonItem;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.support.ManagedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author : baiyunzhong
 * created time : 2019/7/24
 */
public class TestJson {
    public static void main(String[] args) {
        JsonItem jsonItem1 = new JsonItem("itemName1",21,"String");
        JsonItem jsonItem2 = new JsonItem("itemName2",33,"Boolean");
        JsonItem jsonItem3 = new JsonItem("itemName3",44,"Integer");

        //构造一个List集合
        List<JsonItem> list = new ArrayList<>();
        list.add(jsonItem1);
        list.add(jsonItem2);
        list.add(jsonItem3);

        //构造一个数组
        JsonItem[] arry ={jsonItem1,jsonItem2,jsonItem3};

        //构造一个map集合
        Map<String,JsonItem> map = new HashMap<>();
        map.put(jsonItem1.getName(),jsonItem1);
        map.put(jsonItem2.getName(),jsonItem2);
        map.put(jsonItem3.getName(),jsonItem3);

        //把java数组转化成JsonArray
        JSONArray jsonArray =JSONArray.fromObject(arry);
        System.out.println(jsonArray);
        //把List集合转化成JsonArray
        jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
        //把Map集合转化成JsonObject
        JSONObject jsonObject = JSONObject.fromObject(map);
        System.out.println(jsonObject);
        //把普通的javaBean转化成JsonObject
        jsonObject = JSONObject.fromObject(jsonItem1);
        System.out.println(jsonObject);
        //把JsonObject转化成javaBean
        JsonItem jsonItem = (JsonItem) JSONObject.toBean(jsonObject,JsonItem.class);
        System.out.println(jsonItem);
        //JsonObject的方法
        String name = (String)jsonObject.get("name");
        System.out.println(name);
        //向Json对象添加JavaBean对象或任意类型数据
        JSONObject jsonObject1 = jsonObject.accumulate("new","苏是");
        System.out.println(jsonObject1);
        JSONObject jsonObject2 = (JSONObject) jsonObject.put("new2",jsonItem2);
        System.out.println(jsonObject2);

    }
}
