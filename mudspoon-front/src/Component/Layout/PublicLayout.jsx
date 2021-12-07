import React from 'react';
import { Outlet } from 'react-router-dom';
import StartPage from "../Contents/StartPage";
import Header from "../Header/Header.jsx";
import Footer from "../Footer/Footer.jsx";

export default () => {


    return(

        <>
            <Header/>
               <Outlet/>
            <Footer/>
        </>
               
      
    )
}
