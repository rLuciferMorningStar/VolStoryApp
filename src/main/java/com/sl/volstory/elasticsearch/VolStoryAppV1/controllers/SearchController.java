package com.sl.volstory.elasticsearch.VolStoryAppV1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.volstory.elasticsearch.VolStoryAppV1.models.Event;
import com.sl.volstory.elasticsearch.VolStoryAppV1.querybuilders.SearchQuery;
import com.sl.volstory.elasticsearch.VolStoryAppV1.repository.EventRepository;

@RestController
@RequestMapping("/volstory/search")
public class SearchController implements ISearchController {

	private EventRepository eventRepository;
	private SearchQuery searchQuery;

	@Autowired
	public void setSearchQuery(SearchQuery searchQuery) {
		this.searchQuery = searchQuery;
	}

	@Autowired
	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	@Override
	@GetMapping(value = "/{text}")
	public List<Event> manualSearch(@PathVariable final String text) {
		return searchQuery.searchAll(text);
	}
	
	@Override
	@GetMapping(value = "/all")
	public List<Event> searchAll() {
		List<Event> eventList = new ArrayList<>();
        Iterable<Event> events = eventRepository.findAll();
        events.forEach(eventList::add);
        return eventList;
	}
	
	@Override
	@GetMapping(value = "/eventName/{eventName}")
	public List<Event> findByEventName(@PathVariable final String eventName) {
		return eventRepository.findByEventName(eventName);
	}

	@Override
	@GetMapping(value = "/eventHost/{eventHost}")
	public List<Event> findByEventHost(@PathVariable final String eventHost) {
		return eventRepository.findByEventHost(eventHost);
	}

	@Override
	@GetMapping(value = "/eventArea/{eventArea}")
	public List<Event> findByEventArea(@PathVariable final String eventArea) {
		return eventRepository.findByEventArea(eventArea);
	}

	@Override
	@GetMapping(value = "/eventCity/{eventCity}")
	public List<Event> findByEventCity(@PathVariable final String eventCity) {
		return eventRepository.findByEventCity(eventCity);
	}

}
