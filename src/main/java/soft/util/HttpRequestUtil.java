package soft.util;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author kun_mi
 */

@Component
public class HttpRequestUtil {

    public String getOpenId(String appId, String secret, String code) {
        BufferedReader in = null;

        String url="https://api.weixin.qq.com/sns/jscode2session?appid="
                +appId+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";

        try {
            URL weChatUrl = null;
            try {
                weChatUrl = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            // 打开和URL之间的连接
            URLConnection connection = null;
            try {
                connection = weChatUrl.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 设置通用的请求属性
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // 建立实际的连接
            try {
                connection.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 定义 BufferedReader输入流来读取URL的响应
            try {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            StringBuffer sb = new StringBuffer();
            String line = null;

            while (true) {
                try {
                    if (!((line = in.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sb.append(line);
            }

            return sb.toString();
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }

        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


}
