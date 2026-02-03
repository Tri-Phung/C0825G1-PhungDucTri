import {useState} from "react";

export function useIncrement(incrementAmount) {
    const [count, setCount] = useState(0);
    const handleIncrement = () => {
        setCount((prevCount) => prevCount + incrementAmount);
    }
    return [count, handleIncrement];
}