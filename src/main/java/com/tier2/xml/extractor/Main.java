package com.tier2.xml.extractor;

import com.tier2.xml.extractor.enums.IgnoreAttributes;

public class Main {
    public static void main(String[] args) {
        // Iterate over all roles
        for (IgnoreAttributes role : IgnoreAttributes.values()) {
            System.out.println("Role: " + role.toString().toLowerCase());
            System.out.println("Associated IDs: " + role.getAssociatedIdsAsString());
            System.out.println();
        }
    }
}
