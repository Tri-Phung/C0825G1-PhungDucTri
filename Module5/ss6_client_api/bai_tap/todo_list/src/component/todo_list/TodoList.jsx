import {useEffect, useState} from "react";
import axios from "axios";
import {toast} from "react-toastify";
import {Card, Table} from "react-bootstrap";
import {BarLoader} from "react-spinners";

const TodoList = () => {
    const [task, setTask] = useState("");
    const [list, setList] = useState([]);
    const API_URL = "http://localhost:8080/todos";
    const [loading, setLoading] = useState(false);
    useEffect(() => {
        axios.get(API_URL)
            .then(res => {
                setList(res.data);
            })
            .catch(err => console.log("Error call api: ", err));
    }, []);
    const handleChange = (e) => {
        setTask(e.target.value);
    }
    const handleAdd = async () => {
        setLoading(true);
        if (task.trim() === "") return;
        try {
            const response = await axios.post(API_URL, {title: task});
            toast.success("Task added successfully.");
            setList([...list, response.data]);
            setTask("");
        } catch (error) {
            toast.error("Something went wrong");
            console.log(error);
        } finally {
            setLoading(false);
        }
    }
    return (
        <div className="d-flex justify-content-center">
            <Card className="mt-5">
                <Card.Header className='bg-dark fw-bold text-white fs-3 text-center'>Todo List</Card.Header>
                <div className="d-flex justify-content-center mb-3">
                    <BarLoader loading={loading} color="black" width={"100%"} />
                </div>
                <Card.Body>
                    <div className='mb-4'>
                        <input
                            type="text"
                            value={task}
                            onChange={handleChange}
                            placeholder='Add a task'
                            className='me-2'
                        />
                        <button onClick={handleAdd}>Submit</button>
                    </div>
                    <Table className="list-group" style={{maxHeight: '300px'}} striped bordered hover responsive>
                        <tbody>
                        {list.map((task) => (
                            <tr key={task.id}>
                                <td>{task.title}</td>
                            </tr>
                        ))}
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
        </div>
    );
}
export default TodoList;