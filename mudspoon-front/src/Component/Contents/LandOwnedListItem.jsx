import React from 'react';

export default function LandOwnedListItem() {
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
                        LAND Title명 표시, 칸을 넘어가면 줄임말로 표시됩니다. 칸을 넘어가면 줄임말로 표시됩니다. 칸을 넘어가면 줄임말로 표시됩니다.
                    </div>

                    <div className="country">
                        <div className="country_icon">
                            <img src={require("../../Asset/Image/country_spmple_img_1.jpg").default} alt="icon"/>
                            Seoul, Republic of KOREA
                        </div>
                        <div className="gps_icon">
                            <img src={require("../../Asset/Image/gps_icon.png").default} alt="icon"/>
                        </div>
                    </div>

                    <div className="price">
                        <div>
                            <img src={require("../../Asset/Image/photo_list_icon_1.png").default} alt="icon"/>
                            67
                        </div>
                        <div>
                            <img src={require("../../Asset/Image/photo_list_icon_2.png").default} alt="icon"/>
                            1.34
                        </div>
                        <div>
                            <img src={require("../../Asset/Image/photo_list_icon_3.png").default} alt="icon"/>
                            154.28
                        </div>
                    </div>

                </div>
            </div>
        </li>
    )
}