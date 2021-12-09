import axios from 'axios';
import React, {useState} from 'react';
import "../../Asset/Css/LoginPage.css";

export default () => {

    const [account, setAccount] = useState({
        email: "",
        password: ""
    })

    /** Email, Password 변경 */
    const onChange = (e) =>{

        const value = e.target.value;
        const nameValue = e.target.name;
  
        setAccount({
            ...account, [nameValue]: value
        });

    } 

    /** 로그인 */
    const onSignIn = () =>{
        console.log(account);
        axios.post("http://localhost:8080/api/auth/SignIn", account).then(response => console.log(response))
    
    }

    return(
        <div className="LoginPage">
            <div className="container" id="container">
                <div className="form-container sign-up-container">
                    <form action="#">
                        <h1>Create Account</h1>
                        <div className="social-container">
                            <a href="#" className="social"><i className="fab fa-facebook-f"></i></a>
                            <a href="#" className="social"><i className="fab fa-google-plus-g"></i></a>
                            <a href="#" className="social"><i className="fab fa-linkedin-in"></i></a>
                        </div>
                        <span>or use your email for registration</span>
                        <input type="text" placeholder="Name" />
                        <input type="email" placeholder="Email" />
                        <input type="password" placeholder="Password" />
                        <button>Sign Up</button>
                    </form>
                </div>
                <div className="form-container sign-in-container">
                    <form action="#">
                        <h1>Sign in</h1>
                        <div className="social-container">
                            <a href="#" className="social"><i className="fab fa-naver-n"></i></a>
                            <a href="#" className="social"><i className="fab fa-kakao-k"></i></a>
                        </div>
                        <span>or use your account</span>
                        <input type="email" placeholder="Email" name="email"  onChange={(e) => onChange(e)} />
                        <input type="password" placeholder="Password" name="password"  onChange={(e) => onChange(e)} />
                        <a href="#">Forgot your password?</a>
                        <button onClick={(e) => onSignIn(e) }>Sign In</button>
                    </form>
                </div>
                <div className="overlay-container">
                    <div className="overlay">
                        <div className="overlay-panel overlay-left">
                            <h1>Welcome Back!</h1>
                            <p>To keep connected with us please login with your personal info</p>
                            <button className="ghost" id="signIn">Sign In</button>
                        </div>
                        <div className="overlay-panel overlay-right">
                            <h1>Hello, Friend!</h1>
                            <p>Enter your personal details and start journey with us</p>
                            <button className="ghost" id="signUp">Sign Up</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )

}
