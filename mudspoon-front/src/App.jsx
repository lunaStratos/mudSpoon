import React from 'react';
import { BrowserRouter, Route, Routes, Navigate } from 'react-router-dom';

import AccountLayout from "./Component/Layout/AccountLayout";
import PublicLayout from './Component/Layout/PublicLayout';
import LoginPage from "./Component/Contents/LoginPage";
import StartPage from "./Component/Contents/StartPage";
import MyPage from "./Component/Contents/My/MyPage";

function App() {
    return (
        <div className="hero_area">
            
            <BrowserRouter>
                <Routes>
                    <Route path="/*" element={<PublicLayout />} >
                        <Route exact path="" element={<StartPage />} />
                    </Route>
                    <Route path="/Account/*" element={<AccountLayout />} >
                        <Route path="Login" element={<LoginPage />} />
                        <Route path="My" element={<MyPage />} />
                    </Route>
                    {/* Not Found */}
                    <Route render={() => <Navigate  to="/" />} />
                </Routes>
            </BrowserRouter>
            
        </div>
    )
}


export default App;
