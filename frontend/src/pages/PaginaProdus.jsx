import {useState} from 'react';
import {useParams} from 'react-router-dom';
import {useEffect} from 'react';
function PaginaProdus(){
    const {id} = useParams();
    const [produs, setProdus]= useState(null);
    useEffect(()=> {
        fetch("http://localhost:8080/api/produse/" + id + "/analiza")
            .then(response => response.json())
            .then(data=> setProdus(data));
    }, [id]);

    return(
        <div>
        <h1>Pagina Produs</h1>
            {produs && (
                <div>
                    <p>{produs.nume}</p>
                    <p>{produs.brand}</p>
                    <p>{produs.listaIngrediente}</p>

                </div>
            )}
        </div>



    );
}
export default PaginaProdus;