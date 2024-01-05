import { useContext } from "react"
import { Navigate, Outlet } from "react-router-dom";
import AuthContext from "../../contexts/auth-context";
export default function AuthGuard() {

    if (localStorage.getItem("accessToken")=== null) {
        return <Navigate to="/login" />;
    }

    return <Outlet />;
}