import React from "react";
import Table from "react-bootstrap/Table";
const StudentList = ({students}) => {
    if (students.length === 0) return <p>No students found.</p>;
    return (
        <div className="container mt-4">
            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>Company</th>
                    <th>Contact</th>
                    <th>Country</th>
                </tr>
                </thead>
                <tbody>
                {students.map(student => (
                    <tr key={student.id}>
                        <td>{student.company}</td>
                        <td>{student.contact}</td>
                        <td>{student.country}</td>
                    </tr>
                ))}
                </tbody>
            </Table>
        </div>
    )
}
export default StudentList;