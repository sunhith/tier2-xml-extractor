package com.tier2.xml.extractor.interfaces;

public interface Tier2DTOSimilarity<T> {
    boolean checkDTOIsSimilar(T thisDto,T Dto);
}
