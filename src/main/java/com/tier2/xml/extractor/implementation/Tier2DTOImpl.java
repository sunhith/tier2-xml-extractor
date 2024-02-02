package com.tier2.xml.extractor.implementation;

import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Set;

public class Tier2DTOImpl<T> implements Tier2DTOSimilarity<T> {
    @Override
    public boolean checkDTOIsSimilar(T thisDto, T Dto) {
        boolean isequal = true;
        EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();
        Set<String> ignoreProperties = epcraTier2DatasetDiff.getIgnoreProperties(Dto.getClass().getSimpleName());
        Field[] properties = Dto.getClass().getDeclaredFields();
        for (Field field: properties)
        {
            try {
                boolean ignore = ignoreProperties!=null && ignoreProperties.contains(field.getName());
                if(ignore) continue;
//                if (!thisDto.getClass().equals(String.class))
                field.setAccessible(true);
                Object thisValue = field.get(thisDto);
                Object otherValue = field.get(Dto);

                // Comparison logic based on field type
                if (field.getType().isPrimitive() || field.getType().equals(String.class)) {
                    if (!Objects.equals(thisValue, otherValue)) {
                        epcraTier2DatasetDiff.addDifferences("<"+thisDto.getClass().getSimpleName()+">: "+field.getName()+" is not same");
                        isequal = false;
                    }
                } else if (thisValue != null && otherValue != null && thisValue instanceof Tier2DTO) {
                    // For non-primitive types that implement Comparable
                    boolean comparisonResult = ((Tier2DTO) thisValue).compareDTO(otherValue);
                    if (!comparisonResult ) {
                        epcraTier2DatasetDiff.addDifferences("<"+thisDto.getClass().getSimpleName()+">: "+field.getName()+" is not same");
                        isequal = false;
                    }
                }
                //System.out.println(field.getName() +" "+field.get(this)+" : "+field.getType().getSimpleName());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return isequal;
    }
}
