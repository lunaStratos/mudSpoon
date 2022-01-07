
import React from "react";
import "../../../Asset/Css/mapinfo.css";
import Button from '@material-ui/core/Button';
import {Delete, ZoomOut, ZoomIn} from "@material-ui/icons";

export default function({data}){
    return (
        <div className="map-info">

                <h2><img src={require('../../../Asset/Image/client.jpg').default} style={{width: '17px'}}/> {data.storeName}  </h2>
                
                <div className="address"> <img src={require('../../../Asset/Image/client.jpg').default} style={{width: '18px'}}/> ADDRESS : {data.address} </div>
                <div style={{ whiteSpace: 'pre-wrap' }}></div>
                <div><img src={require('../../../Asset/Image/client.jpg').default} /> {data.tel} 
                   
                </div>
                <div><img src={require('../../../Asset/Image/client.jpg').default} /> 평일영업시간 {data.mainOperationStartTime}~{data.mainOperationEndTime} </div>
                <div><img src={require('../../../Asset/Image/client.jpg').default} /> 토요일영업시간 {data.satOperationStartTime}~{data.satOperationEndTime} </div>
                <div><img src={require('../../../Asset/Image/client.jpg').default} /> 휴일영업시간 {data.holydayOperationStartTime}~{data.holydayOperationEndTime} </div>
                <div><img src={require('../../../Asset/Image/client.jpg').default} /> 배달영업시간 {data.deliveryStartTime}~{data.deliveryEndTime} </div>
                <div>
                    <img src={require('../../../Asset/Image/client.jpg').default}/> selected tile price : 
                </div>
                <div>
                    <img src={require('../../../Asset/Image/client.jpg').default} /> selected tile info

                </div>

                {/*초기화 버튼*/}
                <Button variant="contained" color="default" startIcon={<Delete />}>초기화</Button> 
            
                <Button variant="contained" color="default" startIcon={<ZoomOut />}>Zoom Out</Button>
                <Button variant="contained" color="default" startIcon={<ZoomIn />}>Zoom In</Button>
            </div>
    )
}