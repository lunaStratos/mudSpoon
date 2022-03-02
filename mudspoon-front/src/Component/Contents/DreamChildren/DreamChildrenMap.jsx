import mapboxgl from "mapbox-gl";
import React,{useState, useEffect, useRef} from "react";
import storeImage from '../../../Asset/DreamChildren/store.png';
import DreamChildrenApi from "../../Api/DreamChildrenApi";
import InfoBox from "./InfoBox";
import {setGeometryJsonMultiPoint } from "./MapUtility";
import SearchBox from "./SearchBox";

// [ENV]
mapboxgl.accessToken = process.env.REACT_APP_MAPBOX_APIKEY;             // API key


/**
 * [Dream Children Project]
 *  - 꿈의 아이들 프로젝트 front
 * 
 */
export default function(){

    //시작 값들 
    const startlat = parseFloat(process.env.REACT_APP_START_LATITUDE);
    const startlng = parseFloat(process.env.REACT_APP_START_LONGITUDE);
    const startZoomLevel = parseInt(process.env.REACT_APP_START_ZOOMLEVEL);
    const minZoom = parseInt(process.env.REACT_APP_VIEW_MINZOOM);

    // 
    const [lngLat, setlngLat] = useState([startlng, startlat]);
    const [zoomLevel, setZoomLevel] = useState(startZoomLevel);
    const [storeInfo, setStoreInfo] = useState({
      storeName : "가게이름",
      storeCode : "가게코드",
      si : "시", 
      gungu :"군구", 
      sigunguCode : "시군구 코드",
      address: "주소",
      addresLagacy : "레거시 주소", 
      tel : "000-0000-0000",
      mainOperationStartTime :"00:00", 
      mainOperationEndTime :"00:00", 
      satOperationStartTime :"00:00", 
      satOperationEndTime :"00:00", 
      holydatOperationStartTime :"00:00", 
      holydayOperationEndTime :"00:00", 
      deliveryStartTime :"00:00", 
      deliveryEndTime :"00:00", 
      managementAgency :"asd", 
      managementAgencyTel :"asd", 
      longitude : "",
      latitude: "" 
    });

    // 가게리스트 저장 
    const [storeList, setStoreList] = useState([])

    // 지도 REF
    const map = useRef(null); 
    const mapContainer = useRef(null);

    // 지도시작 
    async function initMap(){

        if (map.current) return;

        //맵 최초생성
        map.current = new mapboxgl.Map({
            container: mapContainer.current, 
            style: 'mapbox://styles/mapbox/outdoors-v11',
            center: lngLat,
            zoom: zoomLevel,
            scrollZoom: true,
            maxZoom: parseInt(process.env.REACT_APP_VIEW_MAXZOOM)
        });

        /**
         * [자도 로딩후 이벤트]
         */
        map.current.on('load', async (event) => {

            /**
             * [마우스 클릭 이벤트]
             */
            map.current.on("click", 'places', (e) => {
              if(map.current.getZoom() < minZoom) return;

              const coordinates = e.features[0].geometry.coordinates.slice();
              const description = e.features[0].properties.description;
                  
              const latLng = e.lngLat;
              const lng = latLng.lng, lat = latLng.lat;
              
              while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) {
              coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
              }
                
              setStoreInfo(JSON.parse(description));

            });
              
            /**
             * [마우스 움직임 이후 Drag]
             */
            map.current.on("mousemove",  async (event) => {
              if(map.current.getZoom() < minZoom) return;

                map.current.once('mouseup', onUp);
            });
            
        });
    }

    /**
     *[ 마우스 드래그 후 이벤트]
     */
    async function onUp(e) {
        
        //브라우져 지도의 남서쪽, 북동쪽 좌표 (사용안함)
        const ne = map.current.getBounds().getNorthEast();
        const sw = map.current.getBounds().getSouthWest();

        // 중점좌표 
        const center = map.current.getBounds().getCenter();
        const lng = center.lng;
        const lat = center.lat;

        const res = await DreamChildrenApi.searchStore({lng: lng, lat: lat});

        if(res.status === 200){

          const dataList = res.data.data;          
          const features = setGeometryJsonMultiPoint(dataList);
          setStoreList(dataList);

          if(map.current.getSource("places") !== undefined){

            map.current.getSource("places").setData(features);

          } else {

            map.current.addSource('places', {
              "type": "geojson",
              "data": features
              }
            );
          
            map.current.addLayer({
              'id': 'places',
              'type': 'symbol',
              'source': 'places',
              "layout": {
                  'icon-image': "storeImage",
                  'icon-size': 0.1,
                  'icon-allow-overlap': true, // zoomLevel 17.18정도일때 합쳐짐 방지
                },
              "paint": {
                  'icon-opacity': 1
                },
              "minzoom" : parseInt(process.env.REACT_APP_PLACE_VIEW_MINZOOM)
            });

          }

        }
        

    }

    /**
   * [가게 이미지 전부 부르기]
   * desc: 미리 불러야 함.
   * Image file must be in png, webp, or jpg format.
   * */
  const _setFlagImage = async () => {
    const flagArr = [{name: "storeImage", image: storeImage}];
    flagArr.map(async (item) =>{
      if (!map.current.hasImage(item.name)){
        await map.current.loadImage(
            item.image,
            (error, image) => {
              if (error) throw error;
              map.current.addImage(item.name, image);
            });
      }
    });
  }
    
    /**
     * [최초 실행시 시작]
     */
    useEffect( async() => {
       
        async function fetchAndSetUser() {
          await initMap();
          await _setFlagImage();
          await onUp(); // DB 지도 부르기 
        }
        fetchAndSetUser();

    }, []);

    return(
     <>
       <div ref={mapContainer} className="map-container" style={{height: '100vh'}} >
            <InfoBox data={storeInfo}/>
            {/*<SearchBox/>*/}
        </div>
     </>   
    )
}