package com.tier2.xml.extractor;

import java.io.File;

import com.tier2.xml.extractor.DTO.EpcraTier2Dataset;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Tier2XmlExtractor {
    public static void convertToXML(EpcraTier2Dataset dataset, JAXBContext jaxbContext ) throws JAXBException, ParserConfigurationException, TransformerException {
        // Output XML file path
        File outputFile = new File("/Users/saisunhithreddynagireddy/Desktop/summerwork/xml-extraction/tier2-xml-extractor/src/main/resources/output.xml");

        // Create marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();

        // Marshal Java object to DOM
        org.w3c.dom.Document document = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        marshaller.marshal(dataset, document);

        // Use a transformer for formatting
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "html");

        // Set XML declaration
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");


        // Write the DOM to a file
        transformer.transform(new DOMSource(document), new StreamResult(outputFile));

        System.out.println("XML file created successfully!");
    }

    public static void convertToXML1(EpcraTier2Dataset dataset, JAXBContext jaxbContext) throws JAXBException, ParserConfigurationException, TransformerException {
        // Output XML file path
        File outputFile = new File("/Users/saisunhithreddynagireddy/Desktop/summerwork/xml-extraction/tier2-xml-extractor/src/main/resources/output.xml");

        // Create marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();

        // Marshal Java object to DOM
        org.w3c.dom.Document document = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        marshaller.marshal(dataset, document);

        // Use a transformer for formatting
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Set XML declaration
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        // Write the DOM to a file
        transformer.transform(new DOMSource(document), new StreamResult(outputFile));

        System.out.println("XML file created successfully!");
    }

    public static void main(String args[]) {
        try {
            File inputFile = new File("/Users/saisunhithreddynagireddy/Desktop/summerwork/xml-extraction/tier2-xml-extractor/src/main/resources/tier2.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(EpcraTier2Dataset.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            EpcraTier2Dataset dataset = (EpcraTier2Dataset) jaxbUnmarshaller.unmarshal(inputFile);
            convertToXML1(dataset, jaxbContext);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
