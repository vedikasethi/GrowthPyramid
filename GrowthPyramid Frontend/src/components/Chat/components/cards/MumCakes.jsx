import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import { Link } from 'react-router-dom';

export default function MumCakesCard() {
    return (
      <Card sx={{ maxWidth: 400 }}>
        <CardActionArea component={Link} to={"/chat-cakes"}>
          <CardMedia
            component="img"
            height="180"
            image={"/MumCakes.jpg"}  // If using `public/`
            alt="theo logo img"
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              Theobroma
            </Typography>
            <Typography variant="body2" color="text.secondary">
              We are interested in cakes and are open to collabs that go well with our vision and aesthetic.
            </Typography>
          </CardContent>
        </CardActionArea>
      </Card>
    );
}
