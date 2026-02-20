import { useContext } from "react";
import { AuthContext } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

export default function Navbar() {
  const { user, logout } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate("/");
  };

  return (
    <div style={{
      display: "flex",
      justifyContent: "space-between",
      padding: "15px",
      background: "#1e293b",
      color: "white"
    }}>
      <h3>Navkalpana Portal</h3>

      <div>
        <span style={{ marginRight: "20px" }}>
          {user?.name} ({user?.role})
        </span>
        <button onClick={handleLogout}>Logout</button>
      </div>
    </div>
  );
}