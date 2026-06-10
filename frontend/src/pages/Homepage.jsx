import {useState} from "react";
import {Link} from 'react-router-dom';


function Homepage() {
    const [cautare, setCautare] = useState("");
    const [rezultat, setRezultat] = useState(null);
    const [rezultateLocale, setRezultateLocale] =useState([]);

    function handleCauta() {
        if (/^\d+$/.test(cautare)){
            fetch("http://localhost:8080/api/produse/scan/" + cautare)
                .then(response => response.json())
                .then(data => setRezultat(data));
        } else {
            fetch("http://localhost:8080/api/produse")
                .then(response=>response.json())
                .then(data=> {
                    const filtrate = data.filter(p=>p.nume.toLowerCase().includes(cautare.toLowerCase()));
                    setRezultateLocale(filtrate);
                });
        }
    }

    return (
        <div>
            <h1> Skincare Analyzer</h1>
            <input type="text" placeholder="Cauta produs sau scaneaza barcode" value={cautare}
                   onChange={(e) => setCautare(e.target.value)}/>

            <button onClick={handleCauta}>Cauta</button>
            {rezultat && (
                <div className="card">
                    <p>{rezultat.productName}</p>
                    <p>{rezultat.ingredientsText}</p>
                </div>)}
            {rezultateLocale.map(produs=>(
                <div key={produs.id} className="card">
                    <Link to={"/produse/" + produs.id}>{produs.nume}</Link>
                    <p>{produs.brand}</p>
                </div>
            ))}
        </div>);
}


export default Homepage;