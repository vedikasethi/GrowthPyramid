import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import { Link } from 'react-router-dom';

export default function CompanyCard({ title, description, image, link }) {
  return (
    <Card sx={{ maxWidth: 400 }}>
    <CardActionArea component={Link} to={`/company/${link}`}>
      <CardMedia
      component="img"
      height="180"
      image={`/${link}.jpg`}  // Dynamic image
      alt={`${title} logo`}
      />
      <CardContent>
      <Typography gutterBottom variant="h5" component="div">
        {title}  // Dynamic title
      </Typography>
      <Typography variant="body2" color="text.secondary">
        {description}  // Dynamic description
      </Typography>
      </CardContent>
    </CardActionArea>
    </Card>
  );
}
