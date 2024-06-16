import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper } from '@mui/material';

export default function Envelope() {
    const envelopeStyle = {padding:"50px 20px", width:600, margin: "20px auto"}
  return (
    <Container>
        <Paper elevation={3} style={envelopeStyle}>
            <h1>Criar envelope</h1>
            <Box
            component="form"
            sx={{
                '& > :not(style)': { m: 1 },
            }}
            noValidate
            autoComplete="off"
            >
            <TextField id="outlined-basic" label="Descrição" variant="outlined" fullWidth />
            <TextField id="outlined-basic" label="Conteúdo" variant="outlined" fullWidth/>
            </Box>
        </Paper>
    </Container>
  );
}
