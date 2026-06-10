
import './App.css'


import{ BrowserRouter, Routes, Route, Link} from 'react-router-dom';
import Homepage from "./pages/Homepage.jsx"
import PaginaProdus from "./pages/PaginaProdus.jsx";
import RutinaMea from "./pages/RutinaMea.jsx";
function App() {

    return (
        <BrowserRouter>
            <nav>
                <Link to="/">Home</Link>
                <Link to="/rutina">Rutina mea</Link>
            </nav>
            <div className="container">
            <Routes>
                <Route path="/" element={<Homepage/>}/>
                <Route path="/produse/:id" element={<PaginaProdus/>}/>
                <Route path="/rutina" element={<RutinaMea/>}/>

            </Routes>
            </div>

        </BrowserRouter>);

}
  export default App;
