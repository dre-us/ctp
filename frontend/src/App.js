import './App.css';
import Header from './components/Header';
import Pensum from './components/Pensum';
import {AccessAlarm, ThreeDRotation} from '@mui/icons-material';
import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';

function App() {

  return (
    <div className="App">
      <Header />
      <hr size="2px" color="black" />
      <Pensum />
    </div>
  );
}

export default App;
