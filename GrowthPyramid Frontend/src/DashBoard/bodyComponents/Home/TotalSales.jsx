import { Box } from "@mui/material";
import React, { useEffect, useState } from "react";
import ApexCharts from "react-apexcharts";
import axios from "axios";

export default function TotalSales() {
  const [options, setOptions] = useState(null);
  const [series, setSeries] = useState([]);

  useEffect(() => {
    async function fetchData() {
      const user = localStorage.getItem("company");
      if (user) {
        const user = JSON.parse(user);
      try {
        const response = await axios.get("https://localhost:8080/api/analytics/totalsales/" + user.companyId);
        const data = response.data;

        // Sample API response structure:
        // {
        //   "options": {
        //     "chart": {
        //       "id": "basic-line"
        //     },
        //     "xaxis": {
        //       "categories": ["Jan", "Feb", "Mar", "Apr", "May"]
        //     }
        //   },
        //   "series": [
        //     {
        //       "name": "Sales",
        //       "data": [30, 40, 35, 50, 49]
        //     }
        //   ]
        // }

        // Assuming the API response contains `options` and `series` data
        setOptions(data.options);
        setSeries(data.series);
      } catch (error) {
        console.error("Error fetching data:", error);
      }}
    }

    fetchData();
  }, []);

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
