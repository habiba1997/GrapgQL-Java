import {gql} from "@apollo/client";

export const CREATE_STUDENT_MUTATION = gql`
  mutation createStudentMutation($createStudentRequest: CreateStudentRequest!) {
  createStudent( request : $createStudentRequest) {
    id
    name
    email
    learningSubjects(subjectNameFilter: ALL) {
      marksObtained
      subjectName
    }
  }
}
`;

export const FETCH_FULL_NAME = gql`
 mutation fullName(
     $firstName: String! 
     $lastName: String
 ) {
        fetchFullName(
            sampleRequest: {
                firstName: $firstName,
                lastName: $lastName
            }
        )
    }
`;

