import React from 'react';

const StudentList = ({ students }) => {
    return (
        <div>
            <h2>Student List</h2>
            {students.map((student) => (
                <div key={student.id}>
                    <h3>{student.name}</h3>
                    <p>Email: {student.email}</p>
                    <ul>
                        {student.learningSubjects.map((subject, subIndex) => (
                            <li key={subIndex}>
                                {subject.subjectName} - {subject.marksObtained} marks
                            </li>
                        ))}
                    </ul>
                </div>
            ))}
        </div>
    );
};

export default StudentList;
