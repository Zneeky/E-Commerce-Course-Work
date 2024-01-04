import { Component } from 'react'
import {Link} from 'react-router-dom';
import './navbar.css'

export default class Navbar extends Component {
    render() {
        return (
            <div className="nav-container">
               {<Link to='/'>
                  <img src={'/src/assets/logo.png'} alt="store"  className="logo" />
               </Link>}
                <Link style={{textDecoration: 'none'}} to="/cart" className="ml-auto">
                    <div className="button-container">
                        <i className="fas fa-cart-plus"><i className="georgia">My Cart</i></i>
                    </div>
                </Link>
               <Link style={{textDecoration: 'none'}} to="/cart" className="ml-auto">
                   <div className="button-container">
                       <i className="fas fa-cart-plus"><i className="georgia">My Cart</i></i>
                   </div>
               </Link>
            </div>
        )
    }
}