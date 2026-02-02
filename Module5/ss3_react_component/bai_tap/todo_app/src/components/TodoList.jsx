import {Component} from "react";
import {ListGroup} from "react-bootstrap";
import './CustomTodoList.css'

class TodoList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            input: '',
            list: []
        };
    }
    handleInputChange = (e) => {
        this.setState({input: e.target.value});
    };
    handleInputAdd = () => {
        const {input, list} = this.state;
        if (input.trim() !== "") {
            this.setState({
                list: [...list, input],
                input: ""
            });
        }
    };
    render() {
        return (
            <>
                <h1>Todo List</h1>
                <input type='text' value={this.state.input} onChange={this.handleInputChange} />
                <button onClick={this.handleInputAdd}>Add</button>
                <ListGroup as='ul' className='pt-5'>
                    {this.state.list.map((item, index) => (
                        <ListGroup.Item as='li' key={index} className="customTodoList_li">{item}</ListGroup.Item>
                    ))}
                </ListGroup>
            </>
        )
    }
}

export default TodoList;