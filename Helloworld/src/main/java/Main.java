import org.apache.flink.cep.pattern.Pattern;

public class Main {

    public static void main(String[] args) throws Exception{

        Pattern p1 = ScriptEngine.getPattern(

                "   import org.apache.flink.cep.nfa.aftermatch.AfterMatchSkipStrategy\n" +
                        "import org.apache.flink.cep.pattern.Pattern\n" +
                        "import AviatorCondition \n" +

                        "where1 = new AviatorCondition(" +
                        "   \"getT(tags,\\\"cluster_name\\\")==\\\"terminus-x\\\"&&getF(fields,\\\"load5\\\")>15 \"" +
                        "        )\n" +

                        "def get(){ " +
                        "      return Pattern.begin(\"start\", AfterMatchSkipStrategy.noSkip())\n" +
                        "        .where(where1)" +
                        "}",
                "get");

        System.out.println(p1.getName());
    }
}
