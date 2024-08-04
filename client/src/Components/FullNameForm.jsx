import React, {useEffect, useState} from 'react';
import {FETCH_FULL_NAME} from "../GraphQL/Mutations";
import {useMutation} from "@apollo/client";

const FullNameForm = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');

    const [fetchData, object] = useMutation(FETCH_FULL_NAME);


    // Effect hook for displaying alerts on query or mutation errors.
    useEffect(() => {
        if (object.error) {
            alert(`Query error: ${object.error}`);
        }

        if (!object.loading && object.data) {
            alert(`Your Full Name is: ${object.data.fetchFullName}`)

        }
    }, [object.data, object.loading, object.error]);


    const handleSubmit = (event) => {
        event.preventDefault();
        fetchData({
            variables: {
                firstName: firstName,
                lastName: lastName
            },
        })
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Concatenate Name</h2>
            <input
                type="text"
                placeholder="First Name"
                value={firstName}
                onChange={(e) => setFirstName(e.target.value)}
                required
            />
            <input
                type="text"
                placeholder="Last Name"
                value={lastName}
                onChange={(e) => setLastName(e.target.value)}
                required
            />

            <button type="submit">Submit</button>
        </form>
    );
};

export default FullNameForm;
