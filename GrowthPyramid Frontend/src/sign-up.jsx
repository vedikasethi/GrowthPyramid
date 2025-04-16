import React, { useState } from "react";
import { motion } from "framer-motion";
import { FcGoogle } from "react-icons/fc";
import Navbar from "./components/Navbar"; // Adjust the import path as necessary
export default function SignUp() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [companyName, setCompanyName] = useState("");
  const [category, setCategory] = useState("");
  const [description, setDescription] = useState("");
  const [contactName, setContactName] = useState("");
  const [contactNumber, setContactNumber] = useState("");
  const [contactMailId, setContactMailId] = useState("");
  const [contactDesignation, setContactDesignation] = useState("");
  const [error, setError] = useState(null);

  const handleSignUp = async (e) => {
    e.preventDefault();
    setError(null);
  
    try {
      const response = await fetch("http://localhost:8080/api/company/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          username: email, // Assuming username is the email
          password,
          companyName,
          category,
          description,
          contactName,
          contactNumber,
          contactMailId,
          contactDesignation,
        }),
      });
  
      if (response.ok) {
        alert("Sign-up successful!");
        window.location.href = "./dashboard"; // Redirect to the dashboard
      } else {
        const data = await response.json();
        setError(data.message || "Sign-up failed. Please try again.");
      }
    } catch (err) {
       console.log("Error during sign-up:", err);
    }
  };

  const handleGoogleSignIn = async () => {
    alert("Google Sign-in functionality is not implemented.");
  };

  return (
    <>
      {/* Navbar at the top */}
      <Navbar />
      <div className="flex justify-center items-center h-screen bg-gray-100">
        <motion.div 
          initial={{ opacity: 0, y: -50 }} 
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.5 }}
          className="w-full max-w-4xl bg-white p-8 rounded-xl shadow-md"
        >
          <h2 className="text-2xl font-semibold text-center text-gray-700">Sign Up</h2>
          {error && <p className="text-red-500 text-center mt-2">{error}</p>}
          
          <form className="mt-6 grid grid-cols-1 md:grid-cols-2 gap-4" onSubmit={handleSignUp}>
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
            
            <div>
              <label className="block text-gray-600">Password</label>
              <input
                type="password"
                className="w-full mt-2 p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>

            <div>
              <label className="block text-gray-600">Company Name</label>
              <input
                type="text"
                className="w-full mt-2 p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
                value={companyName}
                onChange={(e) => setCompanyName(e.target.value)}
                required
              />
            </div>

            <div>
              <label className="block text-gray-600">Category</label>
              <select
                className="w-full mt-2 p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
                value={category}
                onChange={(e) => setCategory(e.target.value)}
                required
              >
                <option value="" disabled>Select Category</option>
                <option value="food">Food</option>
                <option value="snack">Snack</option>
              </select>
            </div>

            <div className="md:col-span-2">
              <label className="block text-gray-600">Description</label>
              <textarea
                className="w-full mt-2 p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                required
              />
            </div>

            <div>
              <label className="block text-gray-600">Contact Name</label>
              <input
                type="text"
                className="w-full mt-2 p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
                value={contactName}
                onChange={(e) => setContactName(e.target.value)}
                required
              />
            </div>

            <div>
              <label className="block text-gray-600">Contact Number</label>
              <input
                type="tel"
                className="w-full mt-2 p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
                value={contactNumber}
                onChange={(e) => setContactNumber(e.target.value)}
                required
              />
            </div>

            <div>
              <label className="block text-gray-600">Contact Mail ID</label>
              <input
                type="email"
                className="w-full mt-2 p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
                value={contactMailId}
                onChange={(e) => setContactMailId(e.target.value)}
                required
              />
            </div>

            <div>
              <label className="block text-gray-600">Contact Designation</label>
              <select
                className="w-full mt-2 p-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
                value={contactDesignation}
                onChange={(e) => setContactDesignation(e.target.value)}
                required
              >
                <option value="" disabled>Select Designation</option>
                <option value="admin">Admin</option>
                <option value="owner">Owner</option>
              </select>
            </div>
            
            <div className="md:col-span-2">
              <button
                type="submit"
                className="w-full mt-6 bg-blue-500 text-white py-3 rounded-lg hover:bg-blue-600 transition"
              >
                Sign
            </button>
          </div>
        </form>
        
        <div className="flex items-center my-4">
          <div className="flex-1 border-t"></div>
          <p className="px-2 text-gray-500">OR</p>
          <div className="flex-1 border-t"></div>
        </div>
        
        <button
          onClick={handleGoogleSignIn}
          className="w-full flex items-center justify-center gap-3 py-3 bg-gray-100 border rounded-lg hover:bg-gray-200 transition"
        >
          <FcGoogle size={24} /> Continue with Google
        </button>
      </motion.div>
    </div>
    </>
  );
}
