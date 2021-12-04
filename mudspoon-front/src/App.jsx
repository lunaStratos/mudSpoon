import React, {useState, useEffect} from 'react';
import Header from "./Component/Header/Header.jsx";
import Main from "./Component/Contents/Main.jsx";
import Footer from './Component/Footer/Footer.jsx';


function App() {
    return (
        <div className="hero_area">
            <Header/>
            <Main/>
            <Footer/>
        </div>
    )
}


export default App;
