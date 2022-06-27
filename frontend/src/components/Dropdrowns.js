import React from "react";
import'../style-sheets/Dropdowns.css';

function Dropdowns({type, option}){
  return(
    <div className='dropdown'>
      <center><bold><h5>{type}</h5></bold></center>
      <center><h6>{option}</h6></center>
    </div>
  );
}

export default Dropdowns;