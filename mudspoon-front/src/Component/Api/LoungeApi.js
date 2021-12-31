import { loungeApi, stickerApi } from './apiSetting.js';


export default class LoungeApi {

    /**
     * 라운지 - LIST
     * */
    static getListApi = async (page, search)=>{

        const params = {
            "page"         : page,
            "search"     : search
        };
        return await loungeApi.get(`/list/${page}/`, params);
    }

     /**
     * 라운지 - 글쓰기
     * */
      static doSubmitApi = async (value)=>{
        const params = {
            "contents"         : value
        };
        return await loungeApi.post(`/write`, params, );
    }

     /**
     * 라운지 - 글삭제
     * */
      static doDeleteApi = async (num)=>{

        const params = {
            "num"         : num
        };

        return await loungeApi.post(`/delete`,params);
    }
}