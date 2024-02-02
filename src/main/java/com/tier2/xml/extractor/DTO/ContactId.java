package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.implementation.Tier2DTOImpl;
import com.tier2.xml.extractor.interfaces.Tier2DTO;
import com.tier2.xml.extractor.interfaces.Tier2DTOSimilarity;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class ContactId implements Tier2DTO<ContactId> {
	private String linkId;
	private String value;

	@XmlAttribute(name = "linkId")
	public String getLinkId() {
		return linkId;
	}
	public void setLinkId(String linkId) {
		this.linkId = linkId!= null ? linkId.trim() : null;
	}

	@XmlValue
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value!= null ? value.trim() : null;
	}

	@Override
	public boolean compareDTO(ContactId Dto) {
		Tier2DTOSimilarity<ContactId> tier2DTO = new Tier2DTOImpl<>();
		return tier2DTO.checkDTOIsSimilar(this, Dto);
	}
}
