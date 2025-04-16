import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import { Link } from 'react-router-dom';

export default function HydTeaCard() {
    return (
      <Card sx={{ maxWidth: 400 }}>
        <CardActionArea component={Link} to={"/chat-tea"}>
          <CardMedia
            component="img"
            height="180"
            image={"/HydTea.jpg"}  
            alt="hyd tea img"
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="div">
              Royal Irani Tea
            </Typography>
            <Typography variant="body2" color="text.secondary">
              WE love chai aunthetically and wish to find new businesses to work with.
            </Typography>
          </CardContent>
        </CardActionArea>
      </Card>
    );
}