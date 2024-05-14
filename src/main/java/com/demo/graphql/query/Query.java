package com.demo.graphql.query;

import com.demo.graphql.request.SampleRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

@Controller
public class Query {

	@QueryMapping
	public String firstQuery () {
		return "First Query";
	}

	@QueryMapping
	public String secondQuery () {
		return "Second Query";
	}

    @QueryMapping
    public String getFullName(@Argument SampleRequest sampleRequest) {
        return sampleRequest.getFirstName() + " " + sampleRequest.getLastName();
    }
}


