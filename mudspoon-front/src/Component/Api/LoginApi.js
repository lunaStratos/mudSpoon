import axios from 'axios';
import { loginApi } from './apiSetting.js';


export default class LoginApi {

    /**
     * 로그인 - 로그인
     * */
    static doLogin = async ({email, password})=>{

        const params = {
            "email"         : email,
            "password"     : password
        };

        return await loginApi.post(`/login/`, params);
    }

    /**
     * 로그인 - 토큰체크
     * */
     static doRefreshToken = async ({accessToken, refreshToken})=>{

        const params = {
           
        };

        const header = {
            headers: {
                "Authorization" : "Bearer " + accessToken ,
                "RefreshToken" : "Bearer " + refreshToken ,
                Pragma: 'no-cache',
                'Cache-Control': 'no-cache, no-store',
                'Content-Type': 'application/json; charset=utf-8',
                'Access-Control-Allow-Origin': '*',
            }
        }   
        

        return await axios.post(`/api/account/refreshToken`, params, header);

        return await loginApi.post(`/refreshToken`, params, header);
    }


     
}