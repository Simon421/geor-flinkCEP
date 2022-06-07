import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

public class MainWithData {
    public static void main(String[] args) {
        //造数开始
        MetricEvent event  = new MetricEvent();
        Map<String, Object> fields = new HashMap<>();
        fields.put("load5",20.4);
        Map<String, String> tags = new HashMap<>();
        tags.put("cluster_name","terminus-x");

        event.setFields(fields);
        event.setTags(tags);

        AviatorEvaluator.addFunction(new GetFieldMapFunction());
        AviatorEvaluator.addFunction(new GetTagMapFunction());
         new HashMap<>();
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("event", event);
        env.put("fields", event.getFields());
        env.put("tags", event.getTags());
        Boolean result = false;
        try {
            result = (Boolean) AviatorEvaluator.execute("getT(tags,\"cluster_name\")==\"terminus-x\" && getF(fields,\"load5\")>15", env);
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error("execute script with event error,script:{},event:{},error;{}", script, event, e);
        }
        //return result;
        System.out.println(result);

    }
}
