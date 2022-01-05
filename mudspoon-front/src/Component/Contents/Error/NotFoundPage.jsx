import React from 'react';
import {useNavigate} from "react-router-dom";

/**
 * [404 페이지] 
 * 
 * 404 띄우는 페이지 
 */
export default () => {

   // 뒤로 가기 react-router-dom
   const navigate = useNavigate();

    return(
        <>
         <section className="slider_section ">
               <div className="slider_bg_box">
               </div>
               <div id="customCarousel1" className="carousel slide" data-ride="carousel">
                  <div className="carousel-inner">
                     <div className="carousel-item active">
                        <div className="container ">
                           <div className="row">
                              <div className="col-md-7 col-lg-6 ">
                                 <div className="detail-box">
                                    <h1>
                                       <span>
                                       404 
                                       </span>
                                       <br/>
                                       Not found
                                    </h1>
                                    <p>
                                       404 not Found, 페이지 주소를 확인해주세요. 
                                    </p>
                                    <div className="btn-box">
                                       <a href className="btn1" onClick={(e) => navigate(-1)}>
                                       뒤로가기
                                       </a>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                     
                     
                  </div>
                  <div className="container">
                     <ol className="carousel-indicators">
                        <li data-target="#customCarousel1" data-slide-to="0" className="active"></li>
                        <li data-target="#customCarousel1" data-slide-to="1"></li>
                        <li data-target="#customCarousel1" data-slide-to="2"></li>
                     </ol>
                  </div>
               </div>
            </section>
      

         

         


         
         
        </>
    )
}
