import React from 'react';

import LandOwnedListItem from "./LandOwnedListItem";

function onSearchMenu() {
    let hideItemList = document.querySelectorAll(".search_mobile_hide");

    document.querySelector(".mobile_more_btn").classList.toggle("fold");

    hideItemList.forEach((hideItem) =>{
        hideItem.classList.toggle("on");
    });
}

export default function LandOwned() {
    return (
        <section className="sub_page photo_list_page">

            <article className="sub_top_title">
                <div className="center_inner">
                    <div>LAND OWNED</div>
                </div>
            </article>


            <article className="search_container">
                <div className="center_inner">

                    <div onClick={onSearchMenu} className="mobile_more_btn"><img src={require("../../Asset/Image/mobile_more_btn.png").default}  alt=""/></div>

                    <ul className="search_list search_A">
                        <li>
                            <div>Sort by :</div>

                            <div className="input_option_set">

                                <div className="input_wrap">
                                    <input type="text" placeholder="Block Price Low"/>
                                    <button><img src={require("../../Asset/Image/search_icon_B.png").default} alt="icon"/></button>
                                </div>

                                <ul className="option_wrap">
                                    <li>내용1</li>
                                    <li>내용2</li>
                                    <li>내용1</li>
                                    <li>내용2</li>
                                    <li>내용1</li>
                                    <li>내용2</li>
                                </ul>

                            </div>
                        </li>

                        <li className="search_mobile_hide on">
                            <div>LAND Statu :</div>

                            <div className="input_option_set">

                                <div className="input_wrap">
                                    <input type="text" placeholder="Any"/>
                                    <button><img src={require("../../Asset/Image/search_icon_B.png").default} alt="icon"/></button>
                                </div>

                                <ul className="option_wrap">
                                    <li>내용1</li>
                                    <li>내용2</li>
                                    <li>내용1</li>
                                    <li>내용2</li>
                                    <li>내용1</li>
                                    <li>내용2</li>
                                </ul>

                            </div>
                        </li>

                        <li className="search_mobile_hide on">
                            <div>Country :</div>

                            <div className="input_option_set">

                                <div className="input_wrap">
                                    <input type="text" placeholder="All countries"/>
                                    <button><img src={require("../../Asset/Image/search_icon_B.png").default} alt="icon"/></button>
                                </div>

                                <ul className="option_wrap">
                                    <li>내용1</li>
                                    <li>내용2</li>
                                    <li>내용1</li>
                                    <li>내용2</li>
                                    <li>내용1</li>
                                    <li>내용2</li>
                                </ul>

                            </div>
                        </li>

                        <li className="search_mobile_hide on">
                            <div>Search :</div>

                            <div className="input_btn_set">
                                <input type="text" placeholder="search location"/>
                                <button><img src={require("../../Asset/Image/map_search_icon_1.png").default} alt="Search"/></button>
                            </div>
                        </li>
                    </ul>
                </div>
            </article>


            <article className="photo_list_container">
                <div className="center_inner">
                    <div className="tit_wrap">
                        “<span className="red_txt">ALL</span>” Total Lands <span className="blue_txt">500</span>
                    </div>

                    <ul className="photo_list_box">
                        <LandOwnedListItem/>
                        <LandOwnedListItem/>
                        <LandOwnedListItem/>
                        <LandOwnedListItem/>
                        <LandOwnedListItem/>
                        <LandOwnedListItem/>
                        <LandOwnedListItem/>
                    </ul>

                    <div className="page_number_wrap">
                        <ul>
                            <li><img src={require("../../Asset/Image/page_prev_2.png").default} alt="<<"/></li>
                            <li><img src={require("../../Asset/Image/page_prev_1.png").default} alt="<"/></li>
                            <li>1</li>
                            <li>2</li>
                            <li>3</li>
                            <li>4</li>
                            <li>5</li>
                            {/*<li>6</li>*/}
                            {/*<li>7</li>*/}
                            {/*<li>8</li>*/}
                            {/*<li>9</li>*/}
                            {/*<li>10</li>*/}
                            <li><img src={require("../../Asset/Image/page_next_1.png").default} alt=">"/></li>
                            <li><img src={require("../../Asset/Image/page_next_2.png").default} alt=">>"/></li>
                        </ul>
                    </div>

                </div>
            </article>

        </section>
    )
}