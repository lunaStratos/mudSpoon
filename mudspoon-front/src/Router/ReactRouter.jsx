import { BrowserRouter, Route, Routes, Navigate } from 'react-router-dom';

import AccountLayout from "../Component/Layout/AccountLayout";
import PublicLayout from '../Component/Layout/PublicLayout';
import LoginPage from "../Component/Contents/LoginPage";
import StartPage from "../Component/Contents/StartPage";
import MyPage from "../Component/Contents/My/MyPage";
import ContactPage from "../Component/Contents/ContactPage";
import StickerPage from "../Component/Contents/StickerPage";
import LoungePage from "../Component/Contents/LoungePage";
import DevpiaPage from "../Component/Contents/DevpiaPage";

export default function(){

    return(
        <BrowserRouter>
                <Routes>
                    <Route path="/*" element={<PublicLayout />} >
                        <Route exact path="" element={<StartPage />} />
                        <Route exact path="Lounge" element={<LoungePage />} />
                        <Route exact path="Sticker" element={<StickerPage />} />
                        <Route exact path="Contact" element={<ContactPage />} />
                        <Route exact path="Devpia" element={<DevpiaPage />} />

                    </Route>
                    <Route path="/Account/*" element={<AccountLayout />} >
                        <Route path="Login" element={<LoginPage />} />
                        <Route path="My" element={<MyPage />} />
                    </Route>
                    {/* Not Found */}
                    <Route render={() => <Navigate  to="/" />} />
                </Routes>
            </BrowserRouter>
    )
}