import Banner from "./components/Banner";
import Blog from "./components/Blog";
import Card from "./components/Card";
import Footer from "./components/Footer";
import Main from "./components/Main";
import Navbar from "./components/Navbar";
import Testimonial from "./components/Testimonial";
import { useRef } from "react";

export default function LandingPage() {
  const blogRef = useRef(null);

  return (
    <>
      <Navbar /> {/* Navbar component LOGO AND CREDITS AND LOGIN */}
      <Main blogRef = {blogRef}/> 
      <Testimonial />
      <Blog ref = {blogRef}/>
      <Footer />
    </>
  );
}
