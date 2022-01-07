
/**
 * json maker for Image
 * > MultiPoint
 */
 export const setGeometryJsonMultiPoint = (coordinates) =>{
    return {
        type: "FeatureCollection",
        features: [{
            type: "Feature",
            geometry: {
                type: "MultiPoint",
                coordinates: coordinates
            },
        }]
    };
}

export const sampleJson = () =>{

    return {
        'type': 'geojson',
        'data': {
            'type': 'FeatureCollection',
            'features': [
            {
            'type': 'Feature',
            'properties': {
            'description':
            {   
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
            },
            'icon': 'theatre-15'
            },
            'geometry': {
            'type': 'Point',
            'coordinates': [
                127.14520454406738,
                37.531850250603824
            ]
            }
            },
            {
            'type': 'Feature',
            'properties': {
            'description':
            {
                storeName : "",
                storeCode : "",
                si : "", 
                gungu :"", 
                sigunguCode : "",
                address: "",
                addresLagacy : "", 
                tel : "",
                mainOperationStartTime :"", 
                mainOperationEndTime :"", 
                satOperationStartTime :"", 
                satOperationStartTime :"", 
                holydatOperationStartTime :"", 
                holydayOperationStartTime :"", 
                deliveryStartTime :"", 
                deliveryEndTime :"", 
                managementAgency :"", 
                managementAgencyTel :"", 
                longitude : "",
                latitude: "" 
            },
            'icon': 'theatre-15'
            },
            'geometry': {
            'type': 'Point',
            'coordinates':  [127.14606285095215, 
                37.531850250603824]
            }
            }
            
            ]
        }
    }
    
    
}
