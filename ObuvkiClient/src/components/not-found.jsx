import React from 'react';
import { Container, Typography, Button, Box } from '@mui/material';
import { Link } from 'react-router-dom';

function NotFound() {
  return (
    <Container component="main" maxWidth="xs" style={{ marginTop: '100px' }}>
      <Box
        sx={{
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
        }}
      >
        <Typography component="h1" variant="h5">
          404: The page you are looking for isn’t here
        </Typography>
        <Typography variant="subtitle1" style={{ marginTop: '20px' }}>
          You either tried some shady route or you came here by mistake.
          Whichever it is, try using the navigation.
        </Typography>
        <Button 
          variant="contained" 
          color="primary" 
          style={{ marginTop: '30px' }}
          component={Link} 
          to="/"
        >
          Go back home
        </Button>
      </Box>
    </Container>
  );
}

export default NotFound;