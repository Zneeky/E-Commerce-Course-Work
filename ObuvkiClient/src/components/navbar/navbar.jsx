import React, { Component, useContext } from 'react';
import { Link } from 'react-router-dom';
import './navbar.css';
import AuthContext from '../../contexts/auth-context';

export default class Navbar extends Component {
    render() {
        return (
            <AuthContext.Consumer>
                {({ logoutHandler }) => (
                    <NavbarContent logoutHandler={logoutHandler} />
                )}
            </AuthContext.Consumer>
        );
    }
}

const NavbarContent = ({ logoutHandler }) => {
    const isLoggedIn = localStorage.getItem('accessToken');

    return (
        <div className="nav-container">
            {isLoggedIn ? (
                // User is logged in, show logout button
                <Link style={{ textDecoration: 'none' }} to="/login" className="ml-auto" onClick={logoutHandler}>
                    <div className="button-container">
                        <i className="fas fa-sign-out-alt"><i className="georgia">Logout</i></i>
                    </div>
                </Link>
            ) : (
                // User is not logged in, show login button
                <Link to='/login' style={{ textDecoration: 'none' }} className="ml-auto">
                    <div className="button-container">
                        <i className="fas fa-sign-in-alt"><i className="georgia">Login</i></i>
                    </div>
                </Link>
            )}
            <Link to='/'>
                <img src={'/src/assets/logo.png'} alt="store" className="logo" />
            </Link>
            <Link style={{ textDecoration: 'none' }} to="/cart" className="ml-auto">
                <div className="button-container">
                    <i className="fas fa-cart-plus"><i className="georgia">My Cart</i></i>
                </div>
            </Link>
        </div>
    );
};