import React from 'react';
import {Link } from 'react-router-dom';
import styled from 'styled-components';
import "../../Asset/Css/zzal.css";

const MyBlock = styled.div`
    .wrapper-class{
        width: 564px;
        margin: 0 auto;
        margin-bottom: 4rem;
    }
  .editor {
    height: 500px !important;
    border: 1px solid #f1f1f1 !important;
    padding: 5px !important;
    border-radius: 2px !important;
  }
`;

export default function (props) {

    const useSelectStyle = {"user-select": "auto"}

    return (
        <div>
            <main style={useSelectStyle}>
                
                <div className="communication_all communication_news" style={useSelectStyle}>
                    {/* <!-- list --> */}
                    <article style={useSelectStyle}>
                        <div className="list_title">
                            <div>
                                <h2>라운지</h2>
                                <div>자유롭게 글을 쓰세요</div>
                            </div>
                        </div>
                        <div className="list_write">
                            <div>
                                <textarea>글쓰기 내용 채우기</textarea>
                            </div>
                        </div>
                        <div className="list_write" style={useSelectStyle}>
                            <div style={useSelectStyle}>
                                <div style={useSelectStyle}></div>
                                <div style={useSelectStyle}></div>
                                <ul style={useSelectStyle}>
                                
                                </ul>
                                <div style={useSelectStyle}></div>
                                <div style={useSelectStyle}></div>
                            </div>

                            <div style={useSelectStyle}>
                            <button style={useSelectStyle}>글쓰기!</button>
                            </div>
                        </div>

                        <div className="list_top" style={useSelectStyle}>
                            <div style={useSelectStyle}>전체 : <span style={useSelectStyle}></span>건</div>
                            <div style={useSelectStyle}>
                                <input type="text" style={useSelectStyle} placeholder="검색어를 입력해주세요"  />
                                <button style={useSelectStyle} ></button>
                            </div>
                        </div>
                        

                        {/* <!-- 게시물 map  --> */}

                        <ul style={useSelectStyle}>
                            <li style={useSelectStyle} >
                                <Link to="#"  style={useSelectStyle}>
                                    <div style={useSelectStyle}><img src="" alt="" style={useSelectStyle}/></div>
                                    <div style={useSelectStyle}>
                                        <div style={useSelectStyle}>asd</div>
                                        <div style={useSelectStyle}>asd</div>
                                        <div style={useSelectStyle}>asd</div>
                                    </div>
                                    
                                </Link>
                            </li>

                        </ul>


                    </article>
                    {/* <!-- //list --> */}

                </div>
            </main>

            {/* <!-- 글쓰기 --> */}

            <div id="pop-up_post" style={{display : "none"}} >
                <div style={useSelectStyle}>
                    <div style={useSelectStyle}></div>
                </div>

                <ul style={useSelectStyle}>
                    <li style={useSelectStyle}>
                        <div style={useSelectStyle}>제목</div>
                        <input type="text" style={useSelectStyle} name="title" />
                    </li>
                   
                    <li style={useSelectStyle}>
                        <div style={useSelectStyle}>내용</div>
                        <MyBlock>
                            
                        </MyBlock>
                    </li>

                    <li style={useSelectStyle}>
                        <div style={useSelectStyle}>썸네일</div>
                        <input type="image" name="thumbnailDri"  style={useSelectStyle}/>
                    </li>
                </ul>
                <div class="btn_wrap" style={useSelectStyle} >

                    <button style={useSelectStyle} >삭제</button>

                </div>
            </div>

            {/* <!-- 글쓰기 --> */}


        </div>
    )
}

