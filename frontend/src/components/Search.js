import React, { useState } from 'react';
import Paper from '@mui/material/Paper';
import InputBase from '@mui/material/InputBase';
import IconButton from '@mui/material/IconButton';
import SearchIcon from '@mui/icons-material/Search';
import Box from '@mui/material/Box';
import Stack from '@mui/material/Stack';

function Search() {
    const[showSearch, toogleSearch] = useState(false);

    return (
        <Box sx={{width: '20%', float: 'right'}}>
            <Stack spacing={2}>
            <Paper
                component="form"
                sx={{p: '2px 4px', display: 'flex', alignItems: 'center', width: '80%'}}
            >
                <InputBase
                    sx={{ml: 1, flex: 1}}
                    placeholder="Codigo de curso"
                    inputProps={{'arial-label': 'codigo cde curso'}}
                />
                <IconButton type="submit" sx={{p: '10px'}} arial-label="search">
                    <SearchIcon/>
                </IconButton>
            </Paper>
            <div>Cuadro de informacion</div>
            </Stack>
        </Box>
    )
}

export default Search;
