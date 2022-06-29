import React, {useState, useEffect} from "react";
import Axios from 'axios';
import'../style-sheets/Pensum.css';
import Semester from './Semester';

<head>
  <script src= 'Header.js'></script>
</head>

function Pensum() {

  const materiaS1= [{
    id: '100001',
    name: 'Cálculo diferencial',
    credits: '4',
    component: 'Fundamentacion',
    approved:false
  }, {
    id: '2016703',
    name: 'Pensamiento sistémico',
    credits: '3',
    component: 'Profesional o disciplinar',
    approved:false,
  }, {
    id:'2025975',
    name: 'Introducción a la ingeniería de sistemas',
    credits:3,
    component:'Profesional o disciplinar',
    approved: false
  }, {
    id:'2015734',
    name:'Programación de computadores',
    credits:3,
    component:'Profesional o disciplinar',
    approved:false
  }]

  const materiaS2P1= [{
      id:'1000019',
      name:'Fundamentos de mecánica',
      credits:4,
      component:'Fundamentacion',
      approved:false
  }, {
      id:'1000005',
      name:'Cálculo integral',
      credits:4,
      component:'Fundamentacion',
      approved:false
  },  {
      id:'1000003',
      name:'Álgebra lineal',
      credits:4,
      component:'Fundamentacion',
      approved:false
  },  {
      id:'2016375',
      name:'Programación orientada a objetos',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  }, {
      id: '0000000',
      name: 'Libre elección',
      credits: '3',
      component: 'Libre eleccion',
      approved:false
  }]

  const materiaS3P1= [{
      id: '0000000',
      name: 'Libre elección',
      credits: '3',
      component: 'Libre eleccion',
      approved:false
  }, {
      id:'1000017',
      name:'Fundamentos de electricidad y magnetismo',
      credits:4,
      component:'Fundamentacion',
      approved:false
  },  {
      id:'1000006',
      name:'Cálculo en varias variables',
      credits:4,
      component:'Fundamentacion',
      approved:false
  },  {
      id:'2025963',
      name:'Matemáticas discretas i',
      credits:4,
      component:'Fundamentacion',
      approved:false
  },  {
      id:'2016353',
      name:'Bases de datos',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id:'2016698',
      name:'Elementos de computadores',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  }]

  const materiaS4P1= [{
      id:'2016697',
      name:'Arquitectura de computadores',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id:'2016699',
      name:'Estructuras de datos',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id: '0000000',
      name: 'Libre elección',
      credits: '3',
      component: 'Libre eleccion',
      approved:false
  },  {
      id:'2025964',
      name:'Matemáticas discretas ii',
      credits:4,
      component:'Fundamentacion',
      approved:false
  },  {
      id:'2015703',
      name:'Ingeniería económica',
      credits:3,
      component:'Fundamentacion',
      approved:false
  },  {
      id:'1000013',
      name:'Probabilidad y estadística fundamental',
      credits:3,
      component:'Fundamentacion',
      approved:false
  }]

  const materiaS5P1= [{
      id:'2025970',
      name:'Modelos y simulación',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id:2015702,
      name:'Gerencia y gestión de proyectos',
      credits:3,
      component:'Fundamentacion',
      approved:false
  },  {
      id: '0000000',
      name: 'Libre elección',
      credits: '3',
      component: 'Libre eleccion',
      approved:false
  },  {
      id:'2025967',
      name:'Redes de computadores',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id:'2016701',
      name:'Ingeniería de software i',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id:'2015174',
      name:'Introducción a la teoria de la computación',
      credits:4,
      component:'Fundamentacion',
      approved:false
  }]

  const materiaS6P1= [{
      id:'2025971',
      name:'Optimización',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id:'2025982',
      name:'Sistemas de información',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id: '0000000',
      name: 'Libre elección',
      credits: '3',
      component: 'Libre eleccion',
      approved:false
  },  {
      id:'2016702',
      name:'Ingeniería de software ii',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id:'2016696',
      name:'Algoritmos',
      credits:3,
      component:'Fundamentacion',
      approved:false
  }]

  const materiaS7P1= [{
      id:'2025995',
      name:'Introducción a los sistemas inteligentes',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id:'2016716',
      name:'Arquitectura de software',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id:'2025994',
      name:'Teoria de la información',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id:'2025983',
      name:'Arquitectura de infraestructura y gobierno de tics',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id:'2025969',
      name:'Modelos estocasticos y simulación ',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  }]

  const materiaS8P1= [{
      id:'2015970',
      name:'Métodos numéricos',
      credits:3,
      component:'Fundamentacion',
      approved:false
  },  {
      id:'2016696',
      name:'Algoritmos',
      credits:3,
      component:'Fundamentacion',
      approved:false
  },  {
      id: '0000000',
      name: 'Libre elección',
      credits: '3',
      component: 'Libre eleccion',
      approved:false
  },  {
      id:'2025966',
      name:'Lenguajes de programación',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  }]

  const materiaS9P1= [{
      id:'2025972',
      name:'Introducción a la criptografia y a la seguridad',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id: '0000000',
      name: 'Libre elección',
      credits: '3',
      component: 'Libre eleccion',
      approved:false
  },  {
      id:'2025960',
      name:'Computación visual',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  },  {
      id:'2016722',
      name:'Computación paralela y distribuida',
      credits:3,
      component:'Profesional o disciplinar',
      approved:false
  }]

  const materiaS2P2= [{
    id: '0000000',
    name: 'Libre elección',
    credits: '3',
    component: 'Libre eleccion',
    approved:false
    }, {
        id:'1000005',
        name:'Cálculo integral',
        credits:4,
        component:'Fundamentacion',
        approved:false
    },  {
        id:'1000003',
        name:'Álgebra lineal',
        credits:4,
        component:'Fundamentacion',
        approved:false
    },  {
        id: '0000000',
        name: 'Libre elección',
        credits: '3',
        component: 'Libre eleccion',
        approved:false
    }]

    const materiaS3P2= [{
        id: '0000000',
        name: 'Libre elección',
        credits: '3',
        component: 'Libre eleccion',
        approved:false
    },{
        id:'2016375',
        name:'Programación orientada a objetos',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    }, {
        id:'1000019',
        name:'Fundamentos de mecánica',
        credits:4,
        component:'Fundamentacion',
        approved:false
    }, {
        id:'1000006',
        name:'Cálculo en varias variables',
        credits:4,
        component:'Fundamentacion',
        approved:false
    },  {
        id:'2025963',
        name:'Matemáticas discretas i',
        credits:4,
        component:'Fundamentacion',
        approved:false
    }]

    const materiaS4P2= [{
        id:'2016353',
        name:'Bases de datos',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },  {
        id:'1000017',
        name:'Fundamentos de electricidad y magnetismo',
        credits:4,
        component:'Fundamentacion',
        approved:false
    },  {
        id:'2016698',
        name:'Elementos de computadores',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },{
        id: '0000000',
        name: 'Libre elección',
        credits: '3',
        component: 'Libre eleccion',
        approved:false
    }]

    const materiaS5P2= [, {
        id:'2016697',
        name:'Arquitectura de computadores',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },  {
        id:'2016699',
        name:'Estructuras de datos',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    }, {
        id:'2025964',
        name:'Matemáticas discretas ii',
        credits:4,
        component:'Fundamentacion',
        approved:false
    },  {
        id:'2015703',
        name:'Ingeniería económica',
        credits:3,
        component:'Fundamentacion',
        approved:false
    },  {
        id:'1000013',
        name:'Probabilidad y estadística fundamental',
        credits:3,
        component:'Fundamentacion',
        approved:false
    }]

    const materiaS6P2= [{
        id:2015702,
        name:'Gerencia y gestión de proyectos',
        credits:3,
        component:'Fundamentacion',
        approved:false
    },  {
        id: '0000000',
        name: 'Libre elección',
        credits: '3',
        component: 'Libre eleccion',
        approved:false
    },  {
        id:'2025967',
        name:'Redes de computadores',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },  {
        id:'2016701',
        name:'Ingeniería de software i',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },  {
        id: '0000000',
        name: 'Libre elección',
        credits: '3',
        component: 'Libre eleccion',
        approved:false
    }]

    const materiaS7P2= [{
        id: '0000000',
        name: 'Libre elección',
        credits: '3',
        component: 'Libre eleccion',
        approved:false
    },  {
        id:'2015174',
        name:'Introducción a la teoria de la computación',
        credits:4,
        component:'Fundamentacion',
        approved:false
    }, {
        id:'2025982',
        name:'Sistemas de información',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },  {
        id: '0000000',
        name: 'Libre elección',
        credits: '3',
        component: 'Libre eleccion',
        approved:false
    },  {
        id:'2016702',
        name:'Ingeniería de software ii',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    }]

    const materiaS8P2= [{
        id:'2015970',
        name:'Métodos numéricos',
        credits:3,
        component:'Fundamentacion',
        approved:false
    },  {
        id:'2016696',
        name:'Algoritmos',
        credits:3,
        component:'Fundamentacion',
        approved:false
    },  {
        id: '0000000',
        name: 'Libre elección',
        credits: '3',
        component: 'Libre eleccion',
        approved:false
    },  {
        id:'2025966',
        name:'Lenguajes de programación',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    }]

    const materiaS9P2= [{
        id:'2016707',
        name:'Sistemas operativos',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },{
        id:'2025970',
        name:'Modelos y simulación',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },  {
        id:'2025995',
        name:'Introducción a los sistemas inteligentes',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },  {
        id:'2016716',
        name:'Arquitectura de software',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    }]


    const materiaS10P2= [{
        id:'2025994',
        name:'Teoria de la información y sistemas',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },  {
        id:'2025983',
        name:'Arquitectura de infraestructura y gobierno de tics',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },  {
        id:'2025971',
        name:'Optimización',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },  {
        id: '0000000',
        name: 'Libre elección',
        credits: '3',
        component: 'Libre eleccion',
        approved:false
    }]

    const materiaS11P2=[{
        id:'2025969',
        name:'Modelos estocasticos y simulación',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    }, {
        id:'2025972',
        name:'Introducción a la criptografia y a la seguridad',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },  {
        id:'2016722',
        name:'Computación paralela y distribuida',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    }]

    const materiaS12P2=[{
        id: '0000000',
        name: 'Libre elección',
        credits: '3',
        component: 'Libre eleccion',
        approved:false
    }, {
        id:'2025960',
        name:'Computación visual',
        credits:3,
        component:'Profesional o disciplinar',
        approved:false
    },  {
        id: '0000000',
        name: 'Libre elección',
        credits: '3',
        component: 'Libre eleccion',
        approved:false
    }]

  let pensums = {
    'pensum1' : [ materiaS1, materiaS2P2, materiaS3P2, materiaS4P2, materiaS5P2, materiaS6P2, materiaS7P2, materiaS8P2, materiaS9P2, materiaS10P2, materiaS11P2, materiaS12P2],
    'pensum2' : [ materiaS1, materiaS2P1, materiaS3P1, materiaS4P1, materiaS5P1, materiaS6P1, materiaS7P1, materiaS8P1, materiaS9P1]
  }

  const[semester, setSemester] = useState(pensums['pensum2']);
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
*/
  return(

    <div className='pensum'>

      {semester.map(function(object, i){
        return <Semester courses={object} nSemester={i} />
      })}
    </div>
  );
}

export default Pensum;
