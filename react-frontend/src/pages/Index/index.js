import React from "react";
import '../Index/index.css';
import indexpic2 from '../../images/Index_img/indexpic2.jpg';
import logo from '../../images/Index_img/logo.png';

export default function Index() {
    return (
        <div className="index_bg">
            <div>
                <h1 className="name">Travee</h1>
            </div>
            <br/>
            <div className="IndexSecondDiv">
                <div className="IndexPicDiv">
                    <img src={indexpic2} className="indexpic" />
                </div>
                <div className="IndexPicPara">
                    <img src={logo} className="logoIndex" />
                    <div className="he1">
                        <p>Your favorite travel buddy</p>
                    </div>
                    <div className="he2">
                        <p>"Travee will manage all the itenerry for you!"</p>
                    </div>
                    <div className="he3">
                        <p onClick={(e) => {
                            e.preventDefault();
                            window.location.href = `/`;
                        }}>www.travee.lk</p>
                    </div>
                </div>
            </div>
            <br /><br />
            <button className="IndexBtn" onClick={(e) => {
                e.preventDefault();
                window.location.href = `/login`;
            }}>LOGIN</button> 
            <br /><br/>
            <p className='FNFooterBottom' style={{ color: "black" }}>
                © 2023 Travee All Rights Reserved.
            </p>

        </div>
    )
}