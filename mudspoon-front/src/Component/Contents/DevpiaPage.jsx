import React from 'react'

export default () => {
    return(
        <section className="why_section layout_padding">
            <div className="container">
               <div className="heading_container heading_center">
                  <h2>
                     DEVPIA
                  </h2>
               </div>
               <div className="carousel-inner">
                     <div className="carousel-item active">
                        <div className="box col-lg-10 mx-auto">
                           <div className="img_container">
                              <div className="img-box">
                                 <div className="img_box-inner">
                                    <img src={require("../../Asset/Image/client.jpg")} alt=""/>
                                 </div>
                              </div>
                           </div>
                            
                           <div className="detail-box">
                              <h5>
                                 제목
                              </h5>
                              <h6>
                                 작성자
                              </h6>
                              <p>
                                내용들
                              </p>
                           </div>

                        </div>
                     </div>
                     <div className="carousel-item">
                        <div className="box col-lg-10 mx-auto">
                           <div className="img_container">
                              <div className="img-box">
                                 <div className="img_box-inner">
                                 <img src={require("../../Asset/Image/client.jpg")} alt=""/>
                                 </div>
                              </div>
                           </div>
                           <div className="detail-box">
                              <h5>
                                 Anna Trevor
                              </h5>
                              <h6>
                                 Customer
                              </h6>
                              <p>
                                 Dignissimos reprehenderit repellendus nobis error quibusdam? Atque animi sint unde quis reprehenderit, et, perspiciatis, debitis totam est deserunt eius officiis ipsum ducimus ad labore modi voluptatibus accusantium sapiente nam! Quaerat.
                              </p>
                           </div>
                        </div>
                     </div>
                     <div className="carousel-item">
                        <div className="box col-lg-10 mx-auto">
                           <div className="img_container">
                              <div className="img-box">
                                 <div className="img_box-inner">
                                 <img src={require("../../Asset/Image/client.jpg")} alt=""/>
                                 </div>
                              </div>
                           </div>
                           <div className="detail-box">
                              <h5>
                                 Anna Trevor
                              </h5>
                              <h6>
                                 Customer
                              </h6>
                              <p>
                                 Dignissimos reprehenderit repellendus nobis error quibusdam? Atque animi sint unde quis reprehenderit, et, perspiciatis, debitis totam est deserunt eius officiis ipsum ducimus ad labore modi voluptatibus accusantium sapiente nam! Quaerat.
                              </p>
                           </div>
                        </div>
                     </div>
                  </div>
            </div>
         </section>
    )
}
