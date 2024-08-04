// Imports the necessary hooks and operations from Apollo Client and React
import {useMutation, useQuery} from "@apollo/client";
import {useEffect, useState} from "react";
import StudentForm from './Components/StudentForm';
import StudentList from './Components/StudentList';
import {STUDENTS} from "./GraphQL/Queries";
import {CREATE_STUDENT_MUTATION} from "./GraphQL/Mutations";
import type CreateStudentRequest from "./class/CreateStudentRequest";
import FullNameForm from "./Components/FullNameForm";

/**
 * Main App component that manages student data and interactions.
 * Utilizes GraphQL queries and mutations to fetch and update student data.
 */
function App() {
    // Executes the STUDENTS query on component mount and whenever the query's variables change.
    const {loading, error, data} = useQuery(STUDENTS);
    // State hook for managing the list of students.
    const [students, setStudents] = useState([]);
    // Effect hook for updating the students state when new data is fetched.
    useEffect(() => {
        if (data) {
            setStudents(data.getStudents);
        }
    }, [data]);
    // Mutation hook for creating a new student.
    const [createUser, mutationObject] = useMutation(CREATE_STUDENT_MUTATION);

    // Effect hook for displaying alerts on query or mutation errors.
    useEffect(() => {
        if (error) {
            alert(`Query error: ${error.message}`);
        }
        if (mutationObject.error) {
            alert(`Mutation error: ${mutationObject.error.message}`);
        }
    }, [error, mutationObject.error]);

    // Effect hook for adding a new student to the state when the mutation is successful.
    useEffect(() => {
        if (!mutationObject.loading && mutationObject.data) {
            console.log(mutationObject.data.createStudent)
            setStudents([...students, mutationObject.data.createStudent]);
        }
    }, [mutationObject.data]);

    /**
     * Handles adding a new student through a GraphQL mutation.
     * @param {CreateStudentRequest} request - The request object containing the new student's data.
     */
    const addStudent = (request: CreateStudentRequest) => {
        createUser({
            variables: {
                createStudentRequest: request
            },
        })
    };

    // Renders the student form and list, displaying a loading message if the data is still loading.
    return (
        <>
            <div style={{display: 'flex'}}>
                <div style={{flex: 1}}>
                    <StudentForm addStudent={addStudent}/>
                </div>
                <div style={{flex: 1}}>
                    {loading ? <h3> loading ... </h3> : <StudentList students={students}/>}
                </div>
            </div>
            <div>
                <FullNameForm/>
            </div>
        </>
    )
        ;
}

// Exports the App component for use in other parts of the application.
export default App;