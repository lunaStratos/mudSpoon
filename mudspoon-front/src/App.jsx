import React from 'react';
import { BrowserRouter, Route, Routes, Navigate } from 'react-router-dom';

import Header from "./Component/Header/Header.jsx";
import StartPage from "./Component/Contents/StartPage";
import Footer from './Component/Footer/Footer.jsx';
import LoginPage from './Component/Contents/LoginPage';


function App() {
    return (
        <div className="hero_area">
            
            <BrowserRouter>
                <Header/>
                <Routes>
                    <Route exact path="/" element={<StartPage />} />
                    {/* Not Found */}
                    <Route render={() => <Navigate  to="/" />} />
                    <Route exact path="/Login" element={<LoginPage />} />
                </Routes>
                <Footer/>
            </BrowserRouter>
            
        </div>
    )
}


export default App;
