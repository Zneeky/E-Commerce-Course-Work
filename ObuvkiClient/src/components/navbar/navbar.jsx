import { Component } from 'react'
import {Link} from 'react-router-dom';
//import logo from '../logo.svg';
import styled from 'styled-components';
import './navbar.css'

export default class Navbar extends Component {
    render() {
        return (
            <div className="nav-container">
               {<Link to='/'>
                  <img src={'/src/assets/logo.png'} alt="store"  className="logo" />
               </Link>}
               <Link to="/cart" className="ml-auto">
                  <div className="button-container">
                      <i className="fas fa-cart-plus">my cart</i>
                  </div>
               </Link>
            </div>
        )
    }
}