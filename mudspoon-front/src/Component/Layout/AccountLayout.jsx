import React from 'react';
import {  Outlet } from 'react-router-dom';
import LoginPage from "../Contents/LoginPage";

export default ({match}) => {
    
    return(
       <>
       <Outlet/>
       </>
    )

}
