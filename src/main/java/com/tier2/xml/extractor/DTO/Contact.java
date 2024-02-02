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
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@XmlType(propOrder = {"firstName","lastName","title","email","mailingAddress",
		"contactTypes","phones","lastModified"})
public class Contact implements Tier2DTO<Contact> {
	private String FirstName;
	private String LastName;
	private String Title;
	private String Email;
	private MailingAddress MailingAddress;
	private ContactTypes ContactTypes;
	private Phones Phones;
	private Date LastModified;
	private String recordid;

	@XmlElement(name = "firstName")
	public String getFirstName() { 
		 return this.FirstName; } 
	public void setFirstName(String FirstName) { 
		 this.FirstName = FirstName!= null ? FirstName.trim() : null; }

	@XmlElement(name = "lastName")
	public String getLastName() { 
		 return this.LastName; } 
	public void setLastName(String LastName) { 
		 this.LastName = LastName!= null ? LastName.trim() : null; }

	@XmlElement(name = "title")
	public String getTitle() { 
		 return this.Title; } 
	public void setTitle(String Title) { 
		 this.Title = Title!= null ? Title.trim() : null; }

	@XmlElement(name = "email")
	public String getEmail() { 
		 return this.Email; } 
	public void setEmail(String Email) { 
		 this.Email = Email!= null ? Email.trim() : null; }

	@XmlElement(name = "mailingAddress")
	public MailingAddress getMailingAddress() {
		 return this.MailingAddress; }
	public void setMailingAddress(MailingAddress MailingAddress) {
		 this.MailingAddress = MailingAddress; }

	@XmlElement(name = "contactTypes")
	public ContactTypes getContactTypes() {
		 return this.ContactTypes; }
	public void setContactTypes(ContactTypes ContactTypes) {
		 this.ContactTypes = ContactTypes; }

	@XmlElement(name = "phones")
	public Phones getPhones() {
		 return this.Phones; }
	public void setPhones(Phones Phones) {
		 this.Phones = Phones; }

	@XmlElement(name = "lastModified")
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getLastModified() { 
		 return this.LastModified; } 
	public void setLastModified(Date LastModified) { 
		 this.LastModified = LastModified; }

	@XmlAttribute(name = "recordid")
	public String getRecordid() { 
		 return this.recordid; }
	public void setRecordid(String recordid) {
		 this.recordid = recordid!= null ? recordid.trim() : null; }

//	@Override
	public boolean checkDTOIsSimilar(Contact Dto) {
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
	public boolean compareDTO(Contact Dto) {
		Tier2DTOSimilarity<Contact> tier2DTO = new Tier2DTOImpl<>();
		return tier2DTO.checkDTOIsSimilar(this, Dto);
	}
}