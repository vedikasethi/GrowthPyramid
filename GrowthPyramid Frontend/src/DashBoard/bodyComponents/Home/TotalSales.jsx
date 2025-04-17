import { Box } from "@mui/material";
import React, { useEffect, useState } from "react";
import ApexCharts from "react-apexcharts";
import axios from "axios";

export default function TotalSales({ id }) {
  const [options, setOptions] = useState(null);
  const [series, setSeries] = useState([]);

  useEffect(() => {
    async function fetchData() {
      const companyId = id || (() => {
        const userString = localStorage.getItem("company");
        if (userString) {
          const user = JSON.parse(userString);
          return user.companyId;
        }
        return null;
      })();

      if (companyId) {
        try {
          const response = await axios.get("http://localhost:8080/api/analytics/totalsalespermonth/" + companyId);
          const data = response.data;

          // Transform the API response to match the required format
          const categories = data.map(item => item[0]); // Extract month names
          const seriesData = data.map(item => item[1]); // Extract sold quantity amounts

          setOptions({
            chart: {
              id: "basic-line",
            },
            xaxis: {
              categories: categories,
            },
          });

          setSeries([
            {
              name: "Sales",
              data: seriesData,
            },
          ]);
        } catch (error) {
          console.error("Error fetching data:", error);
        }
      }
    }

    fetchData();
  }, [id]);

  if (!options || series.length === 0) {
    return <div>Loading...</div>;
  }

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
        options={options}
        series={series}
        height={300}
        type="line"
        width="100%"
      />
    </Box>
  );
}
