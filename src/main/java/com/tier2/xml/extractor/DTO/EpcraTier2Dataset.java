package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.DTO.Dataset;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EpcraTier2Dataset {
	private Dataset Dataset;
	private String Version;
	private String Xmlns;

	@XmlElement(name = "dataset")
	public Dataset getDataset() {
		 return this.Dataset; } 
	public void setDataset(Dataset Dataset) { 
		 this.Dataset = Dataset; }

	@XmlAttribute(name = "xmlns")
	public String getXmlns() { 
		 return this.Xmlns; }

	public void setXmlns(String Xmlns) { 
		 this.Xmlns = Xmlns; }

	@XmlAttribute(name = "version")
	public String getVersion() { 
		 return this.Version; } 
	public void setVersion(String Version) { 
		 this.Version = Version; }
}