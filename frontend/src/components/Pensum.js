import React, {useState, useEffect} from "react";
import Axios from 'axios';
import'../style-sheets/Pensum.css';
import Semester from './Semester';

function Pensum() {
  const materias1= [{
    id: '100001',
    name: 'Calculo diferencial',
    credits: '4',
    component: 'fundamentacion',
    approved: 'true'
  }, {
    id: '2016703', 
    name: 'Pensamiento sistémico', 
    credits: '3', 
    component: 'profesional o disciplinar', 
    approved: 'true',
  }, {
    id: '0000000', 
    name: 'Libre elección', 
    credits: '3', 
    component: 'libre eleccion', 
    approved: 'true'
  }]

  const materias2= [{
    id: '1000003',
    name: 'Algebra Lineal',
    credits: '4',
    component: 'fundamentacion',
    approved: 'true'
  }, {
    id: '0000000', 
    name: 'Libre elección', 
    credits: '3', 
    component: 'libre eleccion', 
    approved: 'true'    
  }, {
    id: '2016353', 
    name: 'Bases de datos', 
    credits: '3', 
    component: 'profesional o disciplinar', 
    approved: 'true',
  }]

  const materias3= [{
    id: '100005',
    name: 'Calculo integral',
    credits: '4',
    component: 'fundamentacion',
    approved: 'false'
  }, {
    id: '2016699', 
    name: 'Estructura de datos', 
    credits: '3', 
    component: 'profesional o disciplinar', 
    approved: 'false',
  }, {
    id: '0000000', 
    name: 'Libre elección', 
    credits: '3', 
    component: 'libre eleccion', 
    approved: 'false'
  }]

  const materias4= [{
    id: '100006',
    name: 'Calculo en varias variables',
    credits: '4',
    component: 'fundamentacion',
    approved: 'false'
  }, {
    id: '2025963', 
    name: 'Matematicas discretas I', 
    credits: '3', 
    component: 'fundamentacion', 
    approved: 'false',
  }, {
    id: '0000000', 
    name: 'Libre elección', 
    credits: '3', 
    component: 'libre eleccion', 
    approved: 'false'
  }]
  
  let semester2 = { 
    'semesters' : 4,
    'pensum' : [ materias1, materias2, materias3, materias4 ]
    
  }

  //let semester = semester2['pensum'];

  
  const[semester, setSemester] = useState(semester2['pensum']);
  /*
   useEffect(()=>{
    Axios({
      url: `http://localhost:8080/pensum/1`,
    }) 
      .then((response)=>{
        //console.log(response.data['pensum']);
        setSemester(response.data['pensum']);
      }) 
      .catch((error)=>{
        console.log(error);
      });
  }, [setSemester]);
  
  //console.log(semester);
*/
  return(

    <div className='pensum'>

      {semester.map(function(object, i){
        
        return <Semester courses={object} nSemester={i} />
      })}  
      
    </div>
  );

}

// function getData(){

//   let res = axios({
//     url: `http://localhost:8080/pensum/1`,
//     method: 'get',
//     timeout: 8000,
//     headers: {
//         'Content-Type': 'application/json',
//     }
//   })

//   console.log(res.data['pensum']);
  
//   return res.data['pensum'];  
// }

export default Pensum;