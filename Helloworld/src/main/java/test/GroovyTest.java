package test;

import javax.script.*;
import java.util.Date;

public class GroovyTest {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {


//        String script = "def getP(){return new String(\"eric\");}";
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine =  factory.getEngineByName("groovy");
//
//
//        engine.eval(script);
//        Invocable inv = (Invocable) engine;
//        String value = (String)inv.invokeFunction("getP");
//        System.out.println(value);


        // 初始化Bindings
        Bindings bindings = engine.createBindings();
        // 绑定参数
        bindings.put("date", new Date());
        final String name = "groovy";
        // 定义groovy脚本中执行方法的名称
        final String scriptName = "execute";
        // 定义groovy脚本内容


        final String scriptContent = "def " + scriptName + "(name){" +
                "    println(\"now dateTime is: ${date.getTime()}\");" +
                "    println(\"my name is $name\");" +
                "    return date.getTime() > 0;" +
                "}";
        try {
            // 执行脚本
            engine.eval(scriptContent, bindings);
            // 获取执行结果
            Invocable invocable = (Invocable) engine;
            Boolean flag = (Boolean) invocable.invokeFunction(scriptName, name);
            System.out.println("---------------------------------------");
            System.out.println("result is: " + flag);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
