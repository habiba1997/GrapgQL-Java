package com.demo.graphql.query;

import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

@Controller
public class Query {

    @QueryMapping
    public String firstQuery() {
        return "First Query";
    }

    @QueryMapping
    public String secondQuery() {
        return "Second Query";
    }

}