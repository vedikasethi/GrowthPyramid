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

          <div className="hidden md:flex items-center justify-between w-full text-white text-sm lg:text-base font-body">
            <div className="flex items-center gap-4 lg:gap-8">
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
            <div className="flex items-center gap-4 lg:gap-[25px] text-sm lg:text-base font-head font-medium">
              {localStorage.getItem("company") ? (
                <div className="flex items-center gap-4">
                  <p className="text-white">Hi {JSON.parse(localStorage.getItem("company")).username}</p>
                  <a href="/dashboard">
                    <button className="text-[#05ABB6] bg-white py-2.5 px-4">
                      Dashboard
                    </button>
                  </a>
                  <button
                    onClick={() => {
                      localStorage.removeItem("company");
                      window.location.reload();
                    }}
                    className="text-white underline cursor-pointer"
                  >
                    Logout
                  </button>
                </div>
              ) : (
                <div className="flex items-center gap-4">
                  <a href="/login">
                    <p className="text-white underline cursor-pointer">Login</p>
                  </a>
                  <a href="/sign-up">
                    <button className="text-[#05ABB6] bg-white py-2.5 px-4">
                      Sign up
                    </button>
                  </a>
                </div>
              )}
            </div>
          </div>

          <NavbarDropdown isOpen={isOpen} />
        </div>
      </div>
    </nav>
  );
}