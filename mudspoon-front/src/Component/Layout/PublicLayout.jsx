import React from 'react';
import { Outlet } from 'react-router-dom';
import Header from "../Header/Header.jsx";
import Footer from "../Footer/Footer.jsx";

/**
 * [일반 페이지 레이어]
 * desc: Header 와 Footer 사용 
 */
export default () => {


    return(

        <>
            <Header/>
               <Outlet/>
            <Footer/>
        </>
               
      
    )
}
