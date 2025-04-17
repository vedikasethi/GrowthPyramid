import React from 'react'
import ReactDOM from 'react-dom/client'
import LandingPage from './landing-page'
import SignUp from './sign-up'
import Creds from './creds'
import Login from './login'
import TrendingCompanies from './trending-companies'
import Resources from './resources'
import CommBlog from './comm-blog'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { GoogleOAuthProvider } from '@react-oauth/google';
import ChatApp from './components/Chat/ChatApp'
import Company from './company'

import UserDashBoard from "./DashBoard/bodyComponents/Home/Home";
import Inventory from "./DashBoard/bodyComponents/Inventory/Inventory";
import Growth from "./DashBoard/bodyComponents/growth/Growth";
import Report from "./DashBoard/bodyComponents/report/Report";
import Setting from "./DashBoard/bodyComponents/Settings/Setting";

import './index.css'


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <GoogleOAuthProvider clientId="YOUR_GOOGLE_CLIENT_ID"> {/* Ensure clientId is provided */}
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<LandingPage />} />
          <Route path='/sign-up' element={<SignUp />} />
          <Route path='/login' element={<Login />} />
          <Route path='/creds' element={<Creds />} />
          <Route path='/trending-companies' element={<TrendingCompanies />} />
          <Route path='/resources' element={<Resources />} />
          <Route path='/blog' element={<CommBlog />} />
          <Route path='/company/:id' element={<Company />} />
          <Route path="/chat-tea" element={<ChatApp room="tea" />} />
          <Route path="/chat-biscuit" element={<ChatApp room="biscuit" />} />
          <Route path="/chat-coffee" element={<ChatApp room="coffee" />} />
          <Route path="/chat-cakes" element={<ChatApp room="cakes" />} />
          <Route path="/dashboard" element={<UserDashBoard />} /> 
          <Route path="/dash-inventory" element={<Inventory />} />
          <Route path="/growth" element={<Growth />} />
          <Route path="/reports" element={<Report />} />
          <Route path="/settings" element={<Setting />} />
        </Routes>
      </BrowserRouter>
    </GoogleOAuthProvider>
  </React.StrictMode>
);