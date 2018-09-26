package com.sl.volstory.elasticsearch.VolStoryAppV1.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.sl.volstory.elasticsearch.VolStoryAppV1.models.Event;

public interface ISearchController {

	//	Display all the events
	public List<Event> searchAll();

	//	Manual Searching
	public List<Event> manualSearch(@PathVariable final String text);
	
	//	Find event by Event Name
	List<Event> findByEventName (String eventName);
	
	//	Find event by host of event
	List<Event> findByEventHost (String eventHost);
	
	//	Find event by Area in which Event is going to happen
	List<Event> findByEventArea (String eventArea);
	
	//	Find event by City in which Event is going to happen
	List<Event> findByEventCity (String eventCity);	
}
