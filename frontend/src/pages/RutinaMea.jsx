import {useState} from 'react';
import {useEffect} from 'react';

function RutinaMea(){
    const[rutine, setRutine]= useState([]);
    const[rutinaProduse, setRutinaProduse] = useState([]);
    useEffect(()=>{
        fetch("http://localhost:8080/api/rutine")
            .then(response=>response.json())
            .then(data=>setRutine(data));
        fetch("http://localhost:8080/api/rutinaproduse")
            .then(response => response.json())
            .then(data=>setRutinaProduse(data));
    }, []);

   return(
    <div>
        <h1>Rutina Mea</h1>
        <div className="card">
        {rutine.map(rutina=>{
            const produseRutina = rutinaProduse.filter(rp=> rp.rutina.id === rutina.id);
            const dimineata= produseRutina.filter(rp=> rp.momentZi === "DIMINEATA");
            const seara=produseRutina.filter(rp=> rp.momentZi ==="SEARA");
            return (<div key={rutina.id}>
            <p>{rutina.nume}</p>
        <p>{rutina.tipPiele}</p>
                    <div>
                    <h3>Dimineata</h3>
                        {dimineata.map(rp=>
            <p key={rp.id}>{rp.produs.nume}</p>)}
                    </div>
                    <div>
                        <h3>Seara</h3>
                        {seara.map(rp=>
                        <p key={rp.id}>{rp.produs.nume}</p>)}
                    </div>
            </div>
            )})}

        </div>
    </div>);
}
export default RutinaMea;