import React, {useState} from 'react';

const StudentForm = ({addStudent}) => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [subjects, setSubjects] = useState([]);

    const handleSubjectChange = (index, event) => {
        const newSubjects = subjects.slice();
        newSubjects[index][event.target.name] = event.target.value;
        if (event.target.name === 'marksObtained') {
            newSubjects[index][event.target.name] = Number(event.target.value);

        } else {
            newSubjects[index][event.target.name] = event.target.value;

        }
        setSubjects(newSubjects);
    };

    const addSubject = () => {
        setSubjects([...subjects, {subjectName: '', marksObtained: ''}]);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        const newStudent = {
            name,
            email,
            subjectsLearning: subjects
        };
        addStudent(newStudent);
        setName('');
        setEmail('');
        setSubjects([{subjectName: '', marksObtained: ''}]);
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Add Student</h2>
            <input
                type="text"
                placeholder="Name"
                value={name}
                onChange={(e) => setName(e.target.value)}
                required
            />
            <input
                type="email"
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
            />
            {subjects.map((subject, index) => (
                <div key={index}>
                    <input
                        type="text"
                        name="subjectName"
                        placeholder="Subject Name"
                        value={subject.subjectName}
                        onChange={(e) => handleSubjectChange(index, e)}
                        required
                    />
                    <input
                        type="number"
                        name="marksObtained"
                        placeholder="Marks Obtained"
                        value={subject.marksObtained}
                        onChange={(e) => handleSubjectChange(index, e)}
                        required
                    />
                </div>
            ))}
            <button type="button" onClick={addSubject}>Add Subject</button>
            <button type="submit">Submit</button>
        </form>
    );
};

export default StudentForm;
