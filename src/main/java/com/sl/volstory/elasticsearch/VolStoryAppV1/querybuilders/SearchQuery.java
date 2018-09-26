/*	This class serves the purpose of generating manual search
	queries using query_DSL
*/
package com.sl.volstory.elasticsearch.VolStoryAppV1.querybuilders;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import com.sl.volstory.elasticsearch.VolStoryAppV1.models.Event;

@Component
public class SearchQuery {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	public List<Event> searchAll(String text) {
		QueryBuilder searchQuery = QueryBuilders.boolQuery()
												.should(QueryBuilders.queryStringQuery(text)
														.lenient(true)
														.field("eventName")
														.field("eventArea")
														.field("eventCity"))
												.should(QueryBuilders.queryStringQuery("*"+text+"*")
														.lenient(true)
														.field("eventName")
														.field("eventArea")
														.field("eventCity"));
		
		NativeSearchQuery queryBuilder = new NativeSearchQueryBuilder()
										.withQuery(searchQuery)
										.build();
		
		List<Event> events = elasticsearchTemplate.queryForList(queryBuilder, Event.class);
		
		return events;
	}
}
