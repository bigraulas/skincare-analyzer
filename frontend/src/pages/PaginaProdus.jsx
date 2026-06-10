import {useState} from 'react';
import {useParams} from 'react-router-dom';
import {useEffect} from 'react';

function PaginaProdus() {
    const {id} = useParams();
    const [produs, setProdus] = useState(null);
    useEffect(() => {
        fetch("http://localhost:8080/api/produse/" + id + "/analiza")
            .then(response => response.json())
            .then(data => setProdus(data));
    }, [id]);

    function getClasaScor(scor) {
        if (scor >= 7) return "scor-verde";
        if (scor >= 4) return "scor-galben";
        return "scor-rosu";
    }

    return (
        <div>
            <h1>Pagina Produs</h1>
            {produs && (
                <div>
                    <p>{produs.nume}</p>
                    <p>{produs.brand}</p>
                    <h2>Ingredientele</h2>
                    {produs.ingrediente && produs.ingrediente.map(ing => (
                        <div key={ing.id} className="card">
                            <p><strong>{ing.numeInci}</strong></p>
                            <p>Scor: <span className={getClasaScor(ing.scorSiguranta)}>{ing.scorSiguranta}/10</span></p>
                            <span className={ing.eComedogenic ? "comedogenic" : "non-comedogenic"}>
                                {ing.eComedogenic ? "Comedogenic" : "Non-comedogenic"}
                            </span>
                            <p>{ing.functie}</p>
                        </div>
                    ))}


                </div>
            )}
        </div>


    );
}

export default PaginaProdus;