package com.iac.tourism.api.trip;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.iac.tourism.api.CommonResponse;
import com.iac.tourism.entity.trip.ViewSpot;

@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ViewSpotResponse extends CommonResponse {

	@XmlElementWrapper(name="viewSpots")
	@XmlElement(name="viewSpot")
	private List<ViewSpot> viewSpots;

	public List<ViewSpot> getViewSpots() {
		return viewSpots;
	}

	public void setViewSpots(List<ViewSpot> viewSpots) {
		this.viewSpots = viewSpots;
	}
	
}
