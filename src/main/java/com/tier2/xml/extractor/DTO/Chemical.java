package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.adapter.DateAdapter;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.math.BigDecimal;
import java.util.Date;
@XmlType(propOrder = {"chemName","casNumber","ehs","pure","mixture",
		"solid","liquid","gas","hazards","aveAmount","aveAmountCode",
		"maxAmount","maxAmountCode","sameAsLastYear","daysOnSite",
		"maxAmtLargestContainer","belowReportingThresholds","confidentialStorageLocs",
		"tradeSecret","lastModified","storageLocations"})
public class Chemical {
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
	private String Recordid;

	@XmlElement(name = "chemName")
	public String getChemName() { 
		 return this.ChemName; } 
	public void setChemName(String ChemName) { 
		 this.ChemName = ChemName; }

	@XmlElement(name = "casNumber")
	public String getCasNumber() { 
		 return this.CasNumber; } 
	public void setCasNumber(String CasNumber) { 
		 this.CasNumber = CasNumber; }

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
		 return this.Recordid; } 
	public void setRecordid(String Recordid) { 
		 this.Recordid = Recordid; }
}