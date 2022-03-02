import React, {useEffect, useState} from 'react';
import {useRecoilState, useRecoilValue} from 'recoil';
import {SearchAddressState, SearchGPSComplateSelector, SearchGPSState} from "../../../Store/SearchAddressStore";
import {geocodingApi} from "../../Api/externalApi/mapboxApi";

export default function SearchBox() {
    const [mapStore, setMapStore] = useRecoilState(SearchAddressState);
    const [GPSSearch, setGPSSearch] = useRecoilState(SearchGPSState)
    const getGPSClickComp = useRecoilValue(SearchGPSComplateSelector);
    const [param, setParam] = useState("");
    const [searchResult, setSearchResult] = useState({
        flag : false,
        contents : [],
        msg: ""
    });

    const [gps, setGps] = useState(false);

    // 주소검색
    async function onSearch(){
        // Todo : caller연결
        const res = await geocodingApi(param);

        if(res.data.features.length !== 0){
            const center = res.data.features[0].center;
            setMapStore({longitude : center[0], latitude : center[1], productId : -1});
            setSearchResult({
                flag : false,
                contents : [],
                msg: ""
            });
        }else{
            setSearchResult({
                flag : true,
                contents : [],
                msg: "조회결과 없습니다."
            });
        }
    }

    //GPS 버튼
    async function onClickGPS(){
        //이미지 교체
        setGps(true);
        // 갱신
        setGPSSearch(new Date().getMilliseconds());
        return;
    }

    // 이미지교체
    useEffect(() => setGps(false), [getGPSClickComp]);

    return (
        <div className="map_fixed_box search_box">
            <div>

                <div className="gps_wrap">
                    {
                        gps ?
                            <img src={require("../../../Asset/DreamChildren/map_search_GPS_on.png").default} alt="GPS" />
                            :
                            <img src={require("../../../Asset/DreamChildren/map_search_GPS_off.png").default} alt="GPS"  onClick={(e) => onClickGPS()}/>
                    }

                </div>

                <div className="search_wrap">
                    <input type="text" placeholder="search location" onChange={(e) => setParam(e.target.value)} onKeyPress={(e) => e.key === 'Enter' ? onSearch() : console.log()}/>
                    <button><img src={require("../../../Asset/DreamChildren/map_search_icon_1.png").default} alt="Search" onChange={(e) => onSearch()}/></button>

                    <div className={searchResult.flag ? "search_list": "search_list hide"} >
                        <ul>
                            <li onClick={(e) => setSearchResult(item => ({...item, flag : false}))}>{searchResult.msg}</li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    )
}
