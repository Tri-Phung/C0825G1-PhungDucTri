import {Component} from "react";
import {Table} from "react-bootstrap";

class StudentInfo extends Component {
    constructor(props) {
        super(props);
        this.state = {
            students: [
                {id: 1, name: 'Tri', age: 24, address: 'Da Nang'},
                {id: 2, name: 'Brian', age: 25, address: 'Da Nang'},
                {id: 3, name: 'Brian', age: 25, address: 'Da Nang'}
            ],
        };
    }
    render() {
        if (this.state.students.length === 0) {
            return <p className='text-center'>No Student Found</p>;
        }
        return (
            <Table striped bordered hover responsive>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Address</th>
                </tr>
                </thead>
                <tbody>
                {this.state.students.map(student => (
                    <tr key={student.id}>
                        <td>{student.id}</td>
                        <td>{student.name}</td>
                        <td>{student.age}</td>
                        <td>{student.address}</td>
                    </tr>
                ))}
                </tbody>
            </Table>
        )
    }
}
export default StudentInfo;