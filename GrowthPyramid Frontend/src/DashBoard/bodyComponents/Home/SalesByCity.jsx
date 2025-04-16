import React, { useEffect, useState } from "react";
import { Box } from "@mui/material";
import ApexCharts from "react-apexcharts";
import axios from "axios";

export default function SalesByCity() {
  const [donutOption, setDonutOption] = useState({
    labels: [],
    legend: {
      position: "right",
      fontSize: "14",
    },
    title: {
      text: "Sales By City",
    },
  });
  const [donutSeries, setDonutSeries] = useState([]);

  useEffect(() => {
    async function fetchData() {
      const user = localStorage.getItem("company");
      if (user) {
        const user = JSON.parse(user);
        try {
          const response = await axios.get("https://localhost:8080/api/analytics/salesbycity/" + user.companyId);
          const data = response.data;

          // Assuming the API returns data in the format:
          // { cities: ["Oujda", "Nador", "Berkan", "Casablanca"], sales: [44, 55, 13, 33] }L̥
          setDonutOption((prev) => ({
            ...prev,
            labels: data.cities,
          }));
          setDonutSeries(data.sales);
        } catch (error) {
          console.error("Error fetching sales by city data:", error);
        }

      }
    }

    fetchData();
  }, [user]);

  return (
    <Box
      sx={{
        margin: 3,
        bgcolor: "white",
        borderRadius: 2,
        padding: 3,
        height: "100%",
      }}
    >
      <ApexCharts
        options={donutOption}
        series={donutSeries}
        type="pie"
        width="100%"
      />
    </Box>
  );
}
