package general;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.swt.widgets.List;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// TODO: Auto-generated Javadoc
/**
* 
*  * <h1>Properties</h1>
* The client Properties Class
* <p>
* 
*
* @author  Guy Liberman & Omri Polnikviat
* @version 1.0
* @since   2015-10-31
*/
@SuppressWarnings("serial")
public class Properties implements Serializable 
{
	
	/** The threadcount. */
	int threadcount;
	
	/** The workspace. */
	String workspace;
	
	/** The serverip. */
	String serverip;
	
	/** The display. */
	int display;
	
	/** The port. */
	int port;
	
	/**
	 * Instantiates a new properties.
	 */
	public Properties() {
		threadcount =20;
		display=2;
		workspace="default";
		try {
			serverip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		port = 54321;
	}
	
	/**
	 * Load prop.
	 *
	 * @param file the file
	 * @throws Exception the exception
	 */
	public void loadProp(String file) throws Exception
	{
		File inputfile = new File(file);
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
		Document doc = dbuilder.parse(inputfile);
		doc.getDocumentElement().normalize();
		NodeList nlist = doc.getElementsByTagName("properties");
		Node n = nlist.item(0);
		Element e = (Element)n;
		threadcount = Integer.parseInt(e.getElementsByTagName("threadcount").item(0).getTextContent());
		workspace =  e.getElementsByTagName("workspace").item(0).getTextContent();
		display = Integer.parseInt(e.getElementsByTagName("display").item(0).getTextContent());
		serverip =  e.getElementsByTagName("serverip").item(0).getTextContent();
		port = Integer.parseInt(e.getElementsByTagName("port").item(0).getTextContent());
	}
	
	/**
	 * Save prop.
	 *
	 * @param file the file
	 * @throws Exception the exception
	 */
	public void saveProp(String file) throws Exception
	{
		File outputfile = new File(file);
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
		Document doc = dbuilder.newDocument();
		Element e = doc.createElement("properties");
		doc.appendChild(e);
		
		Element e2 = doc.createElement("threadcount");
		e2.setTextContent(threadcount+"");
		e.appendChild(e2);
		
		
		Element e3 = doc.createElement("workspace");
		e3.setTextContent(workspace);
		e.appendChild(e3);
		
		Element e4 = doc.createElement("display");
		e4.setTextContent(display+"");
		e.appendChild(e4);
		
		Element e5 = doc.createElement("serverip");
		e5.setTextContent(serverip);
		e.appendChild(e5);
		
		Element e6 = doc.createElement("port");
		e6.setTextContent(port+"");
		e.appendChild(e6);
		
		TransformerFactory ts = TransformerFactory.newInstance();
		Transformer transformer = ts.newTransformer();
		DOMSource dm = new DOMSource(doc);
		transformer.transform(dm, new StreamResult(outputfile));
		}

	/**
	 * Gets the threadcount.
	 *
	 * @return the threadcount
	 */
	public int getThreadcount() {
		return threadcount;
	}

	/**
	 * Gets the workspace.
	 *
	 * @return the workspace
	 */
	public String getWorkspace() {
		return workspace;
	}

	/**
	 * Gets the display.
	 *
	 * @return the display
	 */
	public int getDisplay() {
		return display;
	}

	/**
	 * Gets the serverip.
	 *
	 * @return the serverip
	 */
	public String getServerip() {
		return serverip;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public int getPort() {
		return port;
	}
	
	
}
