package com.tier2.xml.extractor;

import com.tier2.xml.extractor.DTO.EpcraTier2Dataset;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Tier2XmlDiff {
    public static void main(String args[]){
        try {
            File inputFile1 = new File("/Users/saisunhithreddynagireddy/Desktop/summerwork/xml-extraction/tier2-xml-extractor/src/main/resources/tier2.xml");
            File inputFile2 = new File("/Users/saisunhithreddynagireddy/Desktop/summerwork/xml-extraction/tier2-xml-extractor/src/main/resources/tier21.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(EpcraTier2Dataset.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            EpcraTier2Dataset dataset = (EpcraTier2Dataset) jaxbUnmarshaller.unmarshal(inputFile1);
            EpcraTier2Dataset dataset1 = (EpcraTier2Dataset) jaxbUnmarshaller.unmarshal(inputFile2);
            int isequal = dataset.compareTo(dataset1);
            if(isequal != 0){
                EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();
                System.out.println(epcraTier2DatasetDiff.getDifferences());
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
