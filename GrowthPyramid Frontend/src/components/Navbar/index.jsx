import { useEffect, useState } from "react";
import NavbarDropdown from "./navbarDropdown";

export default function Navbar() {
  const [isOpen, setIsOpen] = useState(false);
  const [scrollPos, setScrollPos] = useState(0);

  const handleOpen = () => setIsOpen((prev) => !prev);

  const handleScrollPos = () => {
    const currentScrollPos = window.scrollY;

    if (currentScrollPos > scrollPos) {
      setIsOpen(false);
    }

    setScrollPos(currentScrollPos);
  };

  useEffect(() => {
    window.addEventListener("scroll", handleScrollPos);

    return () => {
      window.removeEventListener("scroll", handleScrollPos);
    };
  }, [scrollPos]);

  return (
    <nav className="bg-[#05ABB6] relative">
  <div className="container mx-auto max-w-[1344px] relative">
    <div className="h-16 md:h-20 p-5 md:py-6 lg:px-5 flex items-center justify-between z-20 bg-[#05ABB6] relative">
      

      {/* Hamburger */}
      <div
        onClick={handleOpen}
        className={`${
          isOpen ? "open" : ""
        } flex flex-col items-center w-fit gap-[7px] cursor-pointer md:hidden z-20`}
      >
        <span className="transition-all duration-500 ease-in-out h-[2px] w-5 bg-white rounded-full"></span>
        <span className="transition-all duration-500 ease-in-out h-[2px] w-4 bg-white rounded-full"></span>
        <span className="transition-all duration-500 ease-in-out h-[2px] w-5 bg-white rounded-full"></span>
      </div>

      {/* Menu */}
      <div className="hidden md:flex items-center md:gap-4 lg:gap-8 text-white text-sm lg:text-base font-body">
        <a href="/#" className="navlink">
          Home
        </a>
        <a href="/trending-companies" className="navlink">
          Trending Companies
        </a>
        <a href="/creds" className="navlink active-navlink">
          Buy Creds!
        </a>
      </div>

      {/* Button */}
      <div className="hidden md:flex md:gap-4 lg:gap-[25px] items-center text-sm lg:text-base font-head font-medium">
        <a href="login">
          <p className="text-white underline cursor-pointer">Login</p>
        </a>
        <a href="sign-up">
          <button className="text-[#05ABB6] bg-white md:py-2.5 px-4 py-3.5 px-[25px]">
            Sign up
          </button>
        </a>
      </div>
    </div>

    {/* Navbar Menu (Mobile) */}
    <NavbarDropdown isOpen={isOpen} />
  </div>
</nav>


  );
}
