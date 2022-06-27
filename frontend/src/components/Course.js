import React, { useState } from 'react';
import {TbLockOpen} from 'react-icons/tb';
import {TbLock} from 'react-icons/tb';
import {FaSearch} from 'react-icons/fa';
import '../style-sheets/Course.css';

// var approved = false;

function Course({id, name, credits, component, completed}){
  var isComponentB = false;
  if (component === 'Fundamentacion') isComponentB = true;

  var isComponentC = false;
  if (component === 'profesional o disciplinar') isComponentC = true;

  const [approved, setApproved] = useState(false);
  // if(completed === 'true') approved = true;

  return(
    <div className={approved ? 'course approved':'course'}>
      <div className='name-id'>
        <div className='id'><center>{id}</center></div> 
        <div className={isComponentB ? 'background-purple': isComponentC ? 'background-green':'background-blue'}><center>{name}</center></div>
      </div>
      <div className='credits-options'>
        <div className='credits'> <center>{credits}</center></div>
        <button className='state' onClick={() => approved ? setApproved(false) : setApproved(true)}>
          {approved ? <TbLock className='approved-icon'/> : <TbLockOpen className='no-approved-icon'/> }
        </button>
        <button className='search-course'>    
          <FaSearch className='search-course-icon'/>
        </button>
      </div>       
    </div>
  );
}

export default Course;