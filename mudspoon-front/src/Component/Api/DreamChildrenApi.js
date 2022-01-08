import { dreamChildrenApi } from './apiSetting.js';

/**
 * [꿈의 아이들]
 * 
 */
export default class DreamChildrenApi {

    /**
     * 반경내 가게 찾기
     * */
    static searchStore = async ({lng, lat})=>{

        const params = {
            "lng"         : lng,
            "lat"         : lat
        };
        return await dreamChildrenApi.post(`/searchStore/`, params);
    }


}