import React, { useState } from "react";
import { motion } from "framer-motion";
import { FcGoogle } from "react-icons/fc";
import Navbar from "./components/Navbar"; // Adjust the import path as necessary

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(null);

  const validateEmail = (email) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  };

  const handleLogin = async (e) => {
    e.preventDefault();
    setError(null);

    if (!validateEmail(email)) {
      setError("Please enter a valid email address.");
      return;
    }

    try {
      const response = await fetch("https://309168be-6c2b-4bd4-a582-2d144a24d4bb.mock.pstmn.io/api/collaboration/respond/4?status=ACCEPTED", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }),
      });

      if (response.ok) {
        const data = await response.json();
        // Save user data into local storage using Context API
        localStorage.setItem("company", JSON.stringify(data));
        alert("Login successful!");
        console.log("Server Response:", data);
        window.location.href = "/dashboard";
      } else {
        const errorData = await response.json();
        setError(errorData.message || "Login failed. Please try again.");
      }
    } catch (error) {
      console.error("Error during login:", error);
      setError("An error occurred. Please try again.");
    }
  };

  const handleGoogleSignIn = () => {
    alert("Google Sign-In functionality is not implemented yet.");
  };

  return (
    <>
      {/* Navbar at the top */}
      <Navbar />
      <div className="flex justify-center items-center min-h-screen bg-gray-100 px-4 sm:px-6 lg:px-8">
        <motion.div
          initial={{ opacity: 0, y: -50 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.5 }}
          className="w-full max-w-md bg-white p-8 rounded-xl shadow-md"
        >
          <h2 className="text-2xl font-semibold text-center text-gray-700">Login</h2>
          {error && <p className="text-red-500 text-center mt-2">{error}</p>}

          <form className="mt-6" onSubmit={handleLogin}>
            <div>
              <label className="block text-gray-600">Email</label>
              <input
                type="email"
                className="w-full mt-2 p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>

            <div className="mt-4">
              <label className="block text-gray-600">Password</label>
              <input
                type="password"
                className="w-full mt-2 p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>

            <button
              type="submit"
              className="w-full mt-6 bg-blue-500 text-white py-3 rounded-lg hover:bg-blue-600 transition"
            >
              Login
            </button>
          </form>

          <div className="mt-6 text-center">
            <button
              onClick={handleGoogleSignIn}
              className="w-full flex items-center justify-center gap-3 py-3 bg-gray-100 border rounded-lg hover:bg-gray-200 transition"
            >
              <FcGoogle size={24} />Sign in with Google
            </button>
          </div>
        </motion.div>
      </div>
    </>
  );
}
