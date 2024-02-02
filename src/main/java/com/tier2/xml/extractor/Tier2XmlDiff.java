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
            File inputFile1 = new File("/Users/saisunhithreddynagireddy/Desktop/summerwork/xml-extraction/tier2-xml-extractor/src/main/resources/testdata/tier2data_statefield.xml");
            File inputFile2 = new File("/Users/saisunhithreddynagireddy/Desktop/summerwork/xml-extraction/tier2-xml-extractor/src/main/resources/testdata/eplandata_statefield.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(EpcraTier2Dataset.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            EpcraTier2Dataset dataset = (EpcraTier2Dataset) jaxbUnmarshaller.unmarshal(inputFile1); // tier2data
            EpcraTier2Dataset dataset1 = (EpcraTier2Dataset) jaxbUnmarshaller.unmarshal(inputFile2); // eplandata
            boolean isequal = dataset.compareDTO(dataset1);
            if(!isequal){
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
