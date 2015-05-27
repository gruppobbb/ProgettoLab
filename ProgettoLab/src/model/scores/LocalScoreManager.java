package model.scores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * Memorizza i punteggi in un file in locale.
 * @author Giulia
 */
public class LocalScoreManager implements IScoreManager{
	
	private File scoreFile;
	private String playerName;
	
	public LocalScoreManager() {
		scoreFile = new File("web/scorelist.xml");
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	@Override
	public void saveScores(ArrayList<Long> highScores, String playerName) throws IOException{
		
		try {
			this.playerName = playerName;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = dbFactory.newDocumentBuilder();
			Document xmlDoc = builder.parse(scoreFile);
			NodeList scores = xmlDoc.getElementsByTagName("scores");
			scores.item(0).getAttributes().item(0).setNodeValue(playerName);

			NodeList scoreNodesList = xmlDoc.getElementsByTagName("entry");
			for (int i = 0; i < ScoreKeeper.MAX_SCORES; i++) {
				Node scoreNode = scoreNodesList.item(i);				
				NodeList scoreInfo = scoreNode.getChildNodes();
				Node info = scoreInfo.item(1);
				if(info.getNodeName() == "score"){
					info.setTextContent(highScores.get(i).toString());
				}
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xmlDoc);
			StreamResult result = new StreamResult(scoreFile);
			transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void loadScores(ArrayList<Long> highScores) throws FileNotFoundException, IOException{
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			Document xmlDoc = builder.parse(scoreFile);
			NodeList scores = xmlDoc.getElementsByTagName("scores");
			playerName = scores.item(0).getAttributes().item(0).getNodeValue();
			
			NodeList scoreNodesList = xmlDoc.getElementsByTagName("entry");
			for (int i = 0; i < ScoreKeeper.MAX_SCORES; i++) {
				Node scoreNode = scoreNodesList.item(i);				
				NodeList scoreInfo = scoreNode.getChildNodes();
				for (int j = 0; j < scoreInfo.getLength(); j++) {
					Node info = scoreInfo.item(j);
					if(info.getNodeName() == "score"){
						highScores.add(Long.parseLong(info.getTextContent()));
					}
				}
			}
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
