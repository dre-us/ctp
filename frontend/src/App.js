import './App.css';
import Header from './components/Header';
import Pensum from './components/Pensum';
import Search from './components/Search';

function App() {
  
  return (
    <div className="App">
      <Header />
      <hr size="2px" color="black" />
      <Pensum />
      <Search />
    </div>
  );
}

export default App;
