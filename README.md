**How to run XML difference?**
1. Go to the class Tier2XmlDiff and provide the tier2 and eplan xml data paths.
2. Run mvn

**How can we exclude certain properties from being compared for differences when working with XML data?**
1. Go to the enum class ignoreAttributes and provide the list of attributes that should be excluded from comparing.

**Limitations:**
1. If a new property is introduced in the XML data, but that property is not included in the EpcraTier2Dataset DTO
 (Data Transfer Object), it becomes impractical to perform a straightforward comparison for that particular addition

2. If a property is of list type, comparisons are conducted using the unique IDs within that property's list

**Features:**
1. Compare the XML data of Tier2 and Eplan and identify the disparities in their property information.
2. We Can disregard the properties that are not relevant for checking differences.
3. Validate the XML data with schema(xsd)
4. Feasibility to modify the comparison logic based on the DTO classes. Each DTO class includes a method called 
   compareDTO, allowing us to adjust the comparison logic specific to that DTO
