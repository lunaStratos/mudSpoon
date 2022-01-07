import mapboxgl from "mapbox-gl";
import React,{useState, useEffect, useRef} from "react";
import storeImage from '../../../Asset/DreamChildren/store.png';
import DreamChildrenApi from "../../Api/DreamChildrenApi";
import InfoBox from "./InfoBox";
import { sampleJson, setGeometryJsonMultiPoint } from "./MapUtility";

mapboxgl.accessToken = "pk.eyJ1IjoibHVuYXN0cmF0b3MiLCJhIjoiY2tybXM2MXZnMm5wcjMxbzJ4eDdwZm45diJ9.vf2FoHHxyF7IPDWQfpjgGg";             // API key


export default function(){

    const [lngLat, setlngLat] = useState([127.146493, 37.529473]);
    const [zoomLevel, setZoomLevel] = useState(16);
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

    const [storeList, setStoreList] = useState([])

    const map = useRef(null); 
    const mapContainer = useRef(null);

    async function initMap(){
        if (map.current) return;

        //맵 최초생성
        map.current = new mapboxgl.Map({
            container: mapContainer.current, 
            style: 'mapbox://styles/mapbox/outdoors-v11',
            center: lngLat,
            zoom: zoomLevel,
            scrollZoom: true,
            maxZoom: 16.5
        });

        map.current.on('load',async () => {

            
            map.current.addSource('places', sampleJson() );

            map.current.addLayer({
            'id': 'places',
            'type': 'symbol',
            'source': 'places',
            layout: {
                'icon-image': "storeImage",
                'icon-size': 0.1,
                'icon-allow-overlap': true, // zoomLevel 17.18정도일때 합쳐짐 방지
              },
              paint: {
                'icon-opacity': 1
              }
            });
              
            // When a click event occurs on a feature in the places layer, open a popup at the
            // location of the feature, with description HTML from its properties.
            map.current.on('click', 'places', (e) => {
            // Copy coordinates array.
            const coordinates = e.features[0].geometry.coordinates.slice();
            const description = e.features[0].properties.description;
                
            const latLng = e.lngLat;
            const lng = latLng.lng, lat = latLng.lat;
            
            // Ensure that if the map is zoomed out such that multiple
            // copies of the feature are visible, the popup appears
            // over the copy being pointed to.
            while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) {
            coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
            }
              
            console.log(description);
            setStoreInfo(description);
            });
              
            /**
             * [마우스 움직임 이후 Drag]
             */
            map.current.on("mousemove",  async (event) => {
                map.current.once('mouseup', onUp);
            });
        });
    }

    async function onUp(e) {
        
        //브라우져 지도의 남서쪽, 북동쪽 좌표
        const ne = map.current.getBounds().getNorthEast();
        const sw = map.current.getBounds().getSouthWest();
        const center =  map.current.getBounds().getCenter();
        
        console.log(center);
        // Todo : 위경도 값으로 부르기 

        const lng = center.lng;
        const lat = center.lat;
        const res = await DreamChildrenApi.searchStore({lng: lng, lat: lat});

        if(res.code === 200){
          const dataList = res.data;
          setStoreList(dataList);
          
          const features = setGeometryJsonMultiPoint(dataList)
          map.current.getSource("places").setData(features);
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
     * [최초 실행시 시자]
     */
    useEffect( async() => {
        await initMap();
        await _setFlagImage();
    }, []);

    return(
     <>
       <div ref={mapContainer} className="map-container" style={{height: '100vh'}} >
            <InfoBox data={storeInfo}/>
        </div>
     </>   
    )
}