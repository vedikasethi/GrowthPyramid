import React, { Component } from "react";
import { Box, Grid } from "@mui/material";

import UilReceipt from "@iconscout/react-unicons/icons/uil-receipt";
import UilBox from "@iconscout/react-unicons/icons/uil-box";
import UilTruck from "@iconscout/react-unicons/icons/uil-truck";
import UilCheckCircle from "@iconscout/react-unicons/icons/uil-check-circle";
import InfoCard from "../subComponents/InfoCard";
import TotalSales from "./TotalSales";
import SalesByCity from "./SalesByCity";
import CurrentCurrency from "./CurrentCurrency";
import TopSellingProduct from "./TopSellingProduct";
import Navbar from "../../../components/Navbar";

export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showModal: false,
      modalType: "", // To differentiate between sent and received modals
    };
  }

  componentDidMount() {
    const company = localStorage.getItem("company");
    if (!company) {
      window.location.href = "/login";
    }
    if (company) {
      const parsedUser = JSON.parse(company);
      Promise.all([
        fetch(`http://localhost:8080/api/collaboration/sent/${parsedUser.companyId}`).then((response) => response.json()),
        fetch(`http://localhost:8080/api/collaboration/received/${parsedUser.companyId}`).then((response) => response.json())
      ])
        .then(([sentData, receivedData]) => {
          this.setState({
            sentCollaborations: sentData,
            receivedCollaborations: receivedData,
          });
        })
        .catch((error) => console.error("Error fetching collaborations:", error));
    }
  }

  render() {
    const cardComponent = [
      {
        icon: <UilBox size={60} color={"#F6F4EB"} />,
        title: "Sent Collaborations",
        subTitle: this.state.sentCollaborations?.length || 0,
        mx: 3,
        my: 0,
      },
      {
        icon: <UilTruck size={60} color={"#F6F4EB"} />,
        title: "Received Collaborations",
        subTitle: this.state.receivedCollaborations?.length || 0,
        mx: 5,
        my: 0,
      }
    ];

    return (
      <>
        {/* Navbar at the top */}
        <Navbar />

        {/* Main content */}
        <Box sx={{ margin: 0, padding: 3 }}>
          <Grid
            container
            spacing={2}
            sx={{
              display: "flex",
              justifyContent: "center", // Center horizontally
              alignItems: "center", // Center vertically
              marginX: 3,
              borderRadius: 2,
              padding: 0,
            }}
          >
            {cardComponent.map((card, index) => (
              <Grid
                item
                xs={12}
                sm={6}
                md={3}
                key={index}
                onClick={() => {
                  if (card.title === "Received Collaborations") {
                    this.setState({ showModal: true, modalType: "received" });
                  } else if (card.title === "Sent Collaborations") {
                    this.setState({ showModal: true, modalType: "sent" });
                  }
                }}
              >
                <InfoCard card={card} />
              </Grid>
            ))}
          </Grid>

          <Grid container spacing={2} sx={{ marginX: 3 }}>
            <Grid item xs={12} md={8}>
              <TotalSales />
            </Grid>
            <Grid item xs={12} md={4}>
              <SalesByCity />
            </Grid>
          </Grid>

          <Grid container spacing={2} sx={{ margin: 3 }}>
            <Grid item xs={12} md={6}>
              <CurrentCurrency />
            </Grid>
            <Grid item xs={12} md={6}>
              <TopSellingProduct />
            </Grid>
          </Grid>
        </Box>

        {/* Modal for Collaborations */}
        {this.state.showModal && (
          <Box
            sx={{
              position: "fixed",
              top: 0,
              left: 0,
              width: "100%",
              height: "100%",
              backgroundColor: "rgba(0, 0, 0, 0.5)",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
              zIndex: 1000,
            }}
          >
            <Box
              sx={{
                backgroundColor: "white",
                padding: 4,
                borderRadius: 2,
                width: "50%",
                maxHeight: "80%",
                overflowY: "auto",
              }}
            >
              <h2>
                {this.state.modalType === "received"
                  ? "Pending Collaborations"
                  : "Sent Collaborations"}
              </h2>
              {this.state.modalType === "received" ? (
                this.state.receivedCollaborations.filter(
                  (collaboration) => collaboration.status === "PENDING"
                ).length > 0 ? (
                  this.state.receivedCollaborations
                    .filter((collaboration) => collaboration.status === "PENDING")
                    .map((collaboration) => (
                      <Box
                        key={collaboration.requestId}
                        sx={{
                          display: "flex",
                          justifyContent: "space-between",
                          alignItems: "center",
                          marginBottom: 2,
                          padding: 2,
                          border: "1px solid #ccc",
                          borderRadius: 2,
                        }}
                      >
                        <span>{collaboration.message}</span>
                        <Box>
                          <button
                            onClick={() => {
                              fetch(
                                `http://localhost:8080/api/collaboration/respond/${collaboration.id}?status=ACCEPTED`,
                                { method: "POST" }
                              )
                                .then(() => {
                                  alert("Collaboration accepted!");
                                  this.setState({ showModal: false });
                                })
                                .catch((error) =>
                                  console.error("Error accepting collaboration:", error)
                                );
                            }}
                            style={{
                              marginRight: 8,
                              padding: "5px 10px",
                              backgroundColor: "green",
                              color: "white",
                              border: "none",
                              borderRadius: 4,
                              cursor: "pointer",
                            }}
                          >
                            Accept
                          </button>
                          <button
                            onClick={() => {
                              fetch(
                                `http://localhost:8080/api/collaboration/respond/${collaboration.id}?status=REJECTED`,
                                { method: "POST" }
                              )
                                .then(() => {
                                  alert("Collaboration rejected!");
                                  this.setState({ showModal: false });
                                })
                                .catch((error) =>
                                  console.error("Error rejecting collaboration:", error)
                                );
                            }}
                            style={{
                              padding: "5px 10px",
                              backgroundColor: "red",
                              color: "white",
                              border: "none",
                              borderRadius: 4,
                              cursor: "pointer",
                            }}
                          >
                            Reject
                          </button>
                        </Box>
                      </Box>
                    ))
                ) : (
                  <p>No pending collaborations.</p>
                )
              ) : (
                this.state.sentCollaborations.length > 0 ? (
                  this.state.sentCollaborations.map((collaboration) => (
                    <Box
                      key={collaboration.requestId}
                      sx={{
                        display: "flex",
                        justifyContent: "space-between",
                        alignItems: "center",
                        marginBottom: 2,
                        padding: 2,
                        border: "1px solid #ccc",
                        borderRadius: 2,
                      }}
                    >
                      <span>{collaboration.message}</span>
                      <span>Status: {collaboration.status}</span>
                    </Box>
                  ))
                ) : (
                  <p>No sent collaborations.</p>
                )
              )}
              <button
                onClick={() => this.setState({ showModal: false })}
                style={{
                  marginTop: 16,
                  padding: "5px 10px",
                  backgroundColor: "#ccc",
                  border: "none",
                  borderRadius: 4,
                  cursor: "pointer",
                }}
              >
                Close
              </button>
            </Box>
          </Box>
        )}
      </>
    );
  }
}
