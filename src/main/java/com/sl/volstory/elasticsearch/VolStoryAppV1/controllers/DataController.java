package com.sl.volstory.elasticsearch.VolStoryAppV1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.volstory.elasticsearch.VolStoryAppV1.models.Event;
import com.sl.volstory.elasticsearch.VolStoryAppV1.repository.EventRepository;

@RestController
@RequestMapping("/volstory")
public class DataController implements IDataController {

	private EventRepository eventRepository;

	@Autowired
	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	@Override
	@RequestMapping("/addEvent")
	public void addEvent(Event event) {
		
	}

	@Override
	@RequestMapping("/delete/Event")
	public void deleteEvent(Event event) {
		
	}

}
