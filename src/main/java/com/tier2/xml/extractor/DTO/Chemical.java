package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.adapter.DateAdapter;
import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@XmlType(propOrder = {"chemName","casNumber","ehs","pure","mixture",
		"solid","liquid","gas","hazards","aveAmount","aveAmountCode",
		"maxAmount","maxAmountCode","sameAsLastYear","daysOnSite",
		"maxAmtLargestContainer","belowReportingThresholds","confidentialStorageLocs",
		"tradeSecret","lastModified","storageLocations"})
public class Chemical implements Tier2DTO<Chemical> {
	private String ChemName;
	private String CasNumber;
	private boolean Ehs;
	private boolean Pure;
	private boolean Mixture;
	private boolean Solid;
	private boolean Liquid;
	private boolean Gas;
	private Hazards Hazards;
	private int AveAmount;
	private int AveAmountCode;
	private BigDecimal MaxAmount;
	private int MaxAmountCode;
	private boolean SameAsLastYear;
	private int DaysOnSite;
	private int MaxAmtLargestContainer;
	private boolean BelowReportingThresholds;
	private boolean ConfidentialStorageLocs;
	private boolean TradeSecret;
	private Date LastModified;
	private StorageLocations StorageLocations;
	private String recordid;

	@XmlElement(name = "chemName")
	public String getChemName() { 
		 return this.ChemName; } 
	public void setChemName(String ChemName) { 
		 this.ChemName = ChemName!= null ? ChemName.trim() : null; }

	@XmlElement(name = "casNumber")
	public String getCasNumber() { 
		 return this.CasNumber; }
	public void setCasNumber(String CasNumber) { 
		 this.CasNumber = CasNumber!= null ? CasNumber.trim() : null; }

	@XmlElement(name = "ehs")
	public boolean getEhs() { 
		 return this.Ehs; } 
	public void setEhs(boolean Ehs) { 
		 this.Ehs = Ehs; }

	@XmlElement(name = "pure")
	public boolean getPure() { 
		 return this.Pure; } 
	public void setPure(boolean Pure) { 
		 this.Pure = Pure; }

	@XmlElement(name = "mixture")
	public boolean getMixture() { 
		 return this.Mixture; } 
	public void setMixture(boolean Mixture) { 
		 this.Mixture = Mixture; }

	@XmlElement(name = "solid")
	public boolean getSolid() { 
		 return this.Solid; } 
	public void setSolid(boolean Solid) { 
		 this.Solid = Solid; }

	@XmlElement(name = "liquid")
	public boolean getLiquid() { 
		 return this.Liquid; } 
	public void setLiquid(boolean Liquid) { 
		 this.Liquid = Liquid; }

	@XmlElement(name = "gas")
	public boolean getGas() { 
		 return this.Gas; } 
	public void setGas(boolean Gas) { 
		 this.Gas = Gas; }

	@XmlElement(name = "hazards")
	public Hazards getHazards() {
		 return this.Hazards; }
	public void setHazards(Hazards Hazards) {
		 this.Hazards = Hazards; }

	@XmlElement(name = "aveAmount")
	public int getAveAmount() { 
		 return this.AveAmount; } 
	public void setAveAmount(int AveAmount) { 
		 this.AveAmount = AveAmount; }

	@XmlElement(name = "aveAmountCode")
	public int getAveAmountCode() { 
		 return this.AveAmountCode; } 
	public void setAveAmountCode(int AveAmountCode) { 
		 this.AveAmountCode = AveAmountCode; }

	@XmlElement(name = "maxAmount")
	public BigDecimal getMaxAmount() {
		 return this.MaxAmount; } 
	public void setMaxAmount(BigDecimal MaxAmount) {
		 this.MaxAmount = MaxAmount; }

	@XmlElement(name = "maxAmountCode")
	public int getMaxAmountCode() { 
		 return this.MaxAmountCode; } 
	public void setMaxAmountCode(int MaxAmountCode) { 
		 this.MaxAmountCode = MaxAmountCode; }

