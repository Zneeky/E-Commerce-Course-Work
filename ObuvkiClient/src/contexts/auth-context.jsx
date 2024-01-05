import { createContext } from "react";
import { useNavigate } from 'react-router-dom';
import * as authService from '../services/auth-service'; 
import usePersistedState from "../hooks/use-persisted-state";


const AuthContext = createContext();

export const AuthProvider = ({
    children,
}) => {
    const navigate = useNavigate();
    const [auth, setAuth] = usePersistedState('auth', {});

    const loginSubmitHandler = async (values, setErrorMessage) => {
        try {
            const result = await authService.login(values.email, values.password);

            if (result && result.token) {
                setAuth(result);
                localStorage.setItem('accessToken', result.token);
                localStorage.setItem('userId', result.userId);
                localStorage.setItem('userEmail', result.userEmail);
                navigate('/');
            } else {
                // Set the error message to be displayed in  login component
                setErrorMessage("Login failed. Please try again.");
            }
        } catch (error) {
            setErrorMessage(error.message);
        }
    };

    const registerSubmitHandler = async (values,setErrorMessage) => {
        try {
            const result = await authService.register(values.username, values.email, values.password);

            if (result) {
                navigate('/login');
            } else {
                // Set the error message to be displayed in  register component
                setErrorMessage("Registration failed. Please fill all the required fields.");
            }
        } catch (error) {
            setErrorMessage("Registration failed. Please try again.");

        }
    };

    const logoutHandler = () => {

        setAuth({});
        localStorage.clear();

    };

    const values = {
        loginSubmitHandler,
        registerSubmitHandler,
        logoutHandler,
        username: auth.username || auth.email,
        email: auth.email,
        userId: auth._id,
        isAuthenticated: !!auth.accessToken,
    };

    return (
        <AuthContext.Provider value={values}>
            {children}
        </AuthContext.Provider>
    );
};

AuthContext.displayName = 'AuthContext';

export default AuthContext;