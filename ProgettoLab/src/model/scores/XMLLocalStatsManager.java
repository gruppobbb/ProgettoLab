package model.scores;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * Classe per la gestione delle statistiche locali su file XML.
 * @author Giulia
 *
 */
public class XMLLocalStatsManager implements ILocalStatsManager{
	
	private File localFile;
	/**
	 * @param localFile File in cui verranno memorizzate le informazioni
	 */
	XMLLocalStatsManager(File localFile){
		this.localFile = localFile;
	}

	@Override
	public void setPersonalBest(long score) {
		try {
			Document xmlDoc = openDoc();
			NodeList nodes = xmlDoc.getElementsByTagName("personalBest");
			nodes.item(0).setTextContent(String.valueOf(score));
			saveDoc(xmlDoc);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public long getPersonalBest() {
		long personalBest = 0;
		try {
			Document xmlDoc = openDoc();
			NodeList nodes = xmlDoc.getElementsByTagName("personalBest");
			personalBest = Long.parseLong(nodes.item(0).getTextContent());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return personalBest;
	}

	@Override
	public void setPlayerName(String playerName) {
		try {
			Document xmlDoc = openDoc();
			NodeList nodes = xmlDoc.getElementsByTagName("playerName");
			nodes.item(0).setTextContent(playerName);
			saveDoc(xmlDoc);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getPlayerName() {
		String playerName = "";
		try {
			Document xmlDoc = openDoc();
			NodeList nodes = xmlDoc.getElementsByTagName("playerName");
			playerName = nodes.item(0).getTextContent();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return playerName;
	}
	
	/**
	 * Apre il documento specificato nel costruttore.
	 */
	private Document openDoc() throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbFactory.newDocumentBuilder();
		Document xmlDoc = builder.parse(localFile);
		return xmlDoc;
	}
	
	/**
	 * Salva il documento aperto con openDoc().
	 */
	private void saveDoc(Document xmlDoc) throws TransformerException{
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(xmlDoc);
		StreamResult result = new StreamResult(localFile);
		transformer.transform(source, result);
	}
	
}
