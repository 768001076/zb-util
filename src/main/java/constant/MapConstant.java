package constant;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: Map常量
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/3/19
 */
public class MapConstant {

    /*
     * LOG使用常量
     */
    public static Map<String,List<String>> LOG_NAME_CONTENT = new HashMap<String, List<String>>();

    /*
     * MQ监控信息
     */
    public static Map<String,JSONArray> MQServerMonitorInfo = new HashMap<String, JSONArray>();

    /*
     * 更新时间
     */
    public static Map<String,String> LastUpdateTime = new HashMap<String, String>();

}
