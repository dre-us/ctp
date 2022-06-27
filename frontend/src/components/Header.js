import React from "react";
import { AiFillPlusSquare } from 'react-icons/ai';
import {FaSearch} from 'react-icons/fa';
import { BsFillQuestionCircleFill } from 'react-icons/bs';
import 'react-tippy/dist/tippy.css';
import { Tooltip } from 'react-tippy';
import'../style-sheets/Header.css';
import Dropdowns from "./Dropdrowns";

function Header(){

  const contentInfo = '<div className="info">CTP busca facilitar la vida de los estudiantes de la Universidad Nacional de Colombia que quieran organizar su vida universitaria, utilizando como punto de partida sus planes de estudio para que lo personalicen con base a la carga académica que ellos prefieran por semestres </br></br> Para tal próposito según la carrera que estés cursando el programa provee una malla con las asignaturas que debes cursar para culminar tu plan de estudios. Cada curso mostrado contiene su identificación y número de creditos en la parte superior, nombre en la parte inferior y dos botones a la derecha: con el candado podrás indicar si la asignatura ya fue cursada mientras que con la lupa podrás buscar información del curso. </br></br> Cada curso puede ser arrastrado de un semestre a otro mientras los prerequisitos de una asignatura no se encuentren dentro del mismo semestre.</br>  Adicinalmente la aplicación cuenta el número de creditos por semestre (mostrado en la parte inferior de cada semestre) y los separa entre las materias obligatorias (izquierda) y las de libre elección (derecha), en caso de no completar la carga mínima o exceder la carga máxima el programa te lanzará una advertencia.</br></br>  Finalmente, se cuentan con dos funciones en la parte superior derecha, el símbolo (+) te permite adicionar materias de libre elección en la malla y el símbolo de lupa abre en la parte derecha el buscador de cursos.</div>';

  return(
    <div className='header-container'>
      <img 
        className='unal-logo'
        src={require('../images/logo-unal.png')}
        alt='Logo Universidad Nacional' />
      <div
        className='header-label' >
        <center><h1>Crea Tu Pensum</h1></center>
        <div
          className='dropdowns-container'>
          <Dropdowns type='Sede' option='Bogotá'/>
          <Dropdowns type='Facultad' option='Ingeniería'/>
          <Dropdowns type='Carrera' option='Ing. de Sistemas'/>
        </div>
      </div> 
      <div className='header-icons'>
        <ion-button >
          <AiFillPlusSquare className='add-course'/>
        </ion-button>

        <ion-button >    
          <FaSearch className='search-course-general'/>
        </ion-button>

        <Tooltip
          title={contentInfo}
          position='left' 
          arrow='false' >
            <ion-button >
              <BsFillQuestionCircleFill className='info-app' />
            </ion-button>
        </Tooltip>
      </div>     
    </div>
  );

}

export default Header;