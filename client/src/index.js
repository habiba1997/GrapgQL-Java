import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {ApolloClient, InMemoryCache, ApolloProvider, from, HttpLink} from '@apollo/client';
import {onError} from "@apollo/client/link/error";


/**
 * This function is used to handle errors that occur during GraphQL operations.
 * It takes an object as a parameter which contains two properties: graphqlErrors and networkError.
 * @param {Object} param0 - The object containing the error details.
 * @param {Array} param0.graphqlErrors - The array of GraphQL errors.
 * @param {Object} param0.networkError - The network error details.
 */
const errorLink = onError(({graphqlErrors, networkError}) => {
    // If there are any graphqlErrors, it will iterate over them and display an alert with the error message.
    if (graphqlErrors) {
        graphqlErrors.map(({message, location, path}) => alert(`Graphql error ${message}`));
    }

    if (networkError && networkError.message) {
        alert(`Network error ${networkError.message}`);
    }
});

/**
 * This is the link that will be used by the Apollo Client.
 * It is created using the from function from the @apollo/client package.
 * The link is an array that contains the errorLink and a new HttpLink.
 * The HttpLink is used to connect to the GraphQL server.
 */
const link = from([
    errorLink,
    new HttpLink({
        uri: "http://localhost:8080/graphql",
        headers: {
            'Access-Control-Allow-Origin': '*',
        }
    }),
]);

/**
 * This is the Apollo Client instance.
 * It is created using the ApolloClient constructor from the @apollo/client package.
 * The client is configured with a cache and a link.
 * cache is an instance of InMemoryCache, which Apollo Client uses to cache query results after fetching them.
 */
const client = new ApolloClient({
    link: link,
    cache: new InMemoryCache(),
});

// Initializes the root of the application by selecting the DOM element with the id 'root'.
const root = ReactDOM.createRoot(document.getElementById('root'));

// Renders the application within the ApolloProvider.
// The ApolloProvider component is used to inject the Apollo Client instance into the React component tree.
// This enables any child component of App to have access to the Apollo Client and perform GraphQL operations.
// The comment indicates that any code within the ApolloProvider can utilize GraphQL APIs.
root.render(
    <ApolloProvider client={client}>
        <App/>
    </ApolloProvider>,
);

reportWebVitals();
