import {useState} from "react";


function Homepage() {
    const [cautare, setCautare] = useState("");
    const [rezultat, setRezultat] = useState(null);

    function handleCauta() {
        fetch("http://localhost:8080/api/produse/scan/" + cautare)
            .then(response => response.json())
            .then(data => setRezultat(data));
    }

    return (
        <div>
            <h1> Skincare Analyzer</h1>
            <input type="text" placeholder="Cauta produs sau scaneaza barcode" value={cautare}
                   onChange={(e) => setCautare(e.target.value)}/>

            <button onClick={handleCauta}>Cauta</button>
            {rezultat && (
                <div>
                    <p>{rezultat.productName}</p>
                    <p>{rezultat.ingredientsText}</p>
                </div>)}
        </div>);
}


export default Homepage;