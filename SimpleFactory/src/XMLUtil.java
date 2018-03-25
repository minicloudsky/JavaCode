import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;
public class XMLUtil
{
    //该方法用于从XML配置文件中提取饮料名称，并返回该饮料名称
    public static Object getDrinkName()
    {
        try{
            DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("D:\\Software\\idea\\Javacode\\SimpleFactory\\src\\configName.xml"));
            NodeList n1 = doc.getElementsByTagName("className");
            Node classNode = n1.item(0).getFirstChild();
            String cName = classNode.getNodeValue();
            Class c = Class.forName(cName);
            Object object = c.newInstance();
            return object;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
