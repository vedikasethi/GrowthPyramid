import React, { useEffect, useState } from "react";
import {
  Box,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Typography,
} from "@mui/material";
import axios from "axios";
export default function TopSellingProduct() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      const user = localStorage.getItem("company");
      if (user) {
        const parsedUser = JSON.parse(user);
        try {
          const response = await axios.get(
            "http://localhost:8080/api/analytics/topsellingproduct/" + parsedUser.companyId
          );
          const formattedProducts = response.data.map((item) => ({
            name: item[0],
            quantity: item[1],
            amount: item[2],
            price: item[3],
          }));
          setProducts(formattedProducts);
        } catch (error) {
          console.error("Error fetching top selling products:", error);
        }
      }
    };

    fetchProducts();
  }, []);

  return (
    <Box
      sx={{
        margin: 3,
        bgcolor: "white",
        borderRadius: 2,
        padding: 3,
        height: "95%",
      }}
    >
      <Typography variant="h6" fontWeight={"bold"} sx={{ mx: 3 }}>
        Top selling products
      </Typography>
      <TableContainer>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell sx={{ fontWeight: "bolder" }}>Name</TableCell>
              <TableCell sx={{ fontWeight: "bolder" }}>Price</TableCell>
              <TableCell sx={{ fontWeight: "bolder" }}>Quantity</TableCell>
              <TableCell sx={{ fontWeight: "bolder" }}>Amount</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {products.map((product, id) => (
              <TableRow key={id}>
                <TableCell>{product.name}</TableCell>
                <TableCell>{product.price}</TableCell>
                <TableCell>{product.quantity}</TableCell>
                <TableCell>{product.amount}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Box>
  );
}
