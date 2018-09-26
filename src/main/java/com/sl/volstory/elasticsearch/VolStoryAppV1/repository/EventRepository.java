package com.sl.volstory.elasticsearch.VolStoryAppV1.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.sl.volstory.elasticsearch.VolStoryAppV1.models.Event;

//	This interface acts as the repository for the elastic search.
public interface EventRepository extends ElasticsearchRepository<Event, String> {

	List<Event> findByEventName (String eventName);
	List<Event> findByEventHost (String eventHost);
	List<Event> findByEventArea (String eventArea);
	List<Event> findByEventCity (String eventCity);
}
