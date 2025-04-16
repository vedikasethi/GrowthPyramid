import Features from "../Features";
import Hero from "../Hero";

export default function Main({ blogRef }) {  // Accept blogRef as a prop
  return (
    <main className="bg-tertiary-300">
      <Hero blogRef={blogRef} /> {/* Now it correctly receives the ref */}
      <Features />
    </main>
  );
}
