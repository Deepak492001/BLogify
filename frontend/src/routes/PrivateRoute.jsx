import React, { useContext } from "react";
// import { isLoggedIn } from "../service/Authentication";
import { Navigate, Outlet } from "react-router-dom";
import { UserContext } from "../context/UserContext";
import {toast} from "react-hot-toast"
const PrivateRoute = () => {
  const { currentUser } = useContext(UserContext);

  console.log(currentUser.loginStatus);
  if (!currentUser.loginStatus) {
    console.log(currentUser.loginStatus);
    toast.error("Please Do signin First");

    return <Navigate to="/signin" />;
  }

  return <Outlet />;
};

export default PrivateRoute;
