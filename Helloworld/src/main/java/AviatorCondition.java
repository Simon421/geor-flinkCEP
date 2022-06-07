import com.googlecode.aviator.AviatorEvaluator;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.flink.cep.pattern.conditions.SimpleCondition;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AviatorCondition extends SimpleCondition<MetricEvent> implements Serializable {
    private static Logger logger = LoggerFactory.getLogger(AviatorCondition.class);
    public String script;
    static {
        AviatorEvaluator.addFunction(new GetFieldMapFunction());
        AviatorEvaluator.addFunction(new GetTagMapFunction());
    }
    public AviatorCondition(String script) {
        this.script = script;
    }

    @Override
    public boolean filter(MetricEvent event) throws Exception {
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("event", event);
        env.put("fields", event.getFields());
        env.put("tags", event.getTags());
        Boolean result = false;
        try {
            result = (Boolean) AviatorEvaluator.execute(script, env);
        } catch (Exception e) {
            logger.error("execute script with event error,script:{},event:{},error;{}", script, event, e);
        }
        return result;
    }

}