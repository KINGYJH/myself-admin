package area.test;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * Created by yjh on 2015/7/28.
 */
public class AreaTest {

    @Test
    public void show() throws ParserConfigurationException, IOException, SAXException {
        File file = new File("C:\\Users\\yjh\\Desktop\\中国省市区县.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        NodeList nodes = document.getChildNodes();

        showItem(nodes);
    }

    public static void showItem(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {

                Element e = (Element) node;

                if (node.hasChildNodes()) {
                    if (e.getTagName().equals("sheng")) {
                        System.out.println("\t省：" + e.getAttribute("name") + "+" + e.getAttribute("code"));
                    } else if (e.getTagName().equals("city")) {
                        System.out.println("\t\t市：" + e.getAttribute("name") + "+" + e.getAttribute("code"));
                    }
                    showItem(node.getChildNodes()); // 递归
                } else {
                    System.out.println("\t\t\t区县：" + e.getAttribute("name") + "+" + e.getAttribute("code"));
                }
            }
        }
    }
}
