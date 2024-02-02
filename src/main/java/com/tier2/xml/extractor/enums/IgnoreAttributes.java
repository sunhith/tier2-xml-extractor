package com.tier2.xml.extractor.enums;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum IgnoreAttributes {
    EpcraTier2Dataset(new HashSet<>(Set.of("xmlns", "version"))),
    Facility(new HashSet<>(Set.of("dateSigned","lastModified","facilityIds","recordid"))),
    Chemical(new HashSet<>(Set.of("lastModified","recordid"))),
    ContactId(new HashSet<>(Set.of("value"))),
    Contact(new HashSet<>(Set.of("lastModified","recordid"))),
    FacilityId(new HashSet<>(Set.of("lastModified","facilityId","recordid"))),
    Phone(new HashSet<>(Set.of("recordid"))),
    StorageLocation(new HashSet<>(Set.of("recordid")));

    private final Set<String> ignoreProperties;

    IgnoreAttributes(Set<String> ignoreProperties) {
        this.ignoreProperties = ignoreProperties;
    }

    public Set<String> getIgnoreProperties() {
        return ignoreProperties;
    }

    // Example method to get a comma-separated string of associated IDs
    public String getAssociatedIdsAsString() {
        return ignoreProperties.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
