import React, { useEffect, useState } from "react";
import { Box, Typography, CircularProgress } from "@mui/material";
import axios from "axios";

export default function CurrentCurrency() {
  const [balance, setBalance] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchCurrency = async () => {
      const user = localStorage.getItem("company");
      if (user) {
        const parsedUser = JSON.parse(user);
        try {
          const response = await axios.get("http://localhost:8080/api/company/" + parsedUser.companyId);
          const data = response.data;
          if (data && data.balance !== undefined) {
            setBalance(data.balance); // Extracting balance from the API response
          } else {
            setError("Invalid data format received from API.");
          }
        } catch (err) {
          setError("Failed to fetch currency data.");
        } finally {
          setLoading(false);
        }
      } else {
        setError("Please Login to View This information.");
        setLoading(false);
      }
    };

    fetchCurrency();
  }, []);

  return (
    <Box
      sx={{
        margin: 3,
        bgcolor: "white",
        borderRadius: 2,
        padding: 3,
        height: "95%",
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
      }}
    >
      {loading ? (
        <CircularProgress />
      ) : error ? (
        <Typography color="error">{error}</Typography>
      ) : (
        <Typography variant="h4" color="primary">
          Current Balance: {balance} Cred Coins
        </Typography>
      )}
    </Box>
  );
}
