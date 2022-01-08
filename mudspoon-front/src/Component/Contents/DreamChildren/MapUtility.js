
/**
 * json maker for Image
 * > MultiPoint
 */
 export const setGeometryJsonMultiPoint = (infoArray) =>{

    const maekArr = infoArray.map(item =>{
        return {
            "type": "Feature",
            "properties": {
                "description": item,
                "icon": "theatre-15"
                },
            "geometry": {
            "type": "Point",
            "coordinates":  [
                item.longitude, 
                item.latitude
                ]
            }
        }
    });

    return {
        
            "type": "FeatureCollection",
            "features": maekArr
        
    };
}
/**
 * [가게코드 => 가게타입]
 */
export const storeCodeName = (item) =>{
    console.log(item);
    
    if(item === "1" || item === "01") return "일반식당";
    if(item === "2" || item === "02") return "주/부식";
    if(item === "3" || item === "03") return "편의점";

}

export const sampleJson = () =>{

    return {
        "type": "geojson",
        "data": {
            "type": "FeatureCollection",
            "features": [
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 명일로 166(둔촌동,1층)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53368693,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-484-4531",
                            "storeName": "뚜레쥬르 둔촌대우점",
                            "id": 9511,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1448017,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1448017,
                            37.53368693
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 진황도로 155 (둔촌동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53217695,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-477-8368",
                            "storeName": "풍년보리밥",
                            "id": 9512,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1417576,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1417576,
                            37.53217695
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 진황도로 154, 1층(둔촌동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53227832,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-484-9288",
                            "storeName": "지도리치킨",
                            "id": 9465,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1413731,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1413731,
                            37.53227832
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 명일로 171 (둔촌동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53413406,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-479-0842",
                            "storeName": "빠사시 떡볶이 둔촌점",
                            "id": 9513,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.144617,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.144617,
                            37.53413406
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 명일로 202, 1층(길동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.5367345,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-470-8280",
                            "storeName": "파리바게트 길동우성점",
                            "id": 9508,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1459526,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1459526,
                            37.5367345
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 명일로 214 (길동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53773247,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-482-1611",
                            "storeName": "팔미원(구 화신반점)",
                            "id": 9504,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1462261,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1462261,
                            37.53773247
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 양재대로 1355, 1층 (성내동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.52739444,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-6337-1332",
                            "storeName": "뚜레쥬르  둔촌동역점",
                            "id": 9503,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1356168,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1356168,
                            37.52739444
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 양재대로111길 15 (길동, 탑스위트상가1층)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53698126,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-486-9923",
                            "storeName": "김밥사랑",
                            "id": 9506,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1385669,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1385669,
                            37.53698126
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 양재대로 116길 16, 104호(길동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53840533,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-470-0518",
                            "storeName": "홍짜장",
                            "id": 9509,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1411946,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1411946,
                            37.53840533
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 양재대로116길 16, 104호(길동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53840533,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-435-7861",
                            "storeName": "바비박스 길동점",
                            "id": 9510,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1411946,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1411946,
                            37.53840533
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 강동대로 245",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.52227586,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-464-5556",
                            "storeName": "이효재만두",
                            "id": 9501,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.133232,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.133232,
                            37.52227586
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 강동대로53길 12, 102호 (성내동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.52336236,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-472-7729",
                            "storeName": "구삼부대찌개",
                            "id": 9502,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.131718,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.131718,
                            37.52336236
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 진황도로 59-2, 1층 (천호동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53752741,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-3492-2580",
                            "storeName": "힐링차이나",
                            "id": 9532,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.133757,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.133757,
                            37.53752741
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "00:00",
                            "address": "경기도 의왕시 오린계2길 5 (학의동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.539917,
                            "satOperationEndTime": "00:00",
                            "sigunguCode": "41430",
                            "managementAgencyTel": "031-345-2763",
                            "gungu": "의왕시",
                            "managementAgency": "경기도 의왕시청",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "00:00",
                            "holydayOperationStartTime": "06:00",
                            "si": "경기도",
                            "stoteCode": "1",
                            "satOperationStartTime": "06:00",
                            "mainOperationStartTime": "06:00",
                            "tel": "031-423-9393",
                            "storeName": "주식회사 온누리",
                            "id": 20784,
                            "deliveryStartTime": "06:00",
                            "longitude": 127.156406,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.156406,
                            37.539917
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 명일로 263-1",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54228653,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-471-0099",
                            "storeName": "뚜레쥬르 길동신명점",
                            "id": 9507,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1473439,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1473439,
                            37.54228653
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 양재대로 1532, 102호 (길동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54236523,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-477-0067",
                            "storeName": "김한성짬뽕",
                            "id": 9505,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1419398,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1419398,
                            37.54236523
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구천호대로162길 73, 1층 108호(성내동, 원다빌2)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53336423,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-474-2425",
                            "storeName": "천하일미",
                            "id": 9499,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1277486,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1277486,
                            37.53336423
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 천호대로162길 45, 1층 (성내동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.5348231,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-471-9959",
                            "storeName": "천호유통",
                            "id": 9497,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1281403,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1281403,
                            37.5348231
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 천호대로162길 68(성내동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53392662,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-435-8771",
                            "storeName": "빵이 가득한 집",
                            "id": 9495,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1275957,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1275957,
                            37.53392662
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 천호옛12길 57 (성내동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53485989,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-485-7480",
                            "storeName": "영국베이커리",
                            "id": 9498,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1277511,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1277511,
                            37.53485989
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 천호대로162길 34, 207호(성내동, 이안강동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53557687,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-474-0205",
                            "storeName": "2.5 짜장",
                            "id": 9496,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1279515,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1279515,
                            37.53557687
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 풍성로37길 3, 1층(성내동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53207256,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-476-8294",
                            "storeName": "파리바게트 성내삼성점",
                            "id": 9500,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.125728,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.125728,
                            37.53207256
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 진황도로 17-1, 1층(천호동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53957913,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-478-0334",
                            "storeName": "여수동치즈갈매기천호점",
                            "id": 9534,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1295832,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1295832,
                            37.53957913
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 진황도로 12, 지하 157호(천호동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53911562,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-483-6180",
                            "storeName": "청담돈가스",
                            "id": 9531,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.128297,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.128297,
                            37.53911562
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 상암로 150-1, 101호(천호동, 상경아트빌)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54549319,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-485-1125",
                            "storeName": "100세짬뽕",
                            "id": 9524,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1391711,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1391711,
                            37.54549319
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로34길 17, 1층(천호동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54245586,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-474-2881",
                            "storeName": "행복가득 찬",
                            "id": 9523,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.132168,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.132168,
                            37.54245586
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로 226, 1층(천호동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54081147,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-474-4473",
                            "storeName": "김재성 교동짬뽕",
                            "id": 9533,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1297935,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1297935,
                            37.54081147
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 성내로5길 24, 1층(성내동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53079878,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-476-9293",
                            "storeName": "다래성",
                            "id": 9493,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1238916,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1238916,
                            37.53079878
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 성내로5길 26 (성내동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53093563,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-473-6199",
                            "storeName": "통통김치찌개",
                            "id": 9494,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1239023,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1239023,
                            37.53093563
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로34길 11 (천호동, 1층)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.5425139,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-482-6161",
                            "storeName": "천호지도리치킨",
                            "id": 9522,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1318377,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1318377,
                            37.5425139
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로 248, 1층 (천호동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54230193,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-474-2494",
                            "storeName": "꼬꼬시에프",
                            "id": 9535,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1312399,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1312399,
                            37.54230193
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 상암로49길 8 (명일동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54685569,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-3427-2847",
                            "storeName": "양자강",
                            "id": 9543,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1450082,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1450082,
                            37.54685569
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로 250, 1층 (천호동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54251432,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-475-5389",
                            "storeName": "빨간여우떡볶이",
                            "id": 9490,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1314575,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1314575,
                            37.54251432
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로 250, 1층(천호동, 신성빌딩)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54251432,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-485-5557",
                            "storeName": "뚜레쥬르 천호시장점",
                            "id": 9521,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1314575,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1314575,
                            37.54251432
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "23:00",
                            "address": "서울특별시 송파구 양재대로 1222, 1층(방이동)",
                            "deliveryEndTime": "23:00",
                            "latitude": 37.5157197,
                            "satOperationEndTime": "23:00",
                            "sigunguCode": "11710",
                            "managementAgencyTel": "02-2147-3811",
                            "gungu": "송파구",
                            "managementAgency": "송파구청 아동돌봄청소년과",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "23:00",
                            "holydayOperationStartTime": "07:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "07:00",
                            "mainOperationStartTime": "07:00",
                            "tel": "02-401-7844",
                            "storeName": "파리바게트",
                            "id": 6549,
                            "deliveryStartTime": "07:00",
                            "longitude": 127.1310621,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1310621,
                            37.5157197
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 성내로3길 16-11 (성내동,1층)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53051836,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-472-1190",
                            "storeName": "차이젠(해물왕짬뽕)",
                            "id": 9491,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1231414,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1231414,
                            37.53051836
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 성내로 19, 1층 105호(성내동, 서경빌딩)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53036011,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-478-8204",
                            "storeName": "파리바게트 강동구청점",
                            "id": 9492,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1228289,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1228289,
                            37.53036011
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로 205, 107호(천호동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54065545,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-486-6115",
                            "storeName": "바다마을 멸치국수",
                            "id": 9530,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1274442,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1274442,
                            37.54065545
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로 456(명일동, 1층)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54912502,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-427-1237",
                            "storeName": "캠토명일점",
                            "id": 9546,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1488511,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1488511,
                            37.54912502
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "01:00",
                            "address": "서울특별시 송파구 바람드리길 59 (풍납동)",
                            "deliveryEndTime": "01:00",
                            "latitude": 37.53693419,
                            "satOperationEndTime": "01:00",
                            "sigunguCode": "11710",
                            "managementAgencyTel": "02-2147-3811",
                            "gungu": "송파구",
                            "managementAgency": "송파구청 아동돌봄청소년과",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "01:00",
                            "holydayOperationStartTime": "07:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "07:00",
                            "mainOperationStartTime": "07:00",
                            "tel": "02-483-5853",
                            "storeName": "파리바게트",
                            "id": 7193,
                            "deliveryStartTime": "07:00",
                            "longitude": 127.122428,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.122428,
                            37.53693419
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 상암로51길 54, 앞도로(청춘마켓 6호)(명일동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54934112,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "000-0000-0000",
                            "storeName": "한스델리",
                            "id": 9549,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1465167,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1465167,
                            37.54934112
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 올림픽로 654, 상영빌딩 1,2층",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.53985894,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-488-7165",
                            "storeName": "롯데 지알에스 주식회사(롯데리아)",
                            "id": 9529,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1240846,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1240846,
                            37.53985894
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로 490 (명일동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54903711,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-453-5599",
                            "storeName": "꿀닭",
                            "id": 9550,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1527783,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1527783,
                            37.54903711
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 올림픽로80길 37 (천호동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54323599,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-484-0182",
                            "storeName": "부흥반점",
                            "id": 9527,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1273762,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1273762,
                            37.54323599
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 올림픽로80길 37 (천호동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54323599,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-486-3003",
                            "storeName": "파리바게트 암사브라운스톤점",
                            "id": 9528,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1273762,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1273762,
                            37.54323599
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로 311 (암사동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54748423,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-441-0313",
                            "storeName": "김밥천국",
                            "id": 9561,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1346574,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1346574,
                            37.54748423
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로 502",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54904275,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-429-5093",
                            "storeName": "봉구스 밥버거 명일점",
                            "id": 9552,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1539931,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1539931,
                            37.54904275
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로 436 (명일동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.54985925,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-3426-8600",
                            "storeName": "옛날손짜장",
                            "id": 9545,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1467613,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1467613,
                            37.54985925
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로 424",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.55035085,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-441-2272",
                            "storeName": "김밥천국",
                            "id": 9548,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1455808,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1455808,
                            37.55035085
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 구천면로 418(명일동 325-2) 1층",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.55051371,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-429-6288",
                            "storeName": "홍짜장",
                            "id": 9547,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1450288,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1450288,
                            37.55051371
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 올림픽로 689, 104호 (천호동, 해송빌딩)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.5429361,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-472-5704",
                            "storeName": "김가네김밥",
                            "id": 9525,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1247052,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1247052,
                            37.5429361
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 올림픽로 689, 1층 (천호동)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.5429361,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "000-0000-0000",
                            "storeName": "빵이야기",
                            "id": 9526,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1247052,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1247052,
                            37.5429361
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "23:00",
                            "address": "서울특별시 송파구 위례성대로 180, 1층(오금동)",
                            "deliveryEndTime": "23:00",
                            "latitude": 37.51012926,
                            "satOperationEndTime": "23:00",
                            "sigunguCode": "11710",
                            "managementAgencyTel": "02-2147-3811",
                            "gungu": "송파구",
                            "managementAgency": "송파구청 아동돌봄청소년과",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "23:00",
                            "holydayOperationStartTime": "07:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "07:00",
                            "mainOperationStartTime": "07:00",
                            "tel": "02-408-0081",
                            "storeName": "파리바게트",
                            "id": 6552,
                            "deliveryStartTime": "07:00",
                            "longitude": 127.130959,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.130959,
                            37.51012926
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "16:00",
                            "address": "서울특별시 송파구 토성로 65, 1층 106호(풍납2동)",
                            "deliveryEndTime": "20:00",
                            "latitude": 37.52890967,
                            "satOperationEndTime": "20:00",
                            "sigunguCode": "11710",
                            "managementAgencyTel": "02-2147-3811",
                            "gungu": "송파구",
                            "managementAgency": "송파구청 아동돌봄청소년과",
                            "createdAt": "2022-01-09T00:59:27",
                            "mainOperationEndTime": "20:00",
                            "holydayOperationStartTime": "08:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "08:00",
                            "mainOperationStartTime": "08:00",
                            "tel": "02-477-9937",
                            "storeName": "이삭토스트",
                            "id": 6177,
                            "deliveryStartTime": "08:00",
                            "longitude": 127.1173294,
                            "updatedAt": "2022-01-09T00:59:27"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1173294,
                            37.52890967
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "23:00",
                            "address": "서울특별시 송파구 토성로 65, 1층 110호(풍납2동)",
                            "deliveryEndTime": "23:00",
                            "latitude": 37.52890967,
                            "satOperationEndTime": "23:00",
                            "sigunguCode": "11710",
                            "managementAgencyTel": "02-2147-3811",
                            "gungu": "송파구",
                            "managementAgency": "송파구청 아동돌봄청소년과",
                            "createdAt": "2022-01-09T00:59:27",
                            "mainOperationEndTime": "23:00",
                            "holydayOperationStartTime": "07:30",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "07:30",
                            "mainOperationStartTime": "07:30",
                            "tel": "02-488-0480",
                            "storeName": "뚜레쥬르",
                            "id": 6178,
                            "deliveryStartTime": "12:00",
                            "longitude": 127.1173294,
                            "updatedAt": "2022-01-09T00:59:27"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1173294,
                            37.52890967
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 양재대로 1636 (명일동,유한빌딩 1층)",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.55161743,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-3428-8200",
                            "storeName": "파리바게뜨 명일역점",
                            "id": 9542,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1442931,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1442931,
                            37.55161743
                        ]
                    }
                },
                {
                    "type": "Feature",
                    "properties": {
                        "description": {
                            "holydayOperationEndTime": "21:00",
                            "address": "서울특별시 강동구 양재대로147길 7",
                            "deliveryEndTime": "00:00",
                            "latitude": 37.55217337,
                            "satOperationEndTime": "21:00",
                            "sigunguCode": "11740",
                            "managementAgencyTel": "02-3425-5773",
                            "gungu": "강동구",
                            "managementAgency": "서울특별시 강동구",
                            "createdAt": "2022-01-09T00:59:28",
                            "mainOperationEndTime": "21:00",
                            "holydayOperationStartTime": "10:00",
                            "si": "서울특별시",
                            "stoteCode": "1",
                            "satOperationStartTime": "10:00",
                            "mainOperationStartTime": "10:00",
                            "tel": "02-428-2824",
                            "storeName": "다인토속음식점",
                            "id": 9544,
                            "deliveryStartTime": "00:00",
                            "longitude": 127.1435337,
                            "updatedAt": "2022-01-09T00:59:28"
                        },
                        "icon": "theatre-15"
                    },
                    "geometry": {
                        "type": "Point",
                        "coordinates": [
                            127.1435337,
                            37.55217337
                        ]
                    }
                }
            ]
        }
    }
    
    
}
