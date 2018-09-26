package com.sl.volstory.elasticsearch.VolStoryAppV1.controllers;

import com.sl.volstory.elasticsearch.VolStoryAppV1.models.Event;

public interface IDataController {

	//	Adding new Event
	public void addEvent(Event event);
	
	//	Delete Event
	public void deleteEvent(Event event);
}
