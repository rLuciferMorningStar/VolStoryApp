package com.sl.volstory.elasticsearch.VolStoryAppV1.loaders;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sl.volstory.elasticsearch.VolStoryAppV1.models.Event;
import com.sl.volstory.elasticsearch.VolStoryAppV1.repository.EventRepository;

@Component
public class Loader {

	@Autowired
	ElasticsearchOperations operation;
	
	@Autowired
	EventRepository eventRepository;
	
	@PostConstruct
	@Transactional
	public void loadData() {
		operation.putMapping(Event.class);
		System.out.println("Loading Sample data Started");
		eventRepository.save(getData());
		System.out.println("Loading Sample data Completed");
	}
	
    private List<Event> getData() {
        List<Event> events = new ArrayList<>();
        events.add(new Event("1", "Sample Event 1", "Host1", "Pashan", "Pune"));
        events.add(new Event("2", "Sample Event 2", "Host1", "Dadar", "Mumbai"));
        events.add(new Event("3","Sample Event 3", "Host2", "Baner", "Pune"));
        return events;
    }
}
