package com.tier2.xml.extractor.DTO;

import com.tier2.xml.extractor.singleton.EpcraTier2DatasetDiff;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class Facilities implements Comparable<Facilities> {
	private List<Facility> Facility;

	@XmlElement(name = "facility")
	public List<Facility> getFacility() {
		return this.Facility;
	}

	public void setFacility(List<Facility> Facility) {
		this.Facility = Facility;
	}

	@Override
	public int compareTo(Facilities o) {
		int isequal = 1; // 1 implies not equal, 0 => equal
		EpcraTier2DatasetDiff epcraTier2DatasetDiff = EpcraTier2DatasetDiff.getInstance();
		for (Facility facility : this.Facility)
			for (Facility fac : o.Facility) {
				if (facility.getFacilityName() != null
						&& fac.getFacilityName() != null
						&& facility.getFacilityName().equals(fac.getFacilityName()))
				{
					isequal = facility.compareTo(fac);
					break;
				}
			}
		return isequal;
	}
}