import axios from "axios";

const headers = {
    baseURL: `http://localhost:8080`,
    headers: {
        Pragma: 'no-cache',
        'Cache-Control': 'no-cache, no-store',
        'Content-Type': 'application/json; charset=utf-8',
        'Access-Control-Allow-Origin': '*',
    },
    withCredentials: true
}

const rq_onFulfilled = (config)=>{
    return config;
}
const rq_onRejected = (error)=>{
    console.error(`req rejected: ${error}`);
}

const rp_onFulfilled = (config)=>{
    return config;
}
const rp_onRejected = (error)=>{
    if (error.response.status === 504 || error.response.status === 502) {
        alert(`[${error.response.statusText}]\nPlease try again in a few minutes.`);
    }
    return Promise.reject(error);
}

/**
 * 라운지 APi
 */
export const loungeApi = axios.create({
    baseURL: `/api/lounge`,
    headers: headers,
    withCredentials: false,
});
loungeApi.interceptors.request.use(rq_onFulfilled, rq_onRejected);
loungeApi.interceptors.response.use(rp_onFulfilled, rp_onRejected);


/**
 * 스티커 APi
 */
 export const stickerApi = axios.create({
    baseURL: `/api/sticker`,
    headers: headers,
    withCredentials: false,
});
stickerApi.interceptors.request.use(rq_onFulfilled, rq_onRejected);
stickerApi.interceptors.response.use(rp_onFulfilled, rp_onRejected);