	@XmlElement(name = "sameAsLastYear")
	public boolean getSameAsLastYear() { 
		 return this.SameAsLastYear; } 
	public void setSameAsLastYear(boolean SameAsLastYear) { 
		 this.SameAsLastYear = SameAsLastYear; }

	@XmlElement(name = "daysOnSite")
	public int getDaysOnSite() { 
		 return this.DaysOnSite; } 
	public void setDaysOnSite(int DaysOnSite) { 
		 this.DaysOnSite = DaysOnSite; }

	@XmlElement(name = "maxAmtLargestContainer")
	public int getMaxAmtLargestContainer() { 
		 return this.MaxAmtLargestContainer; } 
	public void setMaxAmtLargestContainer(int MaxAmtLargestContainer) { 
		 this.MaxAmtLargestContainer = MaxAmtLargestContainer; }

	@XmlElement(name = "belowReportingThresholds")
	public boolean getBelowReportingThresholds() { 
		 return this.BelowReportingThresholds; } 
	public void setBelowReportingThresholds(boolean BelowReportingThresholds) { 
		 this.BelowReportingThresholds = BelowReportingThresholds; }

	@XmlElement(name = "confidentialStorageLocs")
	public boolean getConfidentialStorageLocs() { 
		 return this.ConfidentialStorageLocs; } 
	public void setConfidentialStorageLocs(boolean ConfidentialStorageLocs) { 
		 this.ConfidentialStorageLocs = ConfidentialStorageLocs; }

	@XmlElement(name = "tradeSecret")
	public boolean getTradeSecret() { 
		 return this.TradeSecret; } 
	public void setTradeSecret(boolean TradeSecret) { 
		 this.TradeSecret = TradeSecret; }

	@XmlElement(name = "lastModified")
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getLastModified() {
		 return this.LastModified; } 
	public void setLastModified(Date LastModified) { 
		 this.LastModified = LastModified; }

	@XmlElement(name = "storageLocations")
	public StorageLocations getStorageLocations() { 
		 return this.StorageLocations; } 
	public void setStorageLocations(StorageLocations StorageLocations) { 
		 this.StorageLocations = StorageLocations; }

	@XmlAttribute(name = "recordid")
	public String getRecordid() { 
		 return this.recordid; }
	public void setRecordid(String Recordid) { 
		 this.recordid = Recordid!= null ? Recordid.trim() : null; }

//	@Override
	public boolean checkDTOIsSimilar(Chemical Dto) {
		boolean isequal = true;
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();
		Set<String> ignoreProperties = epcraTier2DatasetDiff.getIgnoreProperties(this.getClass().getSimpleName());
		Field[] properties = this.getClass().getDeclaredFields();
		for (Field field: properties)
		{
			try {
				boolean ignore = ignoreProperties.contains(field.getName());
				if(ignore) continue;

				Object thisValue = field.get(this);
				Object otherValue = field.get(Dto);

				// Comparison logic based on field type
				if (field.getType().isPrimitive() || field.getType().equals(String.class)) {
					if (!Objects.equals(thisValue, otherValue)) {
						epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+">: "+field.getName()+" is not same");
						isequal = false;
					}
				} else if (thisValue != null && otherValue != null && thisValue instanceof Tier2DTOSimilarity) {
					// For non-primitive types that implement Comparable
					int comparisonResult = ((Comparable) thisValue).compareTo(otherValue);
					if (comparisonResult != 0) {
						epcraTier2DatasetDiff.addDifferences("<"+this.getClass().getSimpleName()+">: "+field.getName()+" is not same");
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

	@Override
	public boolean compareDTO(Chemical Dto) {
		Tier2DTOSimilarity<Chemical> tier2DTO = new Tier2DTOImpl<>();
		return tier2DTO.checkDTOIsSimilar(this, Dto);
	}
}