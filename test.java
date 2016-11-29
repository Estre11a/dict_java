/**
 * Created by Estrella on 2016/11/28.
 */
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
public class test {
    public static void main(String[] args) {
        System.out.println(test.doTranslate("聚会", "zh", "en"));
        System.out.println(test.doTranslate("party", "en", "zh"));
        System.out.println(test.doTranslate("英语", "zh", "en"));
        System.out.println(test.doTranslate("english", "en", "zh"));
    }

    // 请求函数
    public static String doTranslate(String keyword, String from, String to) {
        String resource = null;
        try {
            // 得到网页的内容
            Document document = Jsoup
                    .connect(/*"http://fanyi.baidu.com/#"+from+"/"+to+"/"+keyword*/"http://fanyi.baidu.com/transapi?from=" + from + "&to=" + to + "&query=" + keyword)
                    .ignoreContentType(true).get();
            // 得到body的内容
            resource = document.getElementsByTag("body").text().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 将源码转成jsonobject
        JSONObject object = JSONObject.fromObject(resource);
        String temp = object.getString("data");
        temp = temp.substring(1, temp.indexOf(",\"result"));
        temp += "}";
        JSONObject data = JSONObject.fromObject(temp);
        // 得到翻译后的内容
        return data.getString("dst");
    }
}
