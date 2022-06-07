package test;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

public class AviatorUtil extends AbstractFunction {

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        Number num1 = FunctionUtils.getNumberValue(arg1,env);
        Number num2 = FunctionUtils.getNumberValue(arg2,env);
        //乘法
        AviatorObject o =  new AviatorDouble(num1.doubleValue() * num2.doubleValue());
        return o;
    }
    public String getName() {
        return "multiplication";
    }

    public static void main(String[] args) {
        AviatorEvaluator.addFunction(new AviatorUtil());
        System.out.println(AviatorEvaluator.execute("multiplication(5,4)"));//输出：20
        System.out.println(AviatorEvaluator.execute("multiplication(10,multiplication(5,4))"));//输出：200
    }
}

