package com.nishant.rest.webservices.restfulwebservices.filtering;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping(path="filtering")
	public MappingJacksonValue retreiveSomeBean() {
		
		SomeBean somebean = new SomeBean("value1", "value2", "value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(somebean);
		mapping.setFilters(filters);
		
		return mapping;

	}
	
	@GetMapping(path="filtering-list")
	public MappingJacksonValue retreiveSomeBeanList() {
		List<SomeBean> list = new ArrayList<SomeBean>();
		list.add(new SomeBean("value1", "value2", "value3"));
		list.add(new SomeBean("value12", "value22", "value32"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;

	}
}
