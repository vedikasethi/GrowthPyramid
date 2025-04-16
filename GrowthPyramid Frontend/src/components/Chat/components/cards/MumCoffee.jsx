import * as React from 'react';
import { Card, CardContent, CardMedia, Typography, CardActionArea } from '@mui/material';
import { Link } from 'react-router-dom';

export default function MumCoffeeCard() {
    return (
      <Card sx={{ maxWidth: 400 }}>
        <CardActionArea component={Link} to={"/chat-coffee"}>
          <CardMedia
            component="img"
            height="180"
            image={"/MumCoffee.png"}  
            alt="vivace logo img"
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              Vivace Coffee
            </Typography>
            <Typography variant="body2" color="text.secondary">
              Best Specialty Coffee in town and known to be the best in around, looking for people to vibe.
            </Typography>
          </CardContent>
        </CardActionArea>
      </Card>
    );
}
