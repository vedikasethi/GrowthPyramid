import { animate, motion, useInView } from "framer-motion";
import { useEffect, useRef } from "react";
import MainButton from "../Atoms/button";

export default function Hero() {
  const priceRef = useRef(null);
  const isInView = useInView(priceRef);
  const testimonialsRef = useRef(null);

  useEffect(() => {
    if (isInView) {
      const controls = animate(0, 218, {
        duration: 1.2,
        onUpdate(value) {
          if (priceRef.current) {
            priceRef.current.textContent = `$${value.toFixed()}`;
          }
        },
      });

      return () => controls.stop();
    }
  }, [isInView]);

  const scrollToTestimonials = () => {
    if (testimonialsRef.current) {
      testimonialsRef.current.scrollIntoView({ behavior: "smooth", block: "start" });
    }
  };

  const containerImage = {
    visible: {
      opacity: 1,
      x: 0,
      transition: { duration: 0.5, staggerChildren: 0.1, delayChildren: 0.1 },
    },
    hidden: { opacity: 0, x: 200 },
  };

  const containerContent = {
    visible: { x: 0, opacity: 1, transition: { duration: 0.5 } },
    hidden: { x: -100, opacity: 0 },
  };

  const chartContainer = {
    visible: {
      x: 0,
      transition: { duration: 0.5 },
    },
    hidden: {
      x: -100,
    },
  };

  return (
    <div className="container mx-auto max-w-[1344px]">
      <div className="flex flex-col gap-[44px] p-0 py-0 min-h-screen h-auto justify-center md:p-0 lg:px-0 lg:pt-0 lg:pb-0 lg:min-h-fit lg:items-center lg:flex-row lg:justify-between lg:gap-5 overflow-hidden">
        
        {/* Left Section */}
        <motion.div initial="hidden" animate="visible" variants={containerContent} className="flex flex-col items-center lg:items-start gap-8 lg:w-full lg:gap-[34px] relative">
          <section className="flex flex-col gap-3 sm:items-center text-center lg:text-left lg:gap-6 lg:items-start">
            <img className="w-[550px] h-auto object-contain -mt-12" src="/logo-header.png" alt="shopify-icon" />
            <h1 className="text-[42px] leading-[52px] sm:w-4/5 md:text-5xl md:w-4/5 font-bold font-head text-primary-100 lg:text-6xl lg:leading-[70px]">
              The platform businesses are grown on.
            </h1>
            <p className="text-lg font-body text-black-300 sm:w-4/5">
              Millions of the world's most successful brands trust GrowthPyramid to market and connect worldwide at convenience.
            </p>
          </section>

          {/* Buttons
          <div className="w-full flex flex-col sm:w-4/5 md:flex-row justify-center gap-[18px] md:gap-[30px] lg:justify-start lg:w-4/5">
            <MainButton primary={true}>try now !</MainButton>
            <MainButton primary={false} onClick={scrollToTestimonials}>Learn More</MainButton>
          </div> */}
        </motion.div>

        {/* Right Section (Image) */}
        <motion.div initial="hidden" whileInView="visible" variants={containerImage} className="flex items-center justify-center lg:w-full">
          <div className="relative w-fit">
            <img className="w-[400px] h-auto object-cover relative sm:w-[580px] md:w-[723px] rounded-lg shadow-lg" src="helping1.png" alt="hero" />

            {/* Total Sales Card */}
            <motion.div variants={chartContainer} className="absolute top-[28%] left-1 border-[0.5px] border-[#E2E2E2] rounded sales-card bg-white flex flex-col gap-2 font-body p-2 w-[96px] sm:w-[148px] sm:gap-3 sm:p-2.5 md:w-[196px] md:gap-4 md:border md:p-3.5">
              <div className="flex flex-col gap-0.5">
                <h5 className="text-[#515151] text-[5.48px] font-medium sm:text-[8px] md:text-xs">
                  TOTAL SALES
                </h5>
                <div className="w-full flex items-end justify-between">
                  <h4 ref={priceRef} className="text-xs text-[#064A4A] font-bold sm:text-lg md:text-2xl">
                    $218
                  </h4>
                  <img className="w-8 h-auto object-cover sm:w-[52px] md:w-[65px]" src="/chart.svg" alt="chart" />
                </div>
              </div>
              <div className="pt-1 border-t-[0.5px] border-[#C9C9C9] w-full flex items-center justify-between text-[#818181] text-[4.38px] sm:pt-1.5 sm:text-[6.5px] md:pt-2 md:text-[9px]">
                <p>6 total orders</p>
                <p>View report {">"}</p>
              </div>
            </motion.div>
          </div>
        </motion.div>

      </div>
      
      {/* Testimonials Section */}
      <div ref={testimonialsRef} className="pt-20">
        {/* Add testimonials content here */}
      </div>
    </div>
  );
}
