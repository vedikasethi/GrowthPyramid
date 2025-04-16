import SubHead from "../Atoms/subhead";
import Subtitle from "../Atoms/subtitle";
import Paragraph from "../Atoms/paragraph";
import FeatureItem from "./featureItem";
import { motion } from "framer-motion";

export default function Features() {
  const dataFeatures = [
    {
      id: 1,
      title: "Smart Inventory Management",
      logo: "/feature-1.svg",
      content:
        "Keep your business organized with real-time stock tracking and automated alerts, ensuring you never run out of essential products.",
    },
    {
      id: 2,
      title: "Google API Insights",
      logo: "/feature-2.svg",
      content:
        "Make data-driven decisions with built-in Google Analytics, helping you track visitor behavior, sales trends, and growth opportunities.",
    },
    {
      id: 3,
      title: "Cred Currency Trading",
      logo: "/feature-3.svg",
      content:
        "Use our in-page Cred currency to trade services, pay for expert help, and collaborate with fellow business owners effortlessly.",
    },
    {
      id: 4,
      title: "Seamless Business Chat",
      logo: "/feature-4.svg",
      content:
        "Connect, network, and get advice instantly with our unique chat system designed for business collaboration and service exchange.",
    },
    {
      id: 5,
      title: "100% Customizable",
      logo: "/feature-5.svg",
      content:
        "Personalize your business page, branding, and service offerings to match your vision and stand out in your industry.",
    },
    {
      id: 6,
      title: "Easy task management",
      logo: "/feature-6.svg",
      content:
        "Stay ahead with continuous improvements and security updates—ensuring your business tools evolve as your needs grow.",
    },
  ];

  const content = {
    visible: { y: 0, opacity: 1, transition: { duration: 1 } },
    hidden: { y: -100, opacity: 0 },
  };

  return (
    <div className="container mx-auto max-w-[1344px]">
      <div className="px-5 py-16 flex flex-col gap-10 sm:pb-28 sm:px-10 md:pb-36">
        {/* Head Content */}
        <motion.div
          initial="hidden"
          whileInView="visible"
          viewport={{ once: true, amount: 0.5 }}
          variants={content}
          className="text-center flex flex-col items-center"
        >
          <Subtitle style="mb-2">360° CUSTOMIZABLE</Subtitle>
          <SubHead style="mb-[18px] sm:w-8/12 md:w-9/12 lg:w-7/12">
            Have full control over your online store
          </SubHead>
          <Paragraph
            fontSize="text-sm"
            color="text-black-400"
            style="sm:w-3/5 md:w-7/12 lg:w-1/3"
          >
            Take total control of your eCommerce business by owning the source
            code and data that drive it.
          </Paragraph>
        </motion.div>

        {/* Feature Items */}
        <div className="grid gap-6 md:gap-8 md:grid-cols-2 lg:grid-cols-3 overflow-hidden">
          {dataFeatures?.map((feature, index) => (
            <FeatureItem key={feature.id} feature={feature} i={index} />
          ))}
        </div>
      </div>
    </div>
  );
}
