import React, {Fragment, useEffect, useState} from 'react';
import {Container, Nav, Navbar as BootstrapNavbar} from 'react-bootstrap';
import {Link, useHistory, useLocation, withRouter} from 'react-router-dom';
import AuthService from "../../../service/AuthService";
import {getAuth, onAuthStateChanged} from "firebase/auth";
import {User} from "../../../data/user";
import "./index.css"
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faHome, faShoppingCart, faSignInAlt, faTimes, faUserCircle} from "@fortawesome/free-solid-svg-icons";

type Props = {};

export default function Navbar(props: Props) {
    const [user, setUser] = useState<User | null>(AuthService.user);

    const location = useLocation();
    const history = useHistory();

    useEffect(() => {
        AuthService.onAuthStateChanged((user) => {
            console.log("Narbar onAuthStateChanged", user);
            setUser(user);
        });
    }, []);

    return (
        <div className="navBar">
        <BootstrapNavbar expand="lg">
            <Container>
                <BootstrapNavbar.Brand href="/">
                    FragrantLand
                </BootstrapNavbar.Brand>
                <BootstrapNavbar.Toggle aria-controls="basic-navbar-nav" />
                <BootstrapNavbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Link to="/">
                            <BootstrapNavbar.Text><h4><FontAwesomeIcon icon={faHome}/></h4></BootstrapNavbar.Text>
                        </Link>
                        <Link to="/cart">
                            <BootstrapNavbar.Text><h4><FontAwesomeIcon icon={faShoppingCart}/></h4></BootstrapNavbar.Text>
                        </Link>
                    </Nav>
                    <Nav className="justify-content-end">
                        {
                            (user) ? (
                                <>
                                    <BootstrapNavbar.Text><h4><FontAwesomeIcon icon={faUserCircle}/></h4></BootstrapNavbar.Text>
                                    <BootstrapNavbar.Text
                                        onClick={() => {
                                            AuthService.signOut(() => {
                                                history.push("/")
                                            })
                                        }}
                                    ><h4>
                                        <FontAwesomeIcon icon={faSignInAlt}/>
                                    </h4>
                                    </BootstrapNavbar.Text>
                                </>
                            ) : (
                                <Link to={`/sign-in?from=${location.pathname}`} >
                                    <BootstrapNavbar.Text>Sign In</BootstrapNavbar.Text>
                                </Link>
                            )
                        }
                    </Nav>
                </BootstrapNavbar.Collapse>
            </Container>
        </BootstrapNavbar>
        </div>
    );
}