
import React from "react";
import "../../../Asset/Css/mapinfo.css";
import Button from '@material-ui/core/Button';
import {Delete, ZoomOut, ZoomIn} from "@material-ui/icons";
import { storeCodeName } from "./MapUtility";

export default function({data}){


    console.log(data); 

    return (
        <div className="map-info">

                <h4><img src={require('../../../Asset/DreamChildren/store.png').default} style={{width: '17px'}}/> {data.storeName} </h4>
                <div>
                    <img src={require('../../../Asset/DreamChildren/store.png').default} style={{width: '18px'}}/> 가게 타입 : {storeCodeName(data.storeCode)}
                </div>
                <div className="address"> <img src={require('../../../Asset/DreamChildren/address.png').default} style={{width: '18px'}}/> ADDRESS : {data.address} </div>
                <div style={{ whiteSpace: 'pre-wrap' }}></div>
                <div><img src={require('../../../Asset/DreamChildren/smartphone.png').default} style={{width: '18px'}}/> {data.tel} 
                   
                </div>
                <div><img src={require('../../../Asset/DreamChildren/open.png').default} style={{width: '18px'}}/> 평일영업시간 {data.mainOperationStartTime}~{data.mainOperationEndTime} </div>
                <div><img src={require('../../../Asset/DreamChildren/saturday.png').default} style={{width: '18px'}}/> 토요일영업시간 {data.satOperationStartTime}~{data.satOperationEndTime} </div>
                <div><img src={require('../../../Asset/DreamChildren/holiday.png').default} style={{width: '18px'}}/> 휴일영업시간 {data.holydayOperationStartTime}~{data.holydayOperationEndTime} </div>
                <div><img src={require('../../../Asset/DreamChildren/delivery-man.png').default} style={{width: '18px'}}/> 배달영업시간 {data.deliveryStartTime}~{data.deliveryEndTime} </div>
                
            
                {/* <Button variant="contained" color="default" startIcon={<ZoomOut />}>Zoom Out</Button>
                <Button variant="contained" color="default" startIcon={<ZoomIn />}>Zoom In</Button> */}
            </div>
    )
}