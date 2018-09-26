package com.sl.volstory.elasticsearch.VolStoryAppV1.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "events", type = "books", shards = 1)
public class Event {

	@Id
	private String id;
	private String eventName;
	private String eventHost;
	private String eventArea;
	private String eventCity;
	
	//	Empty constructor for instance without initial values
	public Event() {
		
	}

	//	Constructor with initial values
	public Event(String id, String eventName, String eventHost, String eventArea, String eventCity) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventHost = eventHost;
		this.eventArea = eventArea;
		this.eventCity = eventCity;
	}

	//	Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventHost() {
		return eventHost;
	}

	public void setEventHost(String eventHost) {
		this.eventHost = eventHost;
	}

	public String getEventArea() {
		return eventArea;
	}

	public void setEventArea(String eventArea) {
		this.eventArea = eventArea;
	}

	public String getEventCity() {
		return eventCity;
	}

	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}
	
	//	Overriding toString method for formatted output
	@Override
	public String toString() {
		return "Event{" +
                "id='" + id + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventHost='" + eventHost + '\'' +
                ", eventArea='" + eventArea + '\'' +
                ", eventCity='" + eventCity + '\'' +
                '}';
	}
}
