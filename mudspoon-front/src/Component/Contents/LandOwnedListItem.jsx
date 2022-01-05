import React from 'react';

export default function LandOwnedListItem({item}) {


    return (
        <li>
            <div>

                <div className="image_wrap">
                    <img className="land_image" src={require("../../Asset/Image/map_sample_2.jpg").default} alt="land image"/>

                    <div className="sale_text text_for_sale">FOR SALE</div>
                    {/*<div className="sale_text text_sold">SOLD</div>*/}
                    {/*<div className="sale_text text_not_for_sale">NOT FOR SALE</div>*/}

                    <div className="level_flag_icon level_flag_A_2"><div>999</div></div>

                    <div className="wish_wrap">
                        <div className="wish_icon">
                            <img className="hide" src={require("../../Asset/Image/wish_icon_on.png").default} alt="on"/>
                            <img src={require("../../Asset/Image/wish_icon_off.png").default} alt="off"/>
                        </div>
                        <div className="bid_icon">
                            <img src={require("../../Asset/Image/bid_icon.png").default} alt="BID"/>
                        </div>
                    </div>
                </div>


                <div className="info_wrap">
                    <div className="title">
                        {item.title}
                    </div>

                    <div className="country">
                        <div className="country_icon">
                            <img src={require("../../Asset/Image/country_spmple_img_1.jpg").default} alt="icon"/>
                            {item.tag}
                        </div>
                        <div className="gps_icon">
                            <img src={require("../../Asset/Image/gps_icon.png").default} alt="icon"/>
                        </div>
                    </div>

                    <div className="price">
                        <div>
                            <img src={require("../../Asset/Image/photo_list_icon_1.png").default} alt="icon"/>
                            {item.length}
                        </div>
                        <div>
                            <img src={require("../../Asset/Image/photo_list_icon_2.png").default} alt="icon"/>
                            {item.size}
                        </div>
                        <div>
                            <img src={require("../../Asset/Image/photo_list_icon_3.png").default} alt="icon"/>
                            {item.download_cnt}
                        </div>
                    </div>

                </div>
            </div>
        </li>
    )
}