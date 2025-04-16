import Navbar from './components/Navbar';
// import MumCakesCard from './components/Chat/components/cards/MumCakes';
// import HydTeaCard from './components/Chat/components/cards/HydTea';
// import MumCoffeeCard from './components/Chat/components/cards/MumCoffee';
// import DelBiscuitCard from './components/Chat/components/cards/DelBiscuit';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import CompanyCard from './components/Chat/components/cards/CompanyCard';

export default function TrendingCompanies() {
    const [companies, setCompanies] = useState([]);


    useEffect(() => {
        axios
          .get(`https://localhost:8080/api/company/list`)
          .then((response) => {
            setCompanies(response.data);
          })
          .catch((error) => {
            console.error('Error fetching companies:', error);
          });
    }, []);


    return (
      <div className="min-h-screen bg-gray-100">
        <Navbar />
        <div className="flex justify-center mt-8">
          <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-2 gap-10 p-2 w-full max-w-6xl">
            {companies.map((company) => (
              <CompanyCard 
              title={company.companyName}
              description={company.description}
              link={company.companyId}
              image={companyId}  />
            ))}
          </div>
        </div>
      </div>
    );
  }