package chatEngine;

import Domain.SmallIResponse;
import org.codehaus.jackson.JsonNode;
import play.libs.F;
import play.libs.WS;
import utils.SmallIJsonResponseParser;

public class SmallIChatEngine implements ChatEngineInterface {
    @Override
    public String chatWithEngine(String input, String context) {
        F.Promise<WS.Response> chatResponse = WS.url(" http://mod.f3.cn/csa/InterfaceXiaoI.aspx").setQueryParameter("sessionid", context).setQueryParameter("message", input).get();
        WS.Response response = chatResponse.get();
        JsonNode jsonNodes = response.asJson();
        SmallIResponse smallIResponse = new SmallIJsonResponseParser().parse(jsonNodes);
        return null;
    }
}
