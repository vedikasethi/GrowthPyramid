import React, { useEffect, useState } from "react";
import { Box, Grid, Button, Modal, Typography } from "@mui/material";
import { useParams } from "react-router-dom";

import InfoCard from "./DashBoard/bodyComponents/subComponents/InfoCard";
import TotalSales from "./DashBoard/bodyComponents/Home/TotalSales";
import SalesByCity from "./DashBoard/bodyComponents/Home/SalesByCity";
import CurrentCurrency from "./DashBoard/bodyComponents/Home/CurrentCurrency";
import TopSellingProduct from "./DashBoard/bodyComponents/Home/TopSellingProduct";
import Navbar from "./components/Navbar";

const Company = () => {
    const { id } = useParams();
    const [company, setCompany] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [message, setMessage] = useState("");

    useEffect(() => {
        const fetchCompany = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/company/${id}`);
                if (!response.ok) {
                    throw new Error("Failed to fetch company data");
                }
                const data = await response.json();
                setCompany(data);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };

        fetchCompany();
    }, [id]);

    const handleOpenModal = () => setIsModalOpen(true);
    const handleCloseModal = () => setIsModalOpen(false);

    if (loading) {
        return <div className="flex justify-center items-center h-screen text-xl font-semibold">Loading...</div>;
    }

    if (error) {
        return <div className="flex justify-center items-center h-screen text-red-500 text-xl font-semibold">Error: {error}</div>;
    }

    return (
        <>
            <Navbar />
            <div className="min-h-screen bg-gradient-to-r from-blue-50 to-blue-100 py-10 px-4">
                <div className="max-w-6xl mx-auto bg-white shadow-lg rounded-lg overflow-hidden">
                    <div className="bg-[#05ABB6] text-white text-center py-6">
                        <h1 className="text-3xl font-bold">Company Profile</h1>
                        <p className="text-sm mt-2">Details about the company</p>
                    </div>
                    {company && (
                        <div className="p-6 space-y-6">
                            <div className="flex items-center space-x-4">
                                <div className="w-16 h-16 bg-blue-100 rounded-full flex justify-center items-center text-blue-600 font-bold text-xl">
                                    {company.companyName?.charAt(0)}
                                </div>
                                <div>
                                    <h2 className="text-2xl font-bold text-gray-800">{company.companyName}</h2>
                                    <p className="text-gray-500">{company.category}</p>
                                </div>
                            </div>
                            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                                <div>
                                    <h3 className="text-lg font-semibold text-gray-600">Company Details</h3>
                                    <ul className="mt-2 space-y-2">
                                        <li className="flex justify-between">
                                            <span className="text-gray-600">Company ID:</span>
                                            <span className="text-gray-800">{company.companyId}</span>
                                        </li>
                                        <li className="flex justify-between">
                                            <span className="text-gray-600">Username:</span>
                                            <span className="text-gray-800">{company.username}</span>
                                        </li>
                                        <li className="flex justify-between">
                                            <span className="text-gray-600">Description:</span>
                                            <span className="text-gray-800">{company.description}</span>
                                        </li>
                                        <li className="flex justify-between">
                                            <span className="text-gray-600">Balance:</span>
                                            <span className="text-gray-800">{company.balance}</span>
                                        </li>
                                    </ul>
                                </div>
                                <div>
                                    <h3 className="text-lg font-semibold text-gray-600">Contact Information</h3>
                                    <ul className="mt-2 space-y-2">
                                        <li className="flex justify-between">
                                            <span className="text-gray-600">Contact Name:</span>
                                            <span className="text-gray-800">{company.contactName}</span>
                                        </li>
                                        <li className="flex justify-between">
                                            <span className="text-gray-600">Contact Number:</span>
                                            <span className="text-gray-800">{company.contactNumber}</span>
                                        </li>
                                        <li className="flex justify-between">
                                            <span className="text-gray-600">Contact Mail ID:</span>
                                            <span className="text-gray-800">{company.contactMailId}</span>
                                        </li>
                                        <li className="flex justify-between">
                                            <span className="text-gray-600">Contact Designation:</span>
                                            <span className="text-gray-800">{company.contactDesignation}</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            {!(localStorage.getItem("company") && JSON.parse(localStorage.getItem("company")).companyId === id) && (
                                <Button
                                    variant="contained"
                                    color="primary"
                                    onClick={handleOpenModal}
                                    className="mt-4"
                                    disabled={!localStorage.getItem("company")}
                                >
                                    {localStorage.getItem("company")
                                        ? "Send Collaboration Request"
                                        : "Login to send Collaboration Request"}
                                </Button>
                            )}
                        </div>
                    )}
                </div>

                <Modal open={isModalOpen} onClose={handleCloseModal}>
                    <Box
                        sx={{
                            position: "absolute",
                            top: "50%",
                            left: "50%",
                            transform: "translate(-50%, -50%)",
                            width: 400,
                            bgcolor: "background.paper",
                            boxShadow: 24,
                            p: 4,
                            borderRadius: 2,
                        }}
                    >
                        <Typography variant="h6" component="h2">
                            Send Collaboration Request
                        </Typography>
                        <Typography sx={{ mt: 2 }}>
                            Are you sure you want to send a collaboration request to {company?.companyName}?
                        </Typography>
                        <textarea
                            placeholder="Type your message here..."
                            rows="4"
                            className="w-full mt-3 p-2 border border-gray-300 rounded"
                            onChange={(e) => setMessage(e.target.value)}
                        />
                        <Box sx={{ mt: 3, display: "flex", justifyContent: "flex-end", gap: 2 }}>
                            <Button variant="outlined" onClick={handleCloseModal}>
                                Cancel
                            </Button>
                            <Button
                                variant="contained"
                                color="primary"
                                onClick={async () => {
                                    try {
                                        const response = await fetch("http://localhost:8080/api/collaboration/send", {
                                            method: "POST",
                                            headers: {
                                                "Content-Type": "application/json",
                                            },
                                            body: JSON.stringify({
                                                fromCompanyId: id,
                                                toCompanyId: company.companyId,
                                                message,
                                            }),
                                        });
                                        if (!response.ok) {
                                            throw new Error("Failed to send request");
                                        }
                                        alert("Collaboration request sent successfully!");
                                        handleCloseModal();
                                    } catch (err) {
                                        alert(err.message);
                                    }
                                }}
                            >
                                Send Request
                            </Button>
                        </Box>
                    </Box>
                </Modal>

                <div className="mt-10">
                    <Box sx={{ margin: 0, padding: 3 }}>
                        <Grid container spacing={3}>
                            <Grid item md={8}>
                                <TotalSales id={id} />
                            </Grid>
                            <Grid item md={4}>
                                <SalesByCity id={id} />
                            </Grid>
                        </Grid>
                        <Grid container spacing={3} sx={{ marginTop: 3 }}>
                            <Grid item md={6}>
                                <CurrentCurrency id={id} />
                            </Grid>
                            <Grid item md={6}>
                                <TopSellingProduct id={id} />
                            </Grid>
                        </Grid>
                    </Box>
                </div>
            </div>
        </>
    );
};

export default Company;
