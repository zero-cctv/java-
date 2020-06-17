import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import java.io.File;

public class HttpGetExample {
    @Test
    public static void main(String args[]) throws Exception {
        HttpGetExample httpGetExample=new HttpGetExample();
        try {
            httpGetExample.test();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void test() throws Exception{

        //Create an object of credentialsProvider//用于用户验证的凭据。
        CredentialsProvider credentialsPovider = new BasicCredentialsProvider();

        //Set the credentials
        AuthScope scope = new AuthScope("https://www.kaops.com/", 80);

        Credentials credentials = new UsernamePasswordCredentials("USERNAME", "PASSWORD");
        credentialsPovider.setCredentials(scope, credentials);
//        AuthScope对象 - 验证范围，指定主机名，端口号和验证方案名称等详细信息。
//        Credentials对象 - 指定凭据(用户名，密码)。//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/apache_httpclient/apache_httpclient_user_authentication.html
//


        //Creating the HttpClientBuilder
        HttpClientBuilder clientbuilder = HttpClients.custom();

        //Setting the credentials
        clientbuilder = clientbuilder.setDefaultCredentialsProvider(credentialsPovider);

        //Building the CloseableHttpClient object
        CloseableHttpClient httpclient = clientbuilder.build();

        //Creating a HttpGet object
        HttpGet httpget = new HttpGet("https://www.kaops.com/index.php");

        //Printing the method used
        System.out.println(httpget.getMethod());

        //Executing the Get request
        HttpResponse httpresponse = httpclient.execute(httpget);

        //Printing the status line
        System.out.println(httpresponse.getStatusLine());
        int statusCode = httpresponse.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        httpclient.close();
        Header[] headers = httpresponse.getAllHeaders();
        for (int i = 0; i < headers.length; i++) {
            System.out.println(headers[i].getName());
        }
    }
    public void test1() throws Exception{

            //Creating an HttpHost object for proxy
            HttpHost proxyhost = new HttpHost("localhost");

            //Creating an HttpHost object for target
            HttpHost targethost = new HttpHost("google.com");

            //creating a RoutePlanner object
            HttpRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxyhost);

            //Setting the route planner to the HttpClientBuilder object
            HttpClientBuilder clientBuilder = HttpClients.custom();
            clientBuilder = clientBuilder.setRoutePlanner(routePlanner);

            //Building a CloseableHttpClient
            CloseableHttpClient httpclient = clientBuilder.build();

            //Creating an HttpGet object
            HttpGet httpget = new HttpGet("/");

            //Executing the Get request
            HttpResponse httpresponse = httpclient.execute(targethost, httpget);

            //Printing the status line
            System.out.println(httpresponse.getStatusLine());

            //Printing all the headers of the response
            Header[] headers = httpresponse.getAllHeaders();

            for (int i = 0; i < headers.length; i++) {
                System.out.println(headers[i]);
            }

            //Printing the body of the response
            HttpEntity entity = httpresponse.getEntity();

            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }


    }
    public void test2() throws Exception{
        //创建自己的SSL上下文
        //Creating SSLContextBuilder object
        SSLContextBuilder SSLBuilder = SSLContexts.custom();

        //Loading the Keystore file
        File file = new File("mykeystore.jks");//这是ssl安全证书电脑里应该是有的，用浏览器貌似可以找到
        SSLBuilder = SSLBuilder.loadTrustMaterial(file,"changeit".toCharArray());


        //Building the SSLContext usiong the build() method
        SSLContext sslcontext = SSLBuilder.build();

        //Creating SSLConnectionSocketFactory object
        SSLConnectionSocketFactory sslConSocFactory = new SSLConnectionSocketFactory(sslcontext, new NoopHostnameVerifier());

        //Creating HttpClientBuilder
        HttpClientBuilder clientbuilder = HttpClients.custom();

        //Setting the SSLConnectionSocketFactory
        clientbuilder = clientbuilder.setSSLSocketFactory(sslConSocFactory);

        //Building the CloseableHttpClient
        CloseableHttpClient httpclient = clientbuilder.build();

        //Creating the HttpGet request
        HttpGet httpget = new HttpGet("https://yiibai.com/");

        //Executing the request
        HttpResponse httpresponse = httpclient.execute(httpget);

        //printing the status line
        System.out.println(httpresponse.getStatusLine());

        //Retrieving the HttpEntity and displaying the no.of bytes read
        HttpEntity entity = httpresponse.getEntity();
        if (entity != null) {
            System.out.println(EntityUtils.toByteArray(entity).length);
        }
    }//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/apache_httpclient/apache_httpclient_custom_ssl_context.html





}