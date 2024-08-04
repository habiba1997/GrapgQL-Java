# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

## Apollo Link 
The Apollo link is a system of modular components for network request control in Apollo Client. It's a chain of functions that can manipulate requests and responses, allowing you to control how and when a request is sent.

In the provided code, the `from` function is used to create a link from an array of individual links. The order of the links in the array is important because it determines the order in which they will be applied to the request.

The `errorLink` is a link that handles GraphQL errors. It's placed at the beginning of the array, so it will be the first to handle any errors that occur during the request. This allows you to handle errors in a centralized place, rather than having to handle them individually for each request.

The `HttpLink` is a terminating link that sends the request to a GraphQL server over HTTP. It's placed at the end of the array, so it will be the last link to handle the request. This ensures that all other links have had a chance to manipulate the request before it's sent to the server.

The Apollo Client can distinguish between different links based on their functionality. For example, it knows that the `errorLink` is for error handling and the `HttpLink` is for sending the request. This allows the Apollo Client to apply each link to the request in the appropriate way.