package com.tier2.xml.extractor.singleton;

import com.tier2.xml.extractor.enums.IgnoreAttributes;

import java.util.*;

public class EpcraTier2DatasetDiff
{
    private static EpcraTier2DatasetDiff instance;
    private List<String> differences = new ArrayList<>();

    private HashMap<String, Set<String>> ignoreProperties = new HashMap<>();

    // Private constructor to prevent instantiation from outside the class
    private EpcraTier2DatasetDiff() {
        // Initialization code, if any
        for(IgnoreAttributes parentAttribute: IgnoreAttributes.values())
        {
            ignoreProperties.put(parentAttribute.toString(), parentAttribute.getIgnoreProperties());
        }
    }

    // Public method to get the instance of the class
    public static EpcraTier2DatasetDiff getInstance() {
        // Lazy initialization: create the instance if it doesn't exist yet
        if (instance == null) {
            instance = new EpcraTier2DatasetDiff();
        }
        return instance;
    }

    public void addDifferences(String difference){
        this.differences.add(difference);
    }

    public List<String> getDifferences(){
        return this.differences;
    }

    public Set<String> getIgnoreProperties(String parentAttribute){
        return ignoreProperties.get(parentAttribute);
    }
}
