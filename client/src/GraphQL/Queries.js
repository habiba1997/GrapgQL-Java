import {gql} from "@apollo/client";

export const STUDENTS = gql`
  query GetStudents {
  getStudents {
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


