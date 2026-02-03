import {useState} from "react";

function CarSelect() {
    const [car, setCar] = useState('Mercedes S600');
    const [color, setColor] = useState('Black');
    const handleChangeCar = (e) => {
        setCar(e.target.value);
    }
    const handleChangeColor = (e) => {
        setColor(e.target.value);
    }
    return (
        <div>
            <h1>Select your car</h1>
            <div>
                <nav>Select a car</nav>
                <select onChange={handleChangeCar}>
                    <option value="Mercedes S600">Mercedes S600</option>
                    <option value="Mercedes S500">Mercedes S500</option>
                    <option value="Mercedes S400">Mercedes S400</option>
                </select>
            </div>
            <div>
                <p>Select a color</p>
                <select onChange={handleChangeColor}>
                    <option value="Black">Black</option>
                    <option value="White">White</option>
                    <option value="Yellow">Yellow</option>
                    <option value="Blue">Blue</option>
                    <option value="Red">Red</option>
                    <option value="Green">Green</option>
                </select>
            </div>
            <b>You selected a {color} - {car}</b>
        </div>
    );
}
export default CarSelect;