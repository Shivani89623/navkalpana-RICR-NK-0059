import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function Register() {

  const navigate = useNavigate();

  const [form, setForm] = useState({
    name: "",
    email: "",
    password: "",
    role: "TEACHER"
  });

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value
    });
  };

  const handleRegister = async () => {
    try {
      await axios.post(
        "http://localhost:8080/api/auth/register",
        form
      );
      alert("Registration Successful");
      navigate("/");
    } catch (err) {
      alert("Error while registering");
    }
  };

  return (
    <div>
      <h2>Register</h2>

      <input name="name" placeholder="Name" onChange={handleChange} />
      <input name="email" placeholder="Email" onChange={handleChange} />
      <input name="password" type="password" placeholder="Password" onChange={handleChange} />

      <select name="role" onChange={handleChange}>
        <option value="TEACHER">Teacher</option>
        <option value="ADMIN">Admin</option>
      </select>

      <button onClick={handleRegister}>Register</button>
    </div>
  );
}