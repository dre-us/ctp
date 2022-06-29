import React, { useState } from 'react';
import Paper from '@mui/material/Paper';
import InputBase from '@mui/material/InputBase';
import IconButton from '@mui/material/IconButton';
import SearchIcon from '@mui/icons-material/Search';
import Box from '@mui/material/Box';
import Stack from '@mui/material/Stack';
import CourseInfo from './CourseInfo';
import TextField  from '@mui/material/TextField';

function Search() {
    // const [showSearch, toogleSearch] = useState(false);
    const [textSearch, setText] = useState("");
    const [course, setCourse] = useState({"id": 'Por buscar',"name":" ","credits":'',"component":'',"approved":false});
    const courses = [
        {"id":1000004,"name":"Cálculo diferencial","credits":4,"component":"Fundamentacion","approved":false},
        {"id":1000005,"name":"Cálculo integral","credits":4,"component":"Fundamentacion","approved":false},
        {"id":1000006,"name":"Cálculo en varias variables","credits":4,"component":"Fundamentacion","approved":false},
        {"id":1000003,"name":"Álgebra lineal","credits":4,"component":"Fundamentacion","approved":false},
        {"id":1000013,"name":"Probabilidad y estadística fundamental","credits":3,"component":"Fundamentacion","approved":false},
        {"id":1000019,"name":"Fundamentos de mecánica","credits":4,"component":"Fundamentacion","approved":false},
        {"id":1000017,"name":"Fundamentos de electricidad y magnetismo","credits":4,"component":"Fundamentacion","approved":false},
        {"id":2015174,"name":"Introducción a la teoria de la computación","credits":4,"component":"Fundamentacion","approved":false},
        {"id":2016696,"name":"Algoritmos","credits":3,"component":"Fundamentacion","approved":false},
        {"id":2025963,"name":"Matemáticas discretas i","credits":4,"component":"Fundamentacion","approved":false},
        {"id":2025964,"name":"Matemáticas discretas ii","credits":4,"component":"Fundamentacion","approved":false},
        {"id":2015702,"name":"Gerencia y gestión de proyectos","credits":3,"component":"Fundamentacion","approved":false},
        {"id":2015970,"name":"Métodos numéricos","credits":3,"component":"Fundamentacion","approved":false},
        {"id":2015703,"name":"Ingeniería económica","credits":3,"component":"Fundamentacion","approved":false},
        {"id":2016375,"name":"Programación orientada a objetos","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2016699,"name":"Estructuras de datos","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2016701,"name":"Ingeniería de software i","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2016702,"name":"Ingeniería de software ii","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2025966,"name":"Lenguajes de programación","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2016716,"name":"Arquitectura de software","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2015734,"name":"Programación de computadores","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2016697,"name":"Arquitectura de computadores","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2016707,"name":"Sistemas operativos","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2025967,"name":"Redes de computadores","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2016722,"name":"Computación paralela y distribuida","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2016353,"name":"Bases de datos","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2025983,"name":"Arquitectura de infraestructura y gobierno de tics","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2016698,"name":"Elementos de computadores","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2025994,"name":"Teoria de la información y sistemas de comunicaciones","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2025982,"name":"Sistemas de información","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2025972,"name":"Introducción a la criptografia y a la seguridad de la información","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2025960,"name":"Computación visual","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2025995,"name":"Introducción a los sistemas inteligentes","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2016703,"name":"Pensamiento sistemico","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2025969,"name":"Modelos estocasticos y simulación en computación y comunicaciones","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2025970,"name":"Modelos y simulación","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2025971,"name":"Optimización","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2025975,"name":"Introducción a la ingeniería de sistemas y computación","credits":3,"component":"Profesional o disciplinar","approved":false},
        {"id":2024045,"name":"Taller de proyectos interdisciplinarios","credits":3,"component":"Profesional o disciplinar","approved":false}];
    const handleChange = e => {
        setText(e.target.value);
    }
    const handleChangeCourse = () => {
        let newCourse = course; 

        for (let i=0; i<courses.length; i++){
            if(courses[i].id.toString()===textSearch){
                newCourse = courses[i];
                console.log('hola')
            }
        }

        setCourse(newCourse);
    }

    return (
        <Box sx={{width: '20%', float: 'right'}}>
            <Stack spacing={2}>
            <Paper
                component="form"
                sx={{p: '2px 4px', display: 'flex', alignItems: 'center', width: '80%'}}
            >
                <TextField
                    sx={{ml: 1, flex: 1}}
                    value={textSearch}
                    variant="outlined"
                    onChange={handleChange}
                />

                <IconButton sx={{p: '10px'}} arial-label="search" onClick={() => handleChangeCourse}>
                    <SearchIcon/> 
                </IconButton>
            </Paper>
                <CourseInfo course={course}/>
            </Stack>
        </Box>
    )
}

export default Search;
