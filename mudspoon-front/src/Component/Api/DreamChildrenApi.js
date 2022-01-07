import { dreamChildrenApi } from './apiSetting.js';


export default class DreamChildrenApi {

    /**
     * 반경내 가게 찾기
     * */
    static searchStore = async ({lng, lat})=>{

        const params = {
            "lng"         : lng,
            "lat"         : lat
        };
        return await dreamChildrenApi.post(`/map/search/`, params);
    }


}