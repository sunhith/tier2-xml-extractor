package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"facilities", "contacts", "reportyear"})
public class Dataset implements Comparable<Dataset>{
	private Facilities Facilities;
	private Contacts Contacts;
	private int Reportyear;

	@XmlElement(name = "facilities")
	public Facilities getFacilities() {
		 return this.Facilities; }
	public void setFacilities(Facilities Facilities) {
		 this.Facilities = Facilities; }

	@XmlElement(name = "contacts")
	public Contacts getContacts() {
		 return this.Contacts; }
	public void setContacts(Contacts Contacts) {
		 this.Contacts = Contacts; }

	@XmlAttribute(name = "reportyear")
	public int getReportyear() {
		 return this.Reportyear; }
	public void setReportyear(int Reportyear) {
		 this.Reportyear = Reportyear; }

	@Override
	public int compareTo(Dataset o) {
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();
		int isEqual = 1;
		if(this.Reportyear != o.Reportyear)
			epcraTier2DatasetDiff.addDifferences("<Dataset>: Report year is not same");

		return this.Facilities.compareTo(o.Facilities);
	}
}