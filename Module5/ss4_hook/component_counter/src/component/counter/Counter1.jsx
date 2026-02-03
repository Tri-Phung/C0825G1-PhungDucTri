import {useIncrement} from "./useIncrement.js";

function Counter1() {
    const [count, setCount] = useIncrement(1);
    return (
        <div>
            <p>Count: {count}</p>
            <button onClick={setCount}>Add 1</button>
        </div>
    )
}
export default Counter1;