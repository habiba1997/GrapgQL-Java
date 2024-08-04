class CreateStudentRequest {
    constructor(email, name, subjectsLearning) {
        this.email = email;
        this.name = name;
        this.subjectsLearning = subjectsLearning.map(subject => ({
            marksObtained: subject.marksObtained,
            subjectName: subject.subjectName
        }));
    }

    addSubject(marksObtained, subjectName) {
        this.subjectsLearning.push({marksObtained, subjectName});
    }

    toJSON() {
        return {
            email: this.email,
            name: this.name,
            subjectsLearning: this.subjectsLearning
        };
    }
}

export default CreateStudentRequest;