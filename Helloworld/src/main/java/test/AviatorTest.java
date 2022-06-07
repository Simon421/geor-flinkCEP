package test;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

public class AviatorTest {

    public static void main(String[] args) {
        {
            Map<String, Object> env = new HashMap<String, Object>();
            env.put("A", 1);
            env.put("B", 2);
            env.put("C", 3);
            env.put("loginType","fail");


            String conditiion = "string.substring(loginType,1,2) == 'a'";
            Object result = AviatorEvaluator.execute(conditiion, env);
            System.out.println(result);

        }
    }
}
