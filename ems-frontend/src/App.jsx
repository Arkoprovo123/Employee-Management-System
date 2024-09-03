import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import { FooterComponent } from './components/FooterComponent'
import { HeaderComponent } from './components/HeaderComponent'
import { ListEmployeeComponent } from './components/ListEmployeeComponent'
import { EmployeeComponent } from './components/EmployeeComponent'


function App() {
  
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
            {/* http://localhost:5173 */}
            <Route path='/' element={<ListEmployeeComponent />}></Route>
            {/* http://localhost:5173/employees */}
            <Route path='/employees' element={<ListEmployeeComponent />}></Route>
            {/* http://localhost:5173/add-employee */}
            <Route path='/add-employee' element={<EmployeeComponent />}></Route>
            {/* http://localhost:5173/edit-employee/1 */}
            <Route path='/edit-employee/:id' element={<EmployeeComponent />}></Route>
          </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
