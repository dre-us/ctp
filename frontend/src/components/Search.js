import React, { useState } from 'react';
import Paper from '@mui/material/Paper';
import InputBase from '@mui/material/InputBase';
import IconButton from '@mui/material/IconButton';
import SearchIcon from '@mui/icons-material/Search';
import Box from '@mui/material/Box';
import Stack from '@mui/material/Stack';
import CourseInfo from './CourseInfo';

function Search() {
    const [showSearch, toogleSearch] = useState(false);
    const [textSearch, setText] = useState("");
    const [course, setCourse] = useState({"id":1000004,"name":"calculo diferencial","credits":4,"component":"Fundamentacion","approved":false});
    const courses = [{"id":1000004,"name":"calculo diferencial","credits":4,"component":"Fundamentacion","approved":false},{"id":1000005,"name":"calculo integral","credits":4,"component":"Fundamentacion","approved":false},{"id":1000006,"name":"calculo en varias variables","credits":4,"component":"Fundamentacion","approved":false},{"id":1000003,"name":"algebra lineal","credits":4,"component":"Fundamentacion","approved":false},{"id":1000013,"name":"probabilidad y estadistica fundamental","credits":3,"component":"Fundamentacion","approved":false},{"id":1000019,"name":"fundamentos de mecanica","credits":4,"component":"Fundamentacion","approved":false},{"id":1000017,"name":"fundamentos de electricidad y magnetismo","credits":4,"component":"Fundamentacion","approved":false},{"id":2015174,"name":"introduccion a la teoria de la computacion","credits":4,"component":"Fundamentacion","approved":false},{"id":2016696,"name":"algoritmos","credits":3,"component":"Fundamentacion","approved":false},{"id":2025963,"name":"matematicas discretas i","credits":4,"component":"Fundamentacion","approved":false},{"id":2025964,"name":"matematicas discretas ii","credits":4,"component":"Fundamentacion","approved":false},{"id":2015703,"name":"ingenieria economica","credits":3,"component":"Fundamentacion","approved":false},{"id":2015702,"name":"gerencia y gestion de proyectos","credits":3,"component":"Fundamentacion","approved":false},{"id":2015970,"name":"metodos numericos","credits":3,"component":"Fundamentacion","approved":false},{"id":2015703,"name":"ingenieria economica","credits":3,"component":"Fundamentacion","approved":false},{"id":2016375,"name":"programacion orientada a objetos","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2016699,"name":"estructuras de datos","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2016701,"name":"ingenieria de software i","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2016702,"name":"ingenieria de software ii","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2025966,"name":"lenguajes de programacion","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2016716,"name":"arquitectura de software","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2015734,"name":"programacion de computadores","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2016697,"name":"arquitectura de computadores","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2016707,"name":"sistemas operativos","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2025967,"name":"redes de computadores","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2016722,"name":"computacion paralela y distribuida","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2016353,"name":"bases de datos","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2025983,"name":"arquitectura de infraestructura y gobierno de tics","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2016698,"name":"elementos de computadores","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2025994,"name":"teoria de la informacion y sistemas de comunicaciones","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2025982,"name":"sistemas de informacion","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2025972,"name":"introduccion a la criptografia y a la seguridad de la informacion","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2025960,"name":"computacion visual","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2025995,"name":"introduccion a los sistemas inteligentes","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2016703,"name":"pensamiento sistemico","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2025969,"name":"modelos estocasticos y simulacion en computacion y comunicaciones","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2025970,"name":"modelos y simulacion","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2025971,"name":"optimizacion","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2025975,"name":"introduccion a la ingenieria de sistemas y computacion","credits":3,"component":"Profesional o disciplinar","approved":false},{"id":2024045,"name":"taller de proyectos interdisciplinarios","credits":3,"component":"Profesional o disciplinar","approved":false}];
    const handleChange = e => {
        setText(e.tarjet.textSearch);
    }
    const handleChangeCourse = e => {
        setCourse(e);
    }

    return (
        <Box sx={{width: '20%', float: 'right'}}>
            <Stack spacing={2}>
            <Paper
                component="form"
                sx={{p: '2px 4px', display: 'flex', alignItems: 'center', width: '80%'}}
            >
                <InputBase
                    sx={{ml: 1, flex: 1}}
                    value={textSearch}
                    variant="outlined"
                    onChange={handleChange}
                />
                <IconButton type="submit" sx={{p: '10px'}} arial-label="search" onClick={
                    setCourse(
                        courses.filter(object => object.id.toString == textSearch)
                    )
                }>
                    <SearchIcon/>
                </IconButton>
            </Paper>
                <CourseInfo course={course}/>
            </Stack>
        </Box>
    )
}

export default Search;
