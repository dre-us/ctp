import React, { useState } from 'react';
import  '../style-sheets/Semester.css';
import Course from './Course';
import 'react-tippy/dist/tippy.css';
import { Tooltip } from 'react-tippy';
import { RiErrorWarningFill } from 'react-icons/ri';
import { IconContext } from "react-icons";

function Semester({courses, nSemester}){

  var creditsRequiredPerSemester = 0;
  var creditsFreePerSemester = 0;
  var textMaxCreditsExceeded = 'Estás excediendo el número máximo de creditos permitido';
  var textMinCreditsRequired = 'Faltan creditos por inscribir para superar el límite permitido';

  return(
    <div className='semester'>

      <div className='semester-number'>
        <h3><center>{nSemester+1}</center></h3>
      </div>

      <div className='courses'>
        {courses.map(function(object, i){
          if(object.component==='Libre eleccion') creditsFreePerSemester+=parseInt(object.credits);
          else creditsRequiredPerSemester+=parseInt(object.credits);

          return <Course id={object.id} name={object.name} credits={object.credits} component={object.component} completed={object.approved} />;
        })}

      </div>

      <div className='credits-semester'>
        <div className='credits-required'><h4>{creditsRequiredPerSemester}</h4></div>
        <div className='credits-free-choice'><h4>{creditsFreePerSemester}</h4></div>
      </div>

      <IconContext.Provider value={{ color: 'red'}} >
        <div>
          <center>{creditsFreePerSemester+creditsRequiredPerSemester>20 ?
          <Tooltip
            title={textMaxCreditsExceeded}
            position='bottom'
            arrow='false' >
              <RiErrorWarningFill className='credits-warning'/>
          </Tooltip>
          : creditsFreePerSemester+creditsRequiredPerSemester<10 ?
          <Tooltip
            title={textMinCreditsRequired}
            position='bottom'
            arrow='false' >
              <RiErrorWarningFill className='credits-warning'/>
          </Tooltip>
          : null} </center>
        </div>
      </IconContext.Provider>
    </div>
  );
}

export default Semester;
