import * as React from 'react';
import { Card, CardContent, CardMedia, Typography, CardActionArea } from '@mui/material';
import { Link } from 'react-router-dom';

export default function DelBiscuitCard() {
    return (
      <Card sx={{ maxWidth: 400 }}>
        <CardActionArea component={Link} to={"/chat-biscuit"}>
          <CardMedia
            component="img"
            height="180"
            image={"/DelBiscuit.jpg"}  
            alt="Delhi img"
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              Delhi Biscuits
            </Typography>
            <Typography variant="body2" color="text.secondary">
              We sell home made biscuits, we are settled in and comfy.
            </Typography>
          </CardContent>
        </CardActionArea>
      </Card>
    );
}
