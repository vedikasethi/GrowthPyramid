import React, { useEffect, useState } from "react";
import { Box } from "@mui/material";
import ApexCharts from "react-apexcharts";
import axios from "axios";

export default function SalesByCity({ id }) {
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
      const companyId = id || (() => {
        const user = localStorage.getItem("company");
        return user ? JSON.parse(user).companyId : null;
      })();

      if (companyId) {
        try {
          const response = await axios.get(`http://localhost:8080/api/analytics/totalsalesbycity/${companyId}`);
          const data = response.data;

          // Transforming the API response to match the required format
          const cities = data.map((item) => item[0]);
          const sales = data.map((item) => item[1]);

          setDonutOption((prev) => ({
            ...prev,
            labels: cities,
          }));
          setDonutSeries(sales);
        } catch (error) {
          console.error("Error fetching sales by city data:", error);
        }
      }
    }

    fetchData();
  }, [id]);

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
