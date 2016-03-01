package com.iac.tourism.api.trip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iac.tourism.api.IdForm;
import com.iac.tourism.api.search.SearchForm;
import com.iac.tourism.entity.trip.ViewSpot;
import com.iac.tourism.service.trip.ViewSpotService;
import com.rop.annotation.IgnoreSignType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;

/**
 * 景点api  客户端获取经纬度 调用百度api 查询省地市信息
 * @author iacdp
 *
 */
@ServiceMethodBean(version="0.0.1", ignoreSign=IgnoreSignType.YES)
public class ViewSpotApi {

	@Autowired
	private ViewSpotService viewSpotService;
	
	@ServiceMethod(method="viewspot.search")
	public Object search(SearchForm request) {
		List<ViewSpot> viewSpots = viewSpotService.search(request.getKey());
		
		ViewSpotResponse response = new ViewSpotResponse();
		for(ViewSpot vs : viewSpots) {
			System.out.println(vs.getArea() != null ? vs.getArea().getFullName() : null);
		}
		response.setViewSpots(viewSpots);
		return response;
	}
	
	@ServiceMethod(method="viewspot.findByArea")
	public Object findByArea(IdForm request) {
		List<ViewSpot> viewSpots = viewSpotService.findByArea(request.getId());
		
		ViewSpotResponse response = new ViewSpotResponse();
		response.setViewSpots(viewSpots);
		return response;
	}
	
	@ServiceMethod(method="viewspot.findByParent")
	public Object findByParent(IdForm request) {
		List<ViewSpot> viewSpots = viewSpotService.findByParent(request.getId());
		
		ViewSpotResponse response = new ViewSpotResponse();
		response.setViewSpots(viewSpots);
		return response;
	}
}
