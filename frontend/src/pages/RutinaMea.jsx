import {useState} from 'react';
import {useEffect} from 'react';

function RutinaMea(){
    const[rutine, setRutine]= useState([]);
    useEffect(()=>{
        fetch("http://localhost:8080/api/rutine")
            .then(response=>response.json())
            .then(data=>setRutine(data));
    }, []);
   return(
    <div>
        <h1>Rutina Mea</h1>
        {rutine.map(rutina=>(<div key={rutina.id}>
            <p>{rutina.nume}</p>
        <p>{rutina.tipPiele}</p></div>))}
    </div>);
}
export default RutinaMea;