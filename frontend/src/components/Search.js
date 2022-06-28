import React, { useState } from 'react';
import'../style-sheets/Search.css';

function Search() {
    const[showSearch, toogleSearch] = useState(false);
    
    return (
        <div className='search'>
            <div>Cuadro de busqueda</div>
            <div>Cuadro de informacion</div>
        </div>
    )
}

export default Search;